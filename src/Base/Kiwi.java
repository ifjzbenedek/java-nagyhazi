package Base;

public class Kiwi extends Item{

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
