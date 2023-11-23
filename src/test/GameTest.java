package test;

import Base.*;
import org.junit.Test;

import java.util.ArrayList;

import static java.awt.event.KeyEvent.VK_D;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void initializePlayers() {

        ArrayList<Coordinate> sc = new ArrayList<>();
        Coordinate c0 = new Coordinate(0,0);
        Coordinate c2 = new Coordinate(0,1);
        Coordinate c1 = new Coordinate(0,2);
        sc.add(c0);
        sc.add(c2);
        sc.add(c1);
        Direction d = Direction.DOWN;
        Snake s = new Snake(sc, d);
        Player p = new Player(s, "snek");
        Game g = new Game();
        g.InitializePlayers();
        for(int i = 0; i < g.getPlayer(0).getSnake().getCoordinates().size();i++)
        {
            assertEquals(g.getPlayer(0).getSnake().getCoordinates().get(i).GetPosX(),p.getSnake().getCoordinates().get(i).GetPosX());
            assertEquals(g.getPlayer(0).getSnake().getCoordinates().get(i).GetPosY(),p.getSnake().getCoordinates().get(i).GetPosY());
        }
    }

    @Test
    public void turnKeyPressesIntoInfos() throws EmptyException {

        int dKey = VK_D;
        Game g = new Game();
        Direction d = g.getPlayer(0).getSnake().getDirection();
        g.turnKeyPressesIntoInfos(dKey);
        assertNotEquals(g.getPlayer(0).getSnake().getDirection(), d);
        assertEquals(Direction.RIGHT, g.getPlayer(0).getSnake().getDirection());
    }

    @Test
    public void generateItem()
    {
        Game g = new Game();
        int meret = 1;
        assertEquals(g.getItems().size(),meret);
        g.GenerateItem();
        meret++;
        assertEquals(g.getItems().size(),meret);
        g.GenerateItem();
        meret++;
        assertEquals(g.getItems().size(),meret);
    }

    /*@Test
    public void doesSnakeDie() {
        Game g = new Game();
        g.InitializePlayers();
        g.

    }*/
}