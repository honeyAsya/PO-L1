package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parseOptions(String[] arrayToParseOptions){
        List<MoveDirection> movesArray = new ArrayList<>();
        for (String option : arrayToParseOptions){
            switch (option) {
                case "f":
                    movesArray.add(MoveDirection.FORWARD);
                    break;
                case "r":
                    movesArray.add(MoveDirection.RIGHT);
                    break;
                case "b":
                    movesArray.add(MoveDirection.BACKWARD);
                    break;
                case "l":
                    movesArray.add(MoveDirection.LEFT);
                    break;
                default: throw new IllegalArgumentException(option + " is not legal move specification");
            }
        }
        return movesArray;
    }
}
