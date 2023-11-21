import agh.ics.oop.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextMapValidatorTest {
    @Test
    public void checkCorrectPlaceAnimalsOnDifferentPlaces(){
        //given
        TextMap sandbox = new TextMap(10);
        String rabbit = "Rabbit";
        String wolf = "Wolf";

        //when
        boolean insertedRabbit  = sandbox.place(rabbit);
        boolean insertedWolf = sandbox.place(wolf);

        //then
        Assertions.assertTrue(insertedRabbit);
        Assertions.assertTrue(insertedWolf);
        Assertions.assertEquals(sandbox.objectAt(0), rabbit);
        Assertions.assertEquals(sandbox.objectAt(1), wolf);
    }


    @Test
    public void checkUpdatePlaceKeyAnimalsAfterMove(){
        //given
        TextMap sandbox = new TextMap(10);
        String rabbit = "Rabbit";
        String wolf = "Wolf";

        //when
        boolean insertedRabbit  = sandbox.place(rabbit);
        boolean insertedWolf = sandbox.place(wolf);

        String rabbitInSandbox = sandbox.objectAt(0);
        String wolfInSandbox = sandbox.objectAt(1);
        sandbox.move(wolf, MoveDirection.BACKWARD);
        sandbox.move(rabbit, MoveDirection.FORWARD);

        //then
        Assertions.assertTrue(insertedRabbit);
        Assertions.assertTrue(insertedWolf);
        Assertions.assertEquals(rabbitInSandbox, rabbit);
        Assertions.assertEquals(wolfInSandbox, wolf);
        Assertions.assertEquals(sandbox.objectAt(1), rabbit);
        Assertions.assertEquals(sandbox.objectAt(0), wolf);
    }

    @Test
    public void checkNotMoveAnimalsOnLastPosition(){
        //given
        TextMap sandbox = new TextMap(10);
        String rabbit = "Rabbit";
        String wolf = "Wolf";

        //when
        boolean insertedRabbit  = sandbox.place(rabbit);
        boolean insertedWolf = sandbox.place(wolf);

        String rabbitInSandbox = sandbox.objectAt(0);
        String wolfInSandbox = sandbox.objectAt(1);
        sandbox.move(wolf, MoveDirection.BACKWARD);
        sandbox.move(wolf, MoveDirection.BACKWARD);
        sandbox.move(rabbit, MoveDirection.FORWARD);
        sandbox.move(rabbit, MoveDirection.FORWARD);
        //then
        Assertions.assertTrue(insertedRabbit);
        Assertions.assertTrue(insertedWolf);
        Assertions.assertEquals(rabbitInSandbox, rabbit);
        Assertions.assertEquals(wolfInSandbox, wolf);
        Assertions.assertEquals(sandbox.objectAt(1), rabbit);
        Assertions.assertEquals(sandbox.objectAt(0), wolf);
    }

    @Test
    public void checkNotMoveAnimalsOnNotGeometryPosition(){
        //given
        TextMap sandbox = new TextMap(10);
        String rabbit = "Rabbit";
        String wolf = "Wolf";

        //when
        boolean insertedRabbit  = sandbox.place(rabbit);
        boolean insertedWolf = sandbox.place(wolf);

        String rabbitInSandbox = sandbox.objectAt(0);
        String wolfInSandbox = sandbox.objectAt(1);
        sandbox.move(wolf, MoveDirection.LEFT);
        sandbox.move(rabbit, MoveDirection.LEFT);
        //then
        Assertions.assertTrue(insertedRabbit);
        Assertions.assertTrue(insertedWolf);
        Assertions.assertEquals(rabbitInSandbox, rabbit);
        Assertions.assertEquals(wolfInSandbox, wolf);
        Assertions.assertEquals(sandbox.objectAt(0), rabbit);
        Assertions.assertEquals(sandbox.objectAt(1), wolf);
    }
}
