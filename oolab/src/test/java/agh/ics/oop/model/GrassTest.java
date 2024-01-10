package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrassTest {
    @Test
    public void testEquals() {
        //given
        Grass grass = new Grass(new Vector2d(2,2));
        Grass grass2 = new Grass(new Vector2d(2,2));

        Grass grass3 = new Grass(new Vector2d(2,3));
        Grass grass4 = new Grass(new Vector2d(2,3));

        Grass grass5 = new Grass(new Vector2d(2,2));

        //then
        assertTrue(grass.equals(grass2));
        assertTrue(grass3.equals(grass4));
        assertTrue(grass5.equals(grass));
    }

    @Test
    public void testInitPosition() {
        //given
        Grass grass = new Grass(new Vector2d(2,2));

        //then
        assertTrue( grass.getPosition().equals(new Vector2d(2,2)));
    }

    @Test
    public void testMoves() {
        //given
        Grass grass = new Grass(new Vector2d(2,2));
        grass.move(MoveDirection.FORWARD, new RectangularMap(10,10));

        //then
        assertEquals(grass.getPosition(), new Vector2d(2,3));
    }

    @Test
    public void testToString() {
        //given
        Grass grass = new Grass(new Vector2d(2,2));

        //then
        assertEquals("Grass", grass.toString());
    }

}