package custom.Fluids;


public class Juice extends Fluid
{
	private String flavor;
	
	public Juice(float volume, String flavor)
	{
		super(volume);	//����� ������������ �����������
		this.flavor = flavor;
	}
	
	public String getFlavor()
	{
		return flavor;
	}

	@Override
	public String getType() {
		return flavor + " juice";
	}
	
}
