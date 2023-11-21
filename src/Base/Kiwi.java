package Base;

import java.io.Serializable;

public class Kiwi extends Item implements Serializable {

    public Kiwi()
    {
        pickupable = true;
        name = "kiwi";
    }
    public boolean Effect(Snake thisSnake, Snake otherSnake)
    {
        return true;
    }
}
