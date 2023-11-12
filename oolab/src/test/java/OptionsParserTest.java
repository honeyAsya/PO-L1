
import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class OptionsParserTest {

    @Test
    public void resultEqualsTest(){
        //given
        String[] testCodes = {"f", "r", "b", "l", null};
        MoveDirection[] resultEnums = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT, null};
        //when
        MoveDirection[] convertedEnums = OptionsParser.parseOptions(testCodes);
        //then
        Assertions.assertEquals(5, convertedEnums.length);
        Assertions.assertArrayEquals(resultEnums, convertedEnums);
    }
}
