package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World2 {

    public static void run(MoveDirection[] moves) {
        for (MoveDirection move : moves) {
            if (move != null) {
                switch (move) {
                    case FORWARD:
                        System.out.println("zwierzak idzie do przodu");
                        break;
                    case RIGHT:
                        System.out.println("zwierzak skręca w prawo");
                        break;
                    case BACKWARD:
                        System.out.println("zwierzak idzie do tyłu");
                        break;
                    case LEFT:
                        System.out.println("zwierzak skręca w lewo");
                        break;
                    default:
                        break;
                }
            }
        }

    }


    public static void main(String[] args) {
        System.out.println("Start");
        run(OptionsParser.parseOptions(args));
        System.out.println("Stop");

    }
}
