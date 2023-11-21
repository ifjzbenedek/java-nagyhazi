package Base;

import java.io.Serializable;

public class Lemon extends Item implements Serializable {

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
