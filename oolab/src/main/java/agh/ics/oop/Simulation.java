package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.List;

public class Simulation {
    List<Animal> animalList;
    List<MoveDirection> moves;

    WorldMap worldMap;

    public Simulation(List<Vector2d> vectors, List<MoveDirection> moves, WorldMap worldMap) {
        this.animalList = vectors.stream()
                .map(Animal::new)
                .toList();
        this.worldMap = worldMap;
        this.moves = moves;

    }

    public void run() {
        for (int moveIndex = 0; moveIndex < moves.size(); moveIndex++) {
            int animalIndex = moveIndex % animalList.size();
            animalList.get(animalIndex).move(moves.get(moveIndex), worldMap);
            Animal animal = animalList.get(animalIndex);
            System.out.println("Zwierzę " + animalIndex + " : " + animal.toString());
        }
    }
}