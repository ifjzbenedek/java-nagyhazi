package Base;

public class EmptyException extends Exception{

	public EmptyException()
	{
		System.out.println
		("The Base.Snake is not movable and it's size can no longer be incresed"
				+ " since it is zero and the player controlling it already lost.");
	}
}
