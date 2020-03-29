
public class Bottle extends Vessel {
	private String cap;
	
	Bottle(float vol, String capType, Fluid contains)
	{
		super(vol);
		cap = capType;
		contains.setVolume(vol);
		super.contents = contains;
	}
	
	String getCapType()
	{
		return cap;
	}
	
}
