package custom.Shop;

import javax.naming.InvalidNameException;

import custom.Fluids.Coffee;
import custom.Fluids.Fluid;
import custom.Fluids.Juice;
import custom.Fluids.Tea;
import custom.Fluids.Water;
import custom.Vessels.*;

public class Shop {

	private Vessel stock[];
	
	//Addressing vessels - with name strings.
	//On failure - throw an error
	//On sucess - return predefined object
	
	public Shop(){
		//Will have predefined and infinite stock
		stock = new Vessel[4];
		
		stock[0] = new Bottle(5, "red", new Coffee(0));
		stock[1] = new Bottle(6, "blue", new Tea(0));
		stock[2] = new Bottle(8, "yellow", new Water(0));
		stock[3] = new Bottle(3, "green", new Juice(0, "apple"));
	}
	
	
	public Vessel serveCustomer(int num) 
	{
		//Search the stock, give item or NULL
		if(num >= 1 && num <= stock.length)
		{
			try {
				return giveItem(num - 1);
			}
			catch (CloneNotSupportedException exc){
				exc.printStackTrace();
				return null;
			}
		}
		return null;
		
	}
	
	private Vessel giveItem(int position) throws CloneNotSupportedException
	{
		//clone an object, return it
		return (Vessel)stock[position].clone();
	}
	
	public int getItemAmount() {return stock.length;}
	
	public String getItemInfo(int pos) {
		if(pos >= 0 && pos < stock.length)
			return stock[pos].getFluidAmount() + 
				   " units of " +
				   stock[pos].getFluidType();
		else
			return null;
	}
	
}
