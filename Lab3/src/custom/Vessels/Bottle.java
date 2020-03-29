package custom.Vessels;
import custom.Fluids.Fluid;

public class Bottle extends Vessel {
	private String cap;
	
	public Bottle(float vol, String capType, Fluid contains)
	{
		super(vol);
		cap = capType;
		contains.setVolume(vol);
		super.contents = contains;
	}
	
	public String getCapType()
	{
		return cap;
	}
	
}
