import agh.ics.oop.Vector2d;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimulationTest {
    @Test
    public void checkOrientationTest() {
        //given
        Animal animal = new Animal();

        //then
        Assertions.assertTrue(animal.isAt(new Vector2d(2,2)));
    }

    @Test
    public void checkMoveOrientationTest() {
        //given
        Animal animal = new Animal();
        //when
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        //then
        Assertions.assertTrue(animal.isAt(new Vector2d(1,2)));
    }

    @Test
    public void checkBorderOrientationTest() {
        //given
        Animal animalMaxX = new Animal(new Vector2d(4,2));
        Animal animalMaxY = new Animal(new Vector2d(2,4));
        Animal animalMinX = new Animal(new Vector2d(0,2));
        Animal animalMinY = new Animal(new Vector2d(2,0));
        //when
        animalMaxY.move(MoveDirection.FORWARD);

        animalMaxX.move(MoveDirection.RIGHT);
        animalMaxX.move(MoveDirection.FORWARD);

        animalMinY.move(MoveDirection.BACKWARD);

        animalMinX.move(MoveDirection.LEFT);
        animalMinX.move(MoveDirection.FORWARD);

        //then
        Assertions.assertTrue(animalMaxX.isAt(new Vector2d(4,2)));
        Assertions.assertTrue(animalMaxY.isAt(new Vector2d(2,4)));
        Assertions.assertTrue(animalMinY.isAt(new Vector2d(2,0)));
        Assertions.assertTrue(animalMinX.isAt(new Vector2d(0,2)));
    }
}