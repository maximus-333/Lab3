

public class Human 
{
	private String name;
	
	Human(String name)
	{
		this.name = name;
	}
	
	void pourLiquid(Vessel source, Vessel dest) 
	{
		dest.acceptLiquid(source.pourOutLiquid(dest.volume));
	}
	
	//Drink entire contents of Vessel, return status message
	String drinkLiquid(Vessel source)
	{
		Fluid drink = source.pourOutLiquid(source.volume);
		if(drink.getVolume() == 0)
			return "No liquid to drink!";

		String result;
		result = "Drank " + drink.getVolume() +
				 "units of " + drink.getClass().getName() + "!";
		
		return result;
	}
	
	String getName()
	{
		return name;
	}
	
}
