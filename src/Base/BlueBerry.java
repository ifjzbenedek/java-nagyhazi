package Base;

import java.io.Serializable;

public class BlueBerry extends Item implements Serializable {

    public BlueBerry()
    {
        pickupable = true;
        name = "blueberry";
    }
    public boolean Effect(Snake thisSnake, Snake otherSnake) throws EmptyException
    {
        thisSnake.increaseSpeed();
        return false;
    }
}
