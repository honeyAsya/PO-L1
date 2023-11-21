package agh.ics.oop.model;

import java.util.LinkedList;


public class TextMap implements WorldMap<String, Integer> {
    LinkedList<String> animals = new LinkedList<>();

    int width;

    public TextMap(int width) {
        this.width = width;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position.getX()) &&
                (position.getX() <= animals.size()) &&
                (position.getX() >= (0));
    }

    @Override
    public boolean place(String animal) {
        return animals.add(animal);
    }

    @Override
    public void move(String animal, MoveDirection direction) {
        Integer animalIndex = animals.indexOf(animal);

        switch (direction) {
            case FORWARD -> {
                if (canMoveTo(new Vector2d(animalIndex + 1, 0))) {
                    animals.remove(animalIndex);
                    animals.add(animalIndex + 1, animal);
                }

            }
            case BACKWARD -> {
                if (canMoveTo(new Vector2d(animalIndex - 1, 0))) {
                    animals.remove(animalIndex);
                    animals.add(animalIndex - 1, animal);
                }

            }
        }
    }

    @Override
    public boolean isOccupied(Integer position) {
        return false;
    }

    @Override
    public String objectAt(Integer position) {
        return animals.get(position);
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(new Vector2d(-width, 0), new Vector2d(width, 0));
    }
}
