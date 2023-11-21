package Base;

import java.io.Serializable;

public class Player implements Serializable {
	private Item ownedPickUpAble;
	private boolean haspickUpAble = false;
	private Snake snake;
	private String name;

	public Player(Snake s, String n)
	{
		name = n;
		snake = s;
	}
	public Snake getSnake()
	{
		return snake;
	}
	public void setOwnedPickUpAble(Item i)
	{
		ownedPickUpAble = i;
		haspickUpAble = true;
	}
	public boolean gethasPicUpAble()
	{
		return haspickUpAble;
	}
	public void sethasPickUpAble(boolean tf)
	{
		haspickUpAble = tf;
	}
	public Item getOwnedPickUpAble()
	{
		if(ownedPickUpAble != null)
			return ownedPickUpAble;

		return null;
	}

}
