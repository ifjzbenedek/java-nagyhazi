package Base;

import java.util.Objects;

public class Coordinate {

	private int PosX;
	private int PosY;

	public Coordinate(int x, int y)
	{
		PosX = x; PosY = y;
	}
	public int GetPosX()
	{
		return PosX;
	}
	public int GetPosY()
	{
		return PosY;
	}

	
	//tesztelendő
	public boolean equals(Coordinate c)
	{
		if(this == c)
			return true;
		else if(c == null)
			return false;

		
		return Objects.equals(PosX, c.GetPosX()) && Objects.equals(PosY, c.GetPosY());
	}


}
