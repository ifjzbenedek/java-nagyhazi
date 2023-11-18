package Base;

public class Raspberry extends Item {

	public Raspberry(boolean pua)
	{
		super(pua);
		name = "raspberry";
	}
	
	public boolean Effect(Snake pickUp, Snake other)
	{
		try {
			pickUp.IncreaseSize();
		} catch(EmptyException ee){}
		other.DecreaseSize();
		
		return false;
	}

}