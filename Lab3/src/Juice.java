

public class Juice extends Fluid
{
	private String flavor;
	
	Juice(float volume, String flavor)
	{
		super(volume);	//Вызов конструктора суперкласса
		this.flavor = flavor;
	}
	
	String getFlavor()
	{
		return flavor;
	}

	@Override
	String getType() {
		return flavor + " juice";
	}
	
}
