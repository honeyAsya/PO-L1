package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    public void testEquals() {
        //given
        Animal animal = new Animal();
        Animal animal2 = new Animal();

        Animal animal3 = new Animal(new Vector2d(2,3));
        Animal animal4 = new Animal(new Vector2d(2,3));

        Animal animal5 = new Animal(new Vector2d(2,2));

        //then
        assertTrue(animal.equals(animal2));
        assertTrue(animal3.equals(animal4));
        assertTrue(animal5.equals(animal));
    }

    @Test
    public void testInitPosition() {
        //given
        Animal animal = new Animal();

        //then
        assertTrue( animal.isAt(new Vector2d(2,2)));
    }

    @Test
    public void testMoves() {
        //given
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD, new RectangularMap(10,10));

        //then
        assertEquals(animal.getPosition(), new Vector2d(2,3));
    }

    @Test
    public void testToString() {
        //given
        Animal animal = new Animal();

        //then
        assertEquals("(2,2)", animal.toString());
    }

}