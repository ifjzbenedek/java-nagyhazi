package Base;

import java.io.Serializable;
import java.util.Random;

public abstract class Item implements Serializable {

	protected boolean pickupable;
	protected String name;
	private Coordinate cord;

	/**
	 * @return	Kisorsol egy random koordinátát.
	 */
	public static Coordinate RandomizeNewItem()
	{
		Random r = new Random();

		return new Coordinate(r.nextInt(20), r.nextInt(20));
	}
	public Item()
	{
		cord = new Coordinate(-1,-1);
	}
	
	//Boolean, mert true esetén falat rakunk le
	public abstract boolean Effect(Snake pickUp, Snake other) throws EmptyException;

	public void setCoordinates(Coordinate c)
	{
		cord = c;
	}
	public Coordinate getCoordinates()
	{
		return cord;
	}
	public boolean getPickupAble()
	{return pickupable;}
	public String getName()
	{return name;}
	
}
