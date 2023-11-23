package Base;

import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class Game implements Serializable {

    private Player p1;
    private int wallCounterp1 = 0;
    private Player p2;
    private int wallCounterp2 = 0;

    private int itemGeneratorCounter = 0;
    private int ticksUntilNextItem;
    private int p1MoveCounter = 0;
    private int p2MoveCounter = 0;

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
    public void InitializePlayers()
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
    public void turnKeyPressesIntoInfos(int pushedButton) throws EmptyException
    {
        switch(pushedButton)
        {
            case KeyEvent.VK_LEFT:
                if(p2.getSnake().getDirection() != Direction.RIGHT)
                {p2.getSnake().AdjustDirection(Direction.LEFT);}break;
            case KeyEvent.VK_RIGHT:
                if(p2.getSnake().getDirection() != Direction.LEFT)
                {p2.getSnake().AdjustDirection(Direction.RIGHT);}break;
            case KeyEvent.VK_UP:
                if(p2.getSnake().getDirection() != Direction.DOWN)
                {p2.getSnake().AdjustDirection(Direction.UP);}break;
            case KeyEvent.VK_DOWN:
                if(p2.getSnake().getDirection() != Direction.UP)
                {p2.getSnake().AdjustDirection(Direction.DOWN);}break;
            case KeyEvent.VK_A:
                if(p1.getSnake().getDirection() != Direction.RIGHT)
                {p1.getSnake().AdjustDirection(Direction.LEFT);}break;
            case KeyEvent.VK_D:
                if(p1.getSnake().getDirection() != Direction.LEFT)
                {p1.getSnake().AdjustDirection(Direction.RIGHT);}break;
            case KeyEvent.VK_W:
                if(p1.getSnake().getDirection() != Direction.DOWN)
                {p1.getSnake().AdjustDirection(Direction.UP);}break;
            case KeyEvent.VK_S:
                if(p1.getSnake().getDirection() != Direction.UP)
                {p1.getSnake().AdjustDirection(Direction.DOWN);}break;
            case KeyEvent.VK_F:
                if(p1.gethasPicUpAble())
                    if(p1.getOwnedPickUpAble().Effect(p1.getSnake(), p2.getSnake()))
                        wallCounterp1 = 3;
                p1.sethasPickUpAble(false);
                break;
            case KeyEvent.VK_G:
                if(p1.gethasPicUpAble())
                    p1.getOwnedPickUpAble().Effect(p2.getSnake(), p1.getSnake());
                p1.sethasPickUpAble(false);
                break;
            case KeyEvent.VK_K:
                if(p2.gethasPicUpAble())
                    if(p2.getOwnedPickUpAble().Effect(p2.getSnake(), p1.getSnake()))
                        wallCounterp2 = 3;
                p2.sethasPickUpAble(false);
                break;
            case KeyEvent.VK_L:
                if(p2.gethasPicUpAble())
                {
                    p2.getOwnedPickUpAble().Effect(p2.getSnake(), p1.getSnake());
                }
                p2.sethasPickUpAble(false);
                break;


        }
    }


    public ArrayList<Item> getItems()
    {
        return items;
    }

    public Game()
    {
        InitializePlayers();
        itemTickUntilItemGeneration();
        GenerateItem();
    }
    public void GenerateItem()
    {

        Item newItem;
        Random rnd = new Random();
        int decider = rnd.nextInt(7);
        boolean success = false;
        switch(decider)
        {
            case 0: newItem = new Apple(); break;
            case 1: newItem = new Lemon();break;
            case 2: newItem = new BlueBerry();break;
            case 3: newItem = new Orange();break;
            case 5: newItem = new Kiwi();break;
            case 6: newItem = new Raspberry();break;
            default: newItem = new Apple();
        }



        while(!success)
        {
            Coordinate tmp = Item.RandomizeNewItem();
            if(!walls.contains(tmp) && !p1.getSnake().getCoordinates().contains(tmp)
                    && !p2.getSnake().getCoordinates().contains(tmp))
            {
                success = true;
                for(int i = 0; i < items.size(); i++)
                {
                    if(items.get(i).getCoordinates().equals(tmp))
                    {
                        success = false;
                    }
                }

                if(success)
                {
                    newItem.setCoordinates(tmp);
                }
            }
        }

        items.add(newItem);
    }

    public boolean DoesSnakeDie(Snake thisSnake, Snake otherSnake)
    {
        if(otherSnake.IsContained(thisSnake.getHeadCoordinate()) || thisSnake.getHeadCoordinate().GetPosX() >= 20 || thisSnake.getHeadCoordinate().GetPosY() >= 20 || thisSnake.getHeadCoordinate().GetPosX() < 0 || thisSnake.getHeadCoordinate().GetPosY() < 0)
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

    private void PlayerPickingUpItem(Player thisPlayer, Player otherPlayer) throws EmptyException
    {
        for(int i = 0; i < items.size(); i++)
        {
            if(thisPlayer.getSnake().getHeadCoordinate().equals(items.get(i).getCoordinates()))
            {
                if(items.get(i).getPickupAble())
                {
                    thisPlayer.setOwnedPickUpAble(items.get(i));
                    thisPlayer.sethasPickUpAble(true);
                }
                else
                    items.get(i).Effect(thisPlayer.getSnake(), otherPlayer.getSnake());


                items.remove(i);
            }
        }
    }

    public Winner Step() {

        p1MoveCounter++;
        p2MoveCounter++;
        itemGeneratorCounter++;

        try {
            if (p1MoveCounter >= p1.getSnake().getMoveTimer() * 15) {
                p1.getSnake().Move();
                if (wallCounterp1 > 0) {
                    walls.add(p1.getSnake().getCoordinates().get(p1.getSnake().getCoordinates().size() - 1));
                    wallCounterp1--;
                }
                if (DoesSnakeDie(p1.getSnake(), p2.getSnake())) {
                    return Winner.PLAYER2;
                }
                PlayerPickingUpItem(p1, p2);
                p1MoveCounter = 0;

            }
        }catch(EmptyException ee)
        {
            return Winner.PLAYER2;
        }

        try {
            if (p2MoveCounter >= p2.getSnake().getMoveTimer() * 15) {
                p2.getSnake().Move();
                if (wallCounterp2 > 0) {
                    walls.add(p2.getSnake().getCoordinates().get(p2.getSnake().getCoordinates().size() - 1));
                    wallCounterp2--;
                }
                if (DoesSnakeDie(p2.getSnake(), p1.getSnake())) {
                    System.out.println("p1 nyert");
                    return Winner.PLAYER1;
                }
                PlayerPickingUpItem(p2, p1);
                p2MoveCounter = 0;
            }

            if (itemGeneratorCounter >= ticksUntilNextItem) {
                if (items.size() == maxItems)
                    items.remove(0);
                GenerateItem();
                itemGeneratorCounter = 0;
                itemTickUntilItemGeneration();
            }
        }catch (EmptyException ee)
        {
            return Winner.PLAYER1;
        }
            return Winner.NOONE;


    }

    private void itemTickUntilItemGeneration()
    {
        Random rnd = new Random();
        ticksUntilNextItem = 80 + rnd.nextInt(70);
    }

}
