package Base;

public class Raspberry extends Item {

	public Raspberry()
	{
		name = "raspberry";
		pickupable = false;
	}
	
	public boolean Effect(Snake pickUp, Snake other)
	{
		pickUp.IncreaseSize();
		other.DecreaseSize();

		return false;

	}

}