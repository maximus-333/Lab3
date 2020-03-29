package custom.Vessels;

public class Cup extends Vessel {
	private final String holder;
	
	public Cup(float vol, String holder)
	{
		super(vol);
		this.holder = holder;
	}
	
	public String getHolderType()
	{
		return holder;
	}
}
