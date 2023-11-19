package Base;

public class Player {
	private Item ownedPickUpAble;
	private Snake snake;
	private String name;

	char selfActivateAndWall;
	char opponentActivate;
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
	}
	public Item getOwnedPickUpAble()
	{
		if(ownedPickUpAble != null)
			return ownedPickUpAble;

		return null;
	}

}
