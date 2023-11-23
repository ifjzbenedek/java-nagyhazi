package Base;

import sun.invoke.empty.Empty;

import java.io.Serializable;

public class Orange extends Item implements Serializable {

    public Orange()
    {
        pickupable = true;
        name = "orange";
    }
    public boolean Effect(Snake thisSnake, Snake otherSnake) throws EmptyException
    {
        thisSnake.decreaseSpeed();
        return false;
    }
}
