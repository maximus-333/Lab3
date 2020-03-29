

public class Fluid implements Cloneable 
{
	protected float volume;
	
	Fluid(float vol)
	{
		volume = vol;
	}
	
	float getVolume()
	{
		return volume;
	}
	
	void setVolume(float vol)
	{
		volume = vol;
	}

	String getType()
	{
		return "fluid";
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}
