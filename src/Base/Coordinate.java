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
	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		else if(this == null)
			return false;
		
		Coordinate c = (Coordinate)o;
		
		return Objects.equals(PosX, c.GetPosX()) && Objects.equals(PosY, c.GetPosY());
	}


}
