import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import custom.Human.Human;
import custom.Shop.Shop;
import custom.Vessels.Bottle;
import custom.Vessels.Cup;
import custom.Vessels.Vessel;

public class SwingGUI{
	
	private JFrame frame;
	private JPanel panel;
	private GridBagConstraints gbc = new GridBagConstraints();
	
	//Actor objects
	private Shop shop = new Shop();
	private Human human = new Human("Ivan");
	private Bottle bottle = null;
	private Cup cup = new Cup(2, "plastic");
	
	//Visible elements

	//Shop-related elements
	private JLabel shopInfo = new JLabel("Available purchases:");
	private JTextArea shopStock = new JTextArea(1, 15);
	private JLabel choiceHint = new JLabel("Type item number to buy it:");
	private JTextField itemChoice = new JTextField(10);
		//some labels, idk
	//Item(bottle)-related elements
	private JLabel bottleInfo = new JLabel();
	private JLabel bottleContents = new JLabel();
	//Cup-related elements
	private JLabel cupInfo = new JLabel();
	private JLabel cupContents = new JLabel();
	private JButton fillCupButton = new JButton("Fill");
	//Human-related elements
	private JLabel humanInfo = new JLabel();
	private JLabel humanStatus = new JLabel();
	private JButton humanDrinkButton = new JButton("Drink");
	
	
	
	public SwingGUI() {
		frame = new JFrame("Lab 3");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		panel = new JPanel(new GridBagLayout());
		frame.add(panel);
		
		
		//loads info into shopStock text area
		loadStockInfo();
		
		updateLabels();
		
		humanInfo.setText("Human. Name is " + human.getName());
		
		
		gbc.insets = new Insets(2, 2, 2, 2);
		//Placing GUI elements
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(shopInfo, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		panel.add(shopStock, gbc);
		gbc.gridwidth = 1;
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(choiceHint, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(itemChoice, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(bottleInfo, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel.add(bottleContents, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(cupInfo, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		panel.add(cupContents, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 4;
		panel.add(fillCupButton, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(humanInfo, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		panel.add(humanStatus, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 5;
		panel.add(humanDrinkButton, gbc);
		
		//Assigning actions
		
		fillCupButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				human.pourLiquid(bottle, cup);
				updateLabels();
			}
		});
		
		humanDrinkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = human.drinkLiquid(cup);
				humanStatus.setText(result);
				updateLabels();
			}
		});
		
		itemChoice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//trying to get item number. On fail, output message into same field
				//On success, purchase item under that number
				int option;
				try {
					option = Integer.parseInt(itemChoice.getText());
				}
				catch (NumberFormatException exc){
					option = -1;
				}
				Vessel boughtItem = human.buyItem(shop, option);
				if(boughtItem != null)
				{
					bottle = (Bottle)boughtItem;
				}
				else
				{
					itemChoice.setText("Can't buy item");
				}
				
				updateLabels();
			}
		});

		
		frame.setVisible(true);
	}
	
	
	private void updateLabels() {
		//Updating labels for Bottle
		if(bottle == null)
		{
			bottleInfo.setText("Bottle isn't bought yet");
			bottleContents.setText("");
		}
		else
		{
			bottleInfo.setText("Bottle. Total volume: " + bottle.getVolume() + 
							   ". Contains " + bottle.getFluidType());
			bottleContents.setText("Liquid left: " + bottle.getFluidAmount() + " units");
		}
		
		//Updating labels for Cup
		cupInfo.setText("Cup. Total volume: " + cup.getVolume() 
					  + ". Holder is " + cup.getHolderType());
		if(cup.getFluidAmount() == 0)
		{
			cupContents.setText("The cup is empty.");
		}
		else
		{
			cupContents.setText("Cup has " + cup.getFluidAmount() + 
								" units of " + cup.getFluidType());
		}
	}
	
	
	
	
	//Places all item info in text area, one per line
	private void loadStockInfo() {
		int rows = shop.getItemAmount();
		shopStock.setRows(rows);
		shopStock.setText("");
		shopStock.setEditable(false);
		for(int i = 0; i<rows; i++)
		{
			shopStock.append((i+1) + ") " + shop.getItemInfo(i) + '\n');
		}
		
	}
	
	
}