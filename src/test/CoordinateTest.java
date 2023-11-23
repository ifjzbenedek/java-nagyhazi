package test;

import Base.Coordinate;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {

    @Test
    public void testEquals() {
        Coordinate c1 = new Coordinate(1,1);
        Coordinate c3 = new Coordinate(1,1);
        Assert.assertNotEquals(c1,c3);
        Assert.assertTrue(c1.equals(c3));
    }
}