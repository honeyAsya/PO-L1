package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;


public class RectangularMap implements WorldMap<Animal,Vector2d> {
    Map<Vector2d, Animal> animals = new HashMap<>();

    int width;
    int height;


    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) &&
                (position.getY() <= height) &&
                (position.getX() <= width) &&
                (position.getY() >= (-height)) &&
                (position.getX() >= (-width));
    }

    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getMapCoordinates())) {
            animals.put(animal.getMapCoordinates(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        animals.remove(animal.getMapCoordinates());
        animal.move(direction, this);
        animals.put(animal.getMapCoordinates(), animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(new Vector2d(-width, -height), new Vector2d(width, height));
    }
}
