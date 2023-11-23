package test;

import Base.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BlueBerryTest {

    @Test
    public void effect() {
        BlueBerry b = new BlueBerry();
        Coordinate c1 = new Coordinate(5,5);
        Coordinate c3 = new Coordinate(4,5);
        Coordinate c2 = new Coordinate(1,1);
        Coordinate c4 = new Coordinate(2,1);
        ArrayList<Coordinate> a1 = new ArrayList<>();
        a1.add(c1);
        a1.add(c3);
        ArrayList<Coordinate> a2 = new ArrayList<>();
        a2.add(c2);
        a2.add(c4);
        Direction d = Direction.DOWN;
        Snake s1 = new Snake(a1, d);
        Snake s2 = new Snake(a2,d);
        try {
            b.Effect(s1, s2);
        } catch(EmptyException ee){}

        Assert.assertEquals(0.7, s1.getMoveTimer(), 0);
    }
}