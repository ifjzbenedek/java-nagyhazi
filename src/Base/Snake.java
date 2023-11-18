package Base;

import java.util.*;
public class Snake {

	private ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
	private double moveTimer;
	private Direction direction;

	
	public Snake(ArrayList<Coordinate> startingSnake, Direction d)
	{
		for(Coordinate c: startingSnake) coordinates.add(c);
		
		direction = d;
	}
	
	//gives back the snake's head's coordinate
	//Base.EmptyException megírandó
	public Coordinate GetHeadCoordinate() throws EmptyException
	{
		if(coordinates.isEmpty())
			throw new EmptyException();
		else
			return coordinates.get(0);
	}
	
	
	//shows whether the given coordinate is inside the snake 
	//(will be important when deciding whether a snake bumped into another
	//Base.EmptyException megírandó
	boolean IsContained(Coordinate c) throws EmptyException
	{
		if(coordinates.isEmpty())
			throw new EmptyException();
		
		//checks whether any of the coordinates of the Base.Snake equals to the given coordinate
		for(int i = 0; i < coordinates.size(); i++)
		{
			if(coordinates.get(i).equals(c))
				return true;
		}
		
		return false;
	}
	
	public void AdjustDirection(Direction d)
	{
		this.direction = d;
	}
	
	//Base.EmptyException megírandó
	public void Move() throws EmptyException
	{
		if(coordinates.isEmpty())
			throw new EmptyException();
		Coordinate newHead = new Coordinate(-1, -1);
		switch(direction)
		{
			case UP: newHead = new Coordinate(coordinates.get(0).GetPosX(),coordinates.get(0).GetPosY() + 1);
			case DOWN: newHead = new Coordinate(coordinates.get(0).GetPosX(),coordinates.get(0).GetPosY() - 1);
			case LEFT: newHead = new Coordinate(coordinates.get(0).GetPosX() - 1,coordinates.get(0).GetPosY());
			case RIGHT: newHead = new Coordinate(coordinates.get(0).GetPosX() + 1,coordinates.get(0).GetPosY());
		}
		coordinates.add(0, newHead);
		coordinates.remove(coordinates.size() - 1);
	}
	public void IncreaseSize() throws EmptyException
	{
		int idxOfLastCord = coordinates.size()-1;
		int idxOfOneBeforeLastCord = coordinates.size()-2;
		
		if(coordinates.isEmpty())
			throw new EmptyException();
		
		coordinates.add(new Coordinate(coordinates.get(idxOfLastCord).GetPosX() * 2 - coordinates.get(idxOfOneBeforeLastCord).GetPosX(),
				coordinates.get(idxOfLastCord).GetPosY() * 2 - coordinates.get(idxOfOneBeforeLastCord).GetPosY()));
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
		moveTimer *= 0.8;
	}

	public void decreaseSpeed()
	{
		moveTimer += 10*(2/moveTimer);
	}
}
