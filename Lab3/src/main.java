import javax.swing.SwingUtilities;

public class main {
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				new SwingGUI("Ivan", 12, "yellow", 5, "green", "apple", 2, "small");
			}
		});

	}

}
