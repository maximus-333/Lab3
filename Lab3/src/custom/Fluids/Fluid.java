package custom.Fluids;


public class Fluid implements Cloneable 
{
	protected float volume;
	
	public Fluid(float vol)
	{
		volume = vol;
	}
	
	public float getVolume()
	{
		return volume;
	}
	
	public void setVolume(float vol)
	{
		volume = vol;
	}

	public String getType()
	{
		return "fluid";
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}
