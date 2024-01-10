package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class AbstractWorldMapTest {
    @Test
    public void checkCorrectPlaceAnimalsOnDifferentPlacesOnRectangularMap(){
        //given
        AbstractWorldMap sandbox = new RectangularMap(10,10);
        Animal rabbit = new Animal();
        Animal wolf = new Animal(new Vector2d(2, 3));
        AtomicBoolean insertedRabbit = new AtomicBoolean();
        AtomicBoolean insertedWolf = new AtomicBoolean();
        //when

        Assertions.assertDoesNotThrow(() -> insertedRabbit.set(sandbox.place(rabbit)));

        sandbox.move(rabbit, MoveDirection.FORWARD, (MoveValidator) sandbox);
        sandbox.move(rabbit, MoveDirection.FORWARD, (MoveValidator)sandbox);
        Assertions.assertDoesNotThrow(() -> insertedWolf.set(sandbox.place(wolf)));

        //then
        Assertions.assertTrue(insertedRabbit.get());
        Assertions.assertTrue(insertedWolf.get());
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,4)).get(), rabbit);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,3)).get(), wolf);

    }

    @Test
    public void checkCorrectPlaceAnimalsOnDifferentPlacesOnGrassFieldMap(){
        //given
        AbstractWorldMap sandbox = new GrassField(11);
        Animal rabbit = new Animal();
        Animal wolf = new Animal(new Vector2d(2, 3));
        AtomicBoolean insertedRabbit = new AtomicBoolean();
        AtomicBoolean insertedWolf = new AtomicBoolean();
        //when

        Assertions.assertDoesNotThrow(() -> insertedRabbit.set(sandbox.place(rabbit)));

        sandbox.move(rabbit, MoveDirection.FORWARD, (MoveValidator) sandbox);
        sandbox.move(rabbit, MoveDirection.FORWARD, (MoveValidator)sandbox);
        Assertions.assertDoesNotThrow(() -> insertedWolf.set(sandbox.place(wolf)));

        //then
        Assertions.assertTrue(insertedRabbit.get());
        Assertions.assertTrue(insertedWolf.get());
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,4)).get(), rabbit);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,3)).get(), wolf);
    }
}