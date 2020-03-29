

public class Water extends Fluid
{
	
	Water(float volume)
	{
		super(volume);
	}
	
	@Override
	String getType() {
		return "water";
	}
}
