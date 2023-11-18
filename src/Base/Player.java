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
	public void setOwnedPickUpAble(Item i)
	{
		ownedPickUpAble = i;
	}
}
