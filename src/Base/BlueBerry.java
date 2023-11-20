package Base;

public class BlueBerry extends Item{

    public BlueBerry()
    {
        pickupable = true;
        name = "blueberry";
    }
    public boolean Effect(Snake thisSnake, Snake otherSnake)
    {
        thisSnake.increaseSpeed();
        return false;
    }
}
