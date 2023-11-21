package agh.ics.oop.model;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangularMapValidatorTest {
    @Test
    public void checkCorrectPlaceAnimalsOnDifferentPlaces(){
        //given
        RectangularMap sandbox = new RectangularMap(10,10);
        Animal rabbit = new Animal();
        Animal wolf = new Animal(new Vector2d(2, 3));

        //when
        boolean insertedRabbit  = sandbox.place(rabbit);
        sandbox.move(rabbit, MoveDirection.FORWARD);
        sandbox.move(rabbit, MoveDirection.FORWARD);
        boolean insertedWolf = sandbox.place(wolf);

        //then
        Assertions.assertTrue(insertedRabbit);
        Assertions.assertTrue(insertedWolf);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,4)), rabbit);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,3)), wolf);
    }

    @Test
    public void checkNotPlaceAnimalsOnSamePlace(){
        //given
        RectangularMap sandbox = new RectangularMap(10,10);
        Animal rabbit = new Animal(new Vector2d(2, 3));
        Animal wolf = new Animal(new Vector2d(2, 3));

        //when
        boolean insertedRabbit  = sandbox.place(rabbit);
        boolean insertedWolf = sandbox.place(wolf);

        //then
        Assertions.assertTrue(insertedRabbit);
        Assertions.assertFalse(insertedWolf);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,3)), rabbit);
    }

    @Test
    public void checkUpdatePlaceKeyAnimalsAfterMove(){
        //given
        RectangularMap sandbox = new RectangularMap(10,10);
        Animal rabbit = new Animal(new Vector2d(2, 3));
        Animal wolf = new Animal(new Vector2d(2, 4));

        //when
        boolean insertedRabbit  = sandbox.place(rabbit);
        boolean insertedWolf = sandbox.place(wolf);

        Animal rabbitInSandbox = sandbox.objectAt(new Vector2d(2,3));
        Animal wolfInSandbox = sandbox.objectAt(new Vector2d(2,4));
        sandbox.move(wolf, MoveDirection.FORWARD);
        sandbox.move(rabbit, MoveDirection.FORWARD);

        //then
        Assertions.assertTrue(insertedRabbit);
        Assertions.assertTrue(insertedWolf);
        Assertions.assertEquals(rabbitInSandbox, rabbit);
        Assertions.assertEquals(wolfInSandbox, wolf);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,4)), rabbit);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,5)), wolf);
    }

    @Test
    public void checkNotMoveAnimalsInSamePositionMove(){
        //given
        RectangularMap sandbox = new RectangularMap(10,10);
        Animal rabbit = new Animal(new Vector2d(2, 3));
        Animal wolf = new Animal(new Vector2d(2, 4));

        //when
        boolean insertedRabbit  = sandbox.place(rabbit);
        boolean insertedWolf = sandbox.place(wolf);

        Animal rabbitInSandbox = sandbox.objectAt(new Vector2d(2,3));
        Animal wolfInSandbox = sandbox.objectAt(new Vector2d(2,4));

        sandbox.move(rabbit, MoveDirection.FORWARD);
        //then
        Assertions.assertTrue(insertedRabbit);
        Assertions.assertTrue(insertedWolf);
        Assertions.assertEquals(rabbitInSandbox, rabbit);
        Assertions.assertEquals(wolfInSandbox, wolf);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,3)), rabbit);
    }
}
