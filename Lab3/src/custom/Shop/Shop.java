package custom.Shop;

import javax.naming.InvalidNameException;

import custom.Vessels.*;

public class Shop {

	private Vessel stock[];
	
	//Addressing vessels - with name strings.
	//On failure - throw an error
	//On sucess - return predefined object
	
	Shop(){
		//Will have predefined and infinite stock
		stock = new Vessel[4];
		
		//initialize with vessels for:
		//coffee
		//tea
		//water
		//(apple) juice
		
		
		
	}
	
	
	Vessel serveCustomer(String productName) 
			throws InvalidNameException, CloneNotSupportedException
	{
		//Search the stock, give item or throw an exception
		
		for(int i = 0;i < stock.length;i++)
		{
			if(productName == stock[i].getFluidType())
			{
				return giveItem(i);
			}			
		}
		
		throw new InvalidNameException("Item not found in stock");
	}
	
	private Vessel giveItem(int position) throws CloneNotSupportedException
	{
		//clone an object, return it
		return (Vessel)stock[position].clone();
	}
	
}
