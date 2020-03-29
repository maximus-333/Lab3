
public class Vessel 
{
	protected Fluid contents = new Fluid(0);
	public final float volume;
	
	Vessel(float vol)
	{
		volume = vol;
	}

	Fluid pourOutLiquid(float amount)
	{
		Fluid temp = new Fluid(0);
		
		if(amount >= contents.getVolume())
		{
			temp = contents;
			contents = new Fluid(0);
		}
		else
		{
			contents.setVolume(contents.getVolume() - amount);
			try {
				temp = (Fluid)contents.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			temp.setVolume(amount);
		}
		
		return temp;
	}
	
	void acceptLiquid(Fluid fluid)
	{	
		if(fluid.getVolume() == 0)
			return;
		
		//При совпадении жидкостей, объединить. Иначе - вылить первую
		if(this.getClass().equals(fluid.getClass()))
			this.contents.setVolume(this.contents.getVolume() + fluid.getVolume());
		else
			contents = fluid;
		
		if(contents.getVolume() > volume)	//При переполнении, лишняя жидкость выливается
			contents.setVolume(volume);
	}
	
	
	float getFluidAmount()
	{
		return contents.getVolume();
	}
	
	String getFluidType()
	{
		return contents.getType();
	}

}
