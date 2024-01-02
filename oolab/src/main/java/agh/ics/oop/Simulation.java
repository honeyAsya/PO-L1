package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;
import java.util.Objects;

public class Simulation implements Runnable {
    List<Animal> animalList;
    List<MoveDirection> moves;

    WorldMap worldMap;

    public Simulation(List<Vector2d> vectors, List<MoveDirection> moves, WorldMap worldMap) {
        this.animalList = vectors.stream()
                .map(vec -> {
                    WorldElement worldElement = worldMap.objectAt(vec);
                    return worldElement instanceof Animal ? (Animal) worldElement : null;
                })
                .filter(Objects::nonNull)
                .toList();
        this.worldMap = worldMap;
        this.moves = moves;

    }

    @Override
    public void run() {
        for (int moveIndex = 0; moveIndex < moves.size(); moveIndex++) {
            int animalIndex = moveIndex % animalList.size();
            Animal animal = animalList.get(animalIndex);
            worldMap.move(animal, moves.get(moveIndex));
            //animalList.get(animalIndex).move(moves.get(moveIndex), worldMap);
            System.out.println("Zwierzę " + animalIndex + " : " + animal.toString());
        }
    }
}