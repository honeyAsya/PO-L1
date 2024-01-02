package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.ui.SimulationApp;
import javafx.application.Application;

import java.util.List;

public class World {

    public static void run(List<MoveDirection> moves) {
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
        Application.launch(SimulationApp.class, args);
    }
}
