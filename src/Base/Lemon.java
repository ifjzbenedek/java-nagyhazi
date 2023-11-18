package Base;

public class Lemon extends Item {

	public Lemon(boolean pua)
	{
		super(pua);
		name = "lemon";
	}
	
	public boolean Effect(Snake pickUp, Snake other)
	{
		other.DecreaseSize();
		return false;
	}
	
}
