import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void testEquals() {
        //given
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(2, 3);
        Vector2d vector3 = new Vector2d(4, 5);

        //then
        assertTrue(vector1.equals(vector2));
        assertFalse(vector1.equals(vector3));
    }

    @Test
    public void testToString() {
        //given
        Vector2d vector = new Vector2d(2, 3);

        //then
        assertEquals("(2,3)", vector.toString());
    }

    @Test
    public void testPrecedes() {
        //given
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(4, 5);
        Vector2d vector3 = new Vector2d(1, 2);

        //then
        assertTrue(vector1.precedes(vector2));
        assertFalse(vector2.precedes(vector1));
        assertTrue(vector3.precedes(vector1));
    }

    @Test
    public void testFollows() {
        //given
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(4, 5);
        Vector2d vector3 = new Vector2d(1, 2);

        //then
        assertFalse(vector1.follows(vector2));
        assertTrue(vector2.follows(vector1));
        assertTrue(vector1.follows(vector3));
    }

    @Test
    public void testUpperRight() {
        //given
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(4, 5);
        Vector2d upperRight = vector1.upperRight(vector2);

        //then
        assertEquals(new Vector2d(4, 5), upperRight);
    }

    @Test
    public void testLowerLeft() {
        //given
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(4, 5);
        Vector2d lowerLeft = vector1.lowerLeft(vector2);

        //then
        assertEquals(new Vector2d(2, 3), lowerLeft);
    }

    @Test
    public void testAdd() {
        //given
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(4, 5);
        Vector2d sum = vector1.add(vector2);

        //then
        assertEquals(new Vector2d(6, 8), sum);
    }

    @Test
    public void testSubtract() {
        //given
        Vector2d vector1 = new Vector2d(4, 5);
        Vector2d vector2 = new Vector2d(2, 3);
        Vector2d difference = vector1.substract(vector2);

        //then
        assertEquals(new Vector2d(2, 2), difference);
    }

    @Test
    public void testOpposite() {
        //given
        Vector2d vector = new Vector2d(2, 3);
        Vector2d opposite = vector.opposite();

        //then
        assertEquals(new Vector2d(-2, -3), opposite);
    }
}
