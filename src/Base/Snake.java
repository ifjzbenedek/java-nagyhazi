package Base;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;
public class Snake implements Serializable {

	private ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
	private double moveTimer = 1;
	private Direction direction;

	
	public Snake(ArrayList<Coordinate> startingSnake, Direction d)
	{
		for(Coordinate c: startingSnake) coordinates.add(c);
		
		direction = d;
	}

	public ArrayList<Coordinate> getCoordinates()
	{return coordinates;}

	public double getMoveTimer()
	{return moveTimer;}
	public Direction getDirection()
	{return direction;}
	
	//shows whether the given coordinate is inside the snake 
	//(will be important when deciding whether a snake bumped into another
	//Base.EmptyException megírandó
	boolean IsContained(Coordinate c)
	{
		try {
			if (coordinates.isEmpty())
				throw new EmptyException();

			//checks whether any of the coordinates of the Base.Snake equals to the given coordinate
			for (int i = 0; i < coordinates.size(); i++) {
				if (coordinates.get(i).equals(c))
					return true;
			}

			return false;
		} catch(EmptyException e)
		{}
		return false;
	}


	
	public void AdjustDirection(Direction d)
	{
		this.direction = d;
	}
	
	//Base.EmptyException megírandó
	public void Move()
	{
		try {
			if (coordinates.isEmpty())
				throw new EmptyException();
			Coordinate newHead = new Coordinate(-1, -1);
			switch (direction) {
				case UP:
					newHead = new Coordinate(coordinates.get(0).GetPosX(), coordinates.get(0).GetPosY() - 1);
					System.out.println("FEL" + " " + newHead.GetPosX() + " " + newHead.GetPosY());
					break;
				case DOWN:
					newHead = new Coordinate(coordinates.get(0).GetPosX(), coordinates.get(0).GetPosY() + 1);
					System.out.println("LE" + " " + newHead.GetPosX() + " " + newHead.GetPosY());
					break;
				case LEFT:
					newHead = new Coordinate(coordinates.get(0).GetPosX() - 1, coordinates.get(0).GetPosY());
					System.out.println("BALRA" + " " + newHead.GetPosX() + " " + newHead.GetPosY());
					break;
				case RIGHT:
					newHead = new Coordinate(coordinates.get(0).GetPosX() + 1, coordinates.get(0).GetPosY());
					System.out.println("JOBBRA" + " " + newHead.GetPosX() + " " + newHead.GetPosY());
					break;
			}
			coordinates.add(0, newHead);
			coordinates.remove(coordinates.size() - 1);
			System.out.println("Hossz" + coordinates.size());

		}catch(EmptyException ee)
		{}
	}
	public void IncreaseSize()
	{
		int idxOfLastCord = coordinates.size()-1;
		int idxOfOneBeforeLastCord = coordinates.size()-2;

		
		coordinates.add(new Coordinate(coordinates.get(idxOfLastCord).GetPosX() * 2 - coordinates.get(idxOfOneBeforeLastCord).GetPosX(),
				coordinates.get(idxOfLastCord).GetPosY() * 2 - coordinates.get(idxOfOneBeforeLastCord).GetPosY()));
	}
	public Coordinate getHeadCoordinate()
	{
		return coordinates.get(0);
	}
	//megnézzük minden kör elején, ha true, akkor nyert a másik kígyót irányító player
	public boolean SnakeIsEmpty()
	{
		return coordinates.isEmpty();
	}
	public void DecreaseSize()
	{
		coordinates.remove(coordinates.size()-1);
	}
	public void increaseSpeed()
	{
		moveTimer = 0.7 * moveTimer;
	}

	public void decreaseSpeed()
	{
		moveTimer = 1.3 * moveTimer;
	}
}
