package custom.Fluids;


public class Water extends Fluid
{
	
	public Water(float volume)
	{
		super(volume);
	}
	
	@Override
	public String getType() {
		return "water";
	}
}
