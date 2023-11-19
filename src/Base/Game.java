package Base;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;

public class Game {

    private Player p1;
    private Player p2;

    int width = 40;
    int height = 40;
    private ArrayList<Item> items = new ArrayList<>();
    int maxItems = 5;
    private ArrayList<Coordinate> walls = new ArrayList<>();

    public Player getPlayer(int idx)
    {
        if(idx == 0)
            return p1;
        else if( idx == 1)
            return p2;

        return null;
    }
    public ArrayList<Coordinate> getWalls()
    {
        return walls;
    }
    private void InitializePlayers()
    {
        ArrayList<Coordinate> s1 = new ArrayList<>();
        s1.add(new Coordinate(0,0));
        s1.add(new Coordinate(0,1));
        s1.add(new Coordinate(0,2));

        ArrayList<Coordinate> s2 = new ArrayList<>();
        s2.add(new Coordinate(19,19));
        s2.add(new Coordinate(19,18));
        s2.add(new Coordinate(19,17));

        p1 = new Player(new Snake(s1, Direction.DOWN), "Player1");
        p2 = new Player(new Snake(s2, Direction.UP), "Player2");
    }
    public void turnKeyPressesIntoInfos(int pushedButton)
    {
        switch(pushedButton)
        {
            case KeyEvent.VK_LEFT:
                if(p2.getSnake().getDirection() != Direction.RIGHT)
                {p2.getSnake().AdjustDirection(Direction.LEFT);break;}
            case KeyEvent.VK_RIGHT:
                if(p2.getSnake().getDirection() != Direction.LEFT)
                {p2.getSnake().AdjustDirection(Direction.RIGHT);break;}
            case KeyEvent.VK_UP:
                if(p2.getSnake().getDirection() != Direction.DOWN)
                {p2.getSnake().AdjustDirection(Direction.UP);break;}
            case KeyEvent.VK_DOWN:
                if(p2.getSnake().getDirection() != Direction.UP)
                {p2.getSnake().AdjustDirection(Direction.DOWN);break;}
            case KeyEvent.VK_A:
                if(p1.getSnake().getDirection() != Direction.RIGHT)
                {p1.getSnake().AdjustDirection(Direction.LEFT);break;}
            case KeyEvent.VK_D:
                if(p1.getSnake().getDirection() != Direction.LEFT)
                {p1.getSnake().AdjustDirection(Direction.RIGHT);break;}
            case KeyEvent.VK_W:
                if(p1.getSnake().getDirection() != Direction.DOWN)
                {p1.getSnake().AdjustDirection(Direction.UP);break;}
            case KeyEvent.VK_S:
                if(p1.getSnake().getDirection() != Direction.UP)
                {p1.getSnake().AdjustDirection(Direction.DOWN);break;}
            case KeyEvent.VK_F:
                p1.getOwnedPickUpAble().Effect(p1.getSnake(), p2.getSnake()); break;
            case KeyEvent.VK_G:
                p1.getOwnedPickUpAble().Effect(p2.getSnake(), p1.getSnake());break;
            case KeyEvent.VK_K:
                p2.getOwnedPickUpAble().Effect(p2.getSnake(), p1.getSnake());break;
            case KeyEvent.VK_L:
                p2.getOwnedPickUpAble().Effect(p1.getSnake(), p2.getSnake());break;


        }
    }

    public Game()
    {
        InitializePlayers();
        GenerateItem();
    }
    private void GenerateItem()
    {

    }

    private boolean DoesSnakeDie(Snake thisSnake, Snake otherSnake)
    {
        if(otherSnake.IsContained(thisSnake.getHeadCoordinate()) || thisSnake.getHeadCoordinate().GetPosX() >= 20 || thisSnake.getHeadCoordinate().GetPosY() >= 20 || thisSnake.getHeadCoordinate().GetPosX() < 0 || thisSnake.getHeadCoordinate().GetPosY() < 0 )
            return true;
        else
        {
            for(int i = 0; i < walls.size(); i++)
            {
                if(thisSnake.getHeadCoordinate().equals(walls.get(i)))
                    return true;
            }
        }

        return false;
    }


    public void Step()
    {
        p1.getSnake().Move();
        if(DoesSnakeDie(p1.getSnake(), p2.getSnake())) {
            System.out.println("p2 nyert");
            System.exit(0);
        }
        p2.getSnake().Move();
        if(DoesSnakeDie(p2.getSnake(), p1.getSnake())) {
            System.out.println("p1 nyert");
            System.exit(0);
        }
    }



}
