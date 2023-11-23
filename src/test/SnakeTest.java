package test;

import Base.Coordinate;
import Base.Direction;
import Base.EmptyException;
import Base.Snake;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SnakeTest {

    @Test
    public void move() {
        ArrayList<Coordinate> al = new ArrayList<>();
        Coordinate c1 = new Coordinate(5,5);
        Coordinate c2 = new Coordinate(5,4);
        ArrayList<Coordinate> after = new ArrayList<>();
        Coordinate a1 = new Coordinate(5,6);
        Coordinate a2 = new Coordinate(5,5);
        after.add(a1);
        after.add(a2);
        al.add(c1);
        al.add(c2);
        Direction d = Direction.DOWN;
        Snake s = new Snake(al,d);
        try {
            s.Move();
        } catch(EmptyException ee){}
        Assert.assertEquals(s.getCoordinates().get(0).GetPosY(), after.get(0).GetPosY());
        Assert.assertEquals(s.getCoordinates().get(0).GetPosX(), after.get(0).GetPosX());
        Assert.assertEquals(s.getCoordinates().get(1).GetPosY(), after.get(1).GetPosY());
        Assert.assertEquals(s.getCoordinates().get(1).GetPosX(), after.get(1).GetPosX());

    }

}