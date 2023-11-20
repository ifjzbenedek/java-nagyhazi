package Base;

public class Orange extends Item{

    public Orange()
    {
        pickupable = true;
        name = "orange";
    }
    public boolean Effect(Snake thisSnake, Snake otherSnake)
    {
        thisSnake.decreaseSpeed();
        return false;
    }
}
