package Base;

public class Lemon extends Item {

	public Lemon()
	{
		name = "lemon";
		pickupable = false;
	}
	
	public boolean Effect(Snake pickUp, Snake other)
	{
		other.DecreaseSize();
		return false;
	}
	
}
