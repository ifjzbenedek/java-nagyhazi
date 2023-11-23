package Base;

import java.io.Serializable;

public class Raspberry extends Item implements Serializable {

	public Raspberry()
	{
		name = "raspberry";
		pickupable = false;
	}
	
	public boolean Effect(Snake pickUp, Snake other) throws EmptyException
	{
		pickUp.IncreaseSize();
		other.DecreaseSize();

		return false;

	}

}