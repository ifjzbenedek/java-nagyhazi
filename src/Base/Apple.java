package Base;

import java.io.Serializable;

public class Apple extends Item implements Serializable {

	public Apple()
	{
		pickupable = false;
		name = "apple";
	}
	
	public boolean Effect(Snake pickUp, Snake other) throws EmptyException
	{

		pickUp.IncreaseSize();


		return false;
	}

}
