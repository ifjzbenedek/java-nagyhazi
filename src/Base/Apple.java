package Base;

public class Apple extends Item {

	public Apple()
	{
		pickupable = false;
		name = "apple";
	}
	
	public boolean Effect(Snake pickUp, Snake other)
	{

		pickUp.IncreaseSize();


		return false;
	}

}
