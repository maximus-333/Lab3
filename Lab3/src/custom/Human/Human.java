package custom.Human;
import custom.Fluids.Fluid;
import custom.Shop.Shop;
import custom.Vessels.Vessel;

public class Human 
{
	private String name;
	
	public Human(String name)
	{
		this.name = name;
	}
	
	public void pourLiquid(Vessel source, Vessel dest) 
	{
		dest.acceptLiquid(source.pourOutLiquid(dest.getVolume()));
	}
	
	//Drink entire contents of Vessel, return status message
	public String drinkLiquid(Vessel source)
	{
		Fluid drink = source.pourOutLiquid(source.getVolume());
		if(drink.getVolume() == 0)
			return "No liquid to drink!";

		String result;
		result = "Drank " + drink.getVolume() +
				 " units of " + drink.getType() + "!";
		
		return result;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Vessel buyItem(Shop source, int itemNum)
	{
		Vessel item;
		
		item = source.serveCustomer(itemNum);
		
		return item;
	}
}
