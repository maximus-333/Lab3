import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingGUI 
{
	private Human human;
	private Bottle bottle1;
	private Bottle bottle2;
	private Cup cup;
	
	//GUI stuff
	private JFrame frame = new JFrame("Test window");
	private JPanel mainPanel = new JPanel(new GridBagLayout());
	private GridBagConstraints gbc = new GridBagConstraints();
	//Visible elements:
	//1st row
	private JLabel bottle1Info = new JLabel();
	private JLabel bottle1Contents = new JLabel();
	private JButton bottle1Button = new JButton("Fill the cup");
	//2nd row
	private JLabel bottle2Info = new JLabel();
	private JLabel bottle2Contents = new JLabel();
	private JButton bottle2Button = new JButton("Fill the cup");
	//3rd row
	private JLabel cupInfo = new JLabel();
	private JLabel cupContents = new JLabel();
	//4th row
	private JLabel humanInfo = new JLabel();
	private JLabel humanReport = new JLabel();
	private JButton humanDrink = new JButton("Drink from cup");
	
	
	SwingGUI(String humanName, float bottle1Vol, String bottle1Cap,
			 float bottle2Vol, String bottle2Cap, String bottle2JuiceType, 
			 float cupVol, String cupHandle)
	{
		//no parameters for now. Gonna add later
		human = new Human(humanName);
		bottle1 = new Bottle(bottle1Vol, bottle1Cap, new Water(0));
		bottle2 = new Bottle(bottle2Vol, bottle2Cap, new Juice(0, bottle2JuiceType));
		cup = new Cup(cupVol, cupHandle);
		
		//Initialize labels that won't change
		bottle1Info.setText("Bottle. Total volume: " + bottle1Vol 
						  + ". Contains " + bottle1.getFluidType());
		bottle2Info.setText("Bottle. Total volume: " + bottle2Vol 
				  		  + ". Contains " + ' ' + bottle2.getFluidType());
		cupInfo.setText("Cup. Total volume: " + cupVol 
					  + ". Holder is " + cup.getHolderType());
		humanInfo.setText("Human. Name is " + human.getName());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.add(mainPanel);
		
		gbc.insets = new Insets(2, 2, 2, 2);
		//Placing window elements
		//row 1
		gbc.gridy = 0;
		gbc.gridx = 0;
		mainPanel.add(bottle1Info, gbc);
		gbc.gridx = 1;
		mainPanel.add(bottle1Contents, gbc);
		gbc.gridx = 2;
		mainPanel.add(bottle1Button, gbc);
		//row 2
		gbc.gridy = 1;
		gbc.gridx = 0;
		mainPanel.add(bottle2Info, gbc);
		gbc.gridx = 1;
		mainPanel.add(bottle2Contents, gbc);
		gbc.gridx = 2;
		mainPanel.add(bottle2Button, gbc);
		//row 3
		gbc.gridy = 2;
		gbc.gridx = 0;
		mainPanel.add(cupInfo, gbc);
		gbc.gridx = 1;
		mainPanel.add(cupContents, gbc);
		//row 4
		gbc.gridy = 3;
		gbc.gridx = 0;
		mainPanel.add(humanInfo, gbc);
		gbc.gridx = 1;
		mainPanel.add(humanReport, gbc);
		gbc.gridx = 2;
		mainPanel.add(humanDrink, gbc);
		
		
		//Setting up actions
		bottle1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				human.pourLiquid(bottle1, cup);
				updateLabels();
			}
		});
		bottle2Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				human.pourLiquid(bottle2, cup);
				updateLabels();
			}
		});
		humanDrink.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = human.drinkLiquid(cup);
				humanReport.setText(result);
				updateLabels();
			}
		});

		updateLabels();
		
		frame.setVisible(true);
	}
	
	
	private void updateLabels()
	{
		bottle1Contents.setText("Liquid left: " + bottle1.getFluidAmount());
		bottle2Contents.setText("Liquid left: " + bottle2.getFluidAmount());

		String cupContentInfo;
		if(cup.getFluidAmount() == 0)
		{
			cupContentInfo = "The cup is empty.";
		}
		else
		{
			cupContentInfo = "Cup has " + cup.getFluidAmount() 
						   + " units of " + cup.getFluidType();
		}
		cupContents.setText(cupContentInfo);
	}
}
