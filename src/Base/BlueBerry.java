package Base;

import java.io.Serializable;

public class BlueBerry extends Item implements Serializable {

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
