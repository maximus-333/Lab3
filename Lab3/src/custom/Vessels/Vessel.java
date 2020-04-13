package custom.Vessels;
import custom.Fluids.*;

public class Vessel implements Cloneable
{
	protected Fluid contents = new Fluid(0);
	protected final float volume;
	
	public Vessel(float vol)
	{
		volume = vol;
	}

	public Fluid pourOutLiquid(float amount)
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
	
	public void acceptLiquid(Fluid fluid)
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
	
	
	public float getFluidAmount() {return contents.getVolume();}
	
	public float getVolume() {return volume;}
	
	public String getFluidType() {return contents.getType();}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
