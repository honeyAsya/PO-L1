package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;

import java.util.List;

public class Simulation {
    List<Animal> animalList;
    List<MoveDirection> moves;

    public Simulation(List<Vector2d> vectors, List<MoveDirection> moves) {
        this.animalList = vectors.stream()
                .map(Animal::new)
                .toList();
        this.moves = moves;

    }

    public void run() {
        for (int moveIndex = 0; moveIndex < moves.size(); moveIndex++) {
            int animalIndex = moveIndex % animalList.size();
            animalList.get(animalIndex).move(moves.get(moveIndex));
            Animal animal = animalList.get(animalIndex);
            System.out.println("Zwierzę " + animalIndex + " : " + animal.toString());
        }
    }
}