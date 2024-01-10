package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class OptionsParser {
    public static List<MoveDirection> parseOptions(String[] arrayToParseOptions) {
        return Stream.of(arrayToParseOptions).map(OptionsParser::parseStringToMoveDirection).toList();
    }

    public static MoveDirection parseStringToMoveDirection(String s) {
        return switch (s) {
            case "f" -> MoveDirection.FORWARD;
            case "r" -> MoveDirection.RIGHT;
            case "b" -> MoveDirection.BACKWARD;
            case "l" -> MoveDirection.LEFT;
            default -> throw new IllegalArgumentException(s + " is not legal move specification");
        };
    }
}
