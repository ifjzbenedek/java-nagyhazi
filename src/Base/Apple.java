package Base;

public class Apple extends Item {

	public Apple(boolean pua)
	{
		super(pua);
		name = "apple";
	}
	
	public boolean Effect(Snake pickUp, Snake other)
	{
		try {
			pickUp.IncreaseSize();
		} catch(EmptyException ee){}
		
		return false;
	}

}
