package agh.ics.oop;

import agh.ics.oop.model.*;

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
        System.out.println("Start");
        run(OptionsParser.parseOptions(args));
        System.out.println("Stop");

        Animal szajluszaj = new Animal();
        Animal animal2 = new Animal(new Vector2d(5,2));
        Animal animal3 = new Animal(new Vector2d(6,2));
        Animal animal4 = new Animal(new Vector2d(7,3));
        Animal animal5 = new Animal(new Vector2d(8,4));
        Animal animal6 = new Animal(new Vector2d(2,5));
        Animal animal7 = new Animal(new Vector2d(3,8));

        Animal animal2_2 = new Animal(new Vector2d(5,2));
        Animal animal3_2 = new Animal(new Vector2d(6,2));
        Animal animal4_2 = new Animal(new Vector2d(7,3));
        Animal animal5_2 = new Animal(new Vector2d(8,4));
        Animal animal6_2 = new Animal(new Vector2d(2,5));
        Animal animal7_2 = new Animal(new Vector2d(3,8));

        System.out.println(szajluszaj);
        ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
        ConsoleMapDisplay consoleMapDisplay1 = new ConsoleMapDisplay();
        List<MoveDirection> directions = OptionsParser.parseOptions(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        GrassField grassWorld =  new GrassField(10);
        RectangularMap rectangularWorld = new RectangularMap(20,20);
        grassWorld.addObservator(consoleMapDisplay);
        grassWorld.place(szajluszaj);
        grassWorld.place(animal2);
        grassWorld.place(animal3);
        grassWorld.place(animal4);
        grassWorld.place(animal5);
        grassWorld.place(animal6);
        grassWorld.place(animal7);

        rectangularWorld.addObservator(consoleMapDisplay1);
        rectangularWorld.place(animal2_2);
        rectangularWorld.place(animal3_2);
        rectangularWorld.place(animal4_2);
        rectangularWorld.place(animal5_2);
        rectangularWorld.place(animal6_2);
        rectangularWorld.place(animal7_2);

        Simulation simulation = new Simulation(positions, directions,grassWorld);
        Simulation simulation1 = new Simulation(positions, directions, rectangularWorld);

        SimulationEngine simulationEngine = new SimulationEngine(List.of(simulation1, simulation));
        simulationEngine.runSync();
        //simulationEngine.runAsync();
        simulationEngine.runAsyncInThreadPool();
        System.out.println("All tasks end");

    }
}
