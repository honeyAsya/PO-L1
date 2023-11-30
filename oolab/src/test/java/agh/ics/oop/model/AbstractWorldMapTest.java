package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AbstractWorldMapTest {
    @Test
    public void checkCorrectPlaceAnimalsOnDifferentPlacesOnRectangularMap(){
        //given
        AbstractWorldMap sandbox = new RectangularMap(10,10);
        Animal rabbit = new Animal();
        Animal wolf = new Animal(new Vector2d(2, 3));

        //when
        boolean insertedRabbit  = sandbox.place(rabbit);
        sandbox.move(rabbit, MoveDirection.FORWARD, (MoveValidator) sandbox);
        sandbox.move(rabbit, MoveDirection.FORWARD, (MoveValidator)sandbox);
        boolean insertedWolf = sandbox.place(wolf);

        //then
        Assertions.assertTrue(insertedRabbit);
        Assertions.assertTrue(insertedWolf);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,4)), rabbit);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,3)), wolf);
    }

    @Test
    public void checkCorrectPlaceAnimalsOnDifferentPlacesOnGrassFieldMap(){
        //given
        AbstractWorldMap sandbox = new GrassField(11);
        Animal rabbit = new Animal();
        Animal wolf = new Animal(new Vector2d(2, 3));

        //when
        boolean insertedRabbit  = sandbox.place(rabbit);
        sandbox.move(rabbit, MoveDirection.FORWARD, (MoveValidator) sandbox);
        sandbox.move(rabbit, MoveDirection.FORWARD, (MoveValidator)sandbox);
        boolean insertedWolf = sandbox.place(wolf);

        //then
        Assertions.assertTrue(insertedRabbit);
        Assertions.assertTrue(insertedWolf);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,4)), rabbit);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,3)), wolf);
    }
}