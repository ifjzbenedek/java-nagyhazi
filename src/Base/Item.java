package Base;

import java.util.Random;

public abstract class Item {

	protected boolean pickupable;
	protected String name;
	private Coordinate cord;

	private Coordinate RandomizeNewItem()
	{
		Random r = new Random();

		return new Coordinate(r.nextInt(19), r.nextInt(19));
	}
	public Item(boolean pua)
	{
		pickupable = pua;
		cord = RandomizeNewItem();
	}
	
	//Boolean, mert true esetén falat rakunk le
	public abstract boolean Effect(Snake pickUp, Snake other);


	
}
