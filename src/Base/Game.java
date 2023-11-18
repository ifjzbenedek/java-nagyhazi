package Base;

import java.util.ArrayList;
import java.util.Timer;

public class Game {

    private Player p1;
    Direction d1;

    private Player p2;
    Direction d2;

    int width = 20;
    int height = 20;
    ArrayList<Item> items = new ArrayList<>();
    int maxItems = 5;
    ArrayList<Coordinate> walls = new ArrayList<>();

    Timer timer = new Timer();


    private void InitializePlayers()
    {
        ArrayList<Coordinate> s1 = new ArrayList<>();
        s1.add(new Coordinate(0,0));
        s1.add(new Coordinate(0,1));
        s1.add(new Coordinate(0,2));
        d1 = Direction.DOWN;

        ArrayList<Coordinate> s2 = new ArrayList<>();
        s2.add(new Coordinate(19,19));
        s2.add(new Coordinate(19,18));
        s2.add(new Coordinate(19,17));
        d2 = Direction.UP;

        p1 = new Player(new Snake(s1, d1), "Player1");
        p2 = new Player(new Snake(s2, d2), "Player2");
    }

    private void GenerateItem()
    {

    }
    public void RunGame()
    {
        InitializePlayers();
    }



}
