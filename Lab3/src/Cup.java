
public class Cup extends Vessel {
	private final String holder;
	
	Cup(float vol, String holder)
	{
		super(vol);
		this.holder = holder;
	}
	
	String getHolderType()
	{
		return holder;
	}
}
