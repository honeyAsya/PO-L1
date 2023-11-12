package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] parseOptions(String[] arrayToParseOptions){
        MoveDirection[] movesArray = new MoveDirection[arrayToParseOptions.length];
        int nextPosition = 0;
        for (String option : arrayToParseOptions){
            switch (option) {
                case "f":
                    movesArray[nextPosition] = MoveDirection.FORWARD;
                    nextPosition++;
                    break;
                case "r":
                    movesArray[nextPosition] = MoveDirection.RIGHT;
                    nextPosition++;
                    break;
                case "b":
                    movesArray[nextPosition] = MoveDirection.BACKWARD;
                    nextPosition++;
                    break;
                case "l":
                    movesArray[nextPosition] = MoveDirection.LEFT;
                    nextPosition++;
                    break;
                default: break;
            }
        }
        return movesArray;
    }
}
