package agh.ics.oop.tools;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class OptionsParserTest {

    @Test
    public void resultEqualsTestWithNonStandardObject(){
        //given
        String[] testCodes = {"f", "r", "b", "l", "2"};
        List<MoveDirection> resultEnums = List.of(MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT);
        //when
        List<MoveDirection> convertedEnums = OptionsParser.parseOptions(testCodes);
        //then
        Assertions.assertEquals(4, convertedEnums.size());
        Assertions.assertEquals(resultEnums, convertedEnums);
    }

    @Test
    public void resultEqualsTest(){
        //given
        String[] testCodes = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        List<MoveDirection> resultEnums = List.of(MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.RIGHT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD);
        //when
        List<MoveDirection> convertedEnums = OptionsParser.parseOptions(testCodes);
        //then
        Assertions.assertEquals(16, convertedEnums.size());
        Assertions.assertEquals(resultEnums, convertedEnums);
    }
}
