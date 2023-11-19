import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
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
        RectangularMap rectangularMap = new RectangularMap(4,4);
        //when
        animal.move(MoveDirection.LEFT, rectangularMap);
        animal.move(MoveDirection.FORWARD, rectangularMap);
        //then
        Assertions.assertTrue(animal.isAt(new Vector2d(1,2)));
    }

    @Test
    public void checkBorderOrientationTest() {
        //given
        RectangularMap rectangularMap = new RectangularMap(4,0);
        Animal animalMaxX = new Animal(new Vector2d(4,2));
        Animal animalMaxY = new Animal(new Vector2d(2,4));
        Animal animalMinX = new Animal(new Vector2d(0,2));
        Animal animalMinY = new Animal(new Vector2d(2,0));
        //when
        animalMaxY.move(MoveDirection.FORWARD, rectangularMap);

        animalMaxX.move(MoveDirection.RIGHT, rectangularMap);
        animalMaxX.move(MoveDirection.FORWARD, rectangularMap);
        animalMinY.move(MoveDirection.BACKWARD, rectangularMap);
        animalMinX.move(MoveDirection.LEFT, rectangularMap);
        animalMinX.move(MoveDirection.FORWARD, rectangularMap);

        //then
        Assertions.assertTrue(animalMaxX.isAt(new Vector2d(4,2)));
        Assertions.assertTrue(animalMaxY.isAt(new Vector2d(2,4)));
        Assertions.assertTrue(animalMinY.isAt(new Vector2d(2,0)));
        Assertions.assertTrue(animalMinX.isAt(new Vector2d(0,2)));
    }
}