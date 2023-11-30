package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap {

    Map<Vector2d, Grass> grassMap = new HashMap<>();
    Map<Vector2d, Animal> animalsMap = new HashMap<>();

    public Map<Vector2d, Grass> getGrassMap() {
        return grassMap;
    }

    public void setGrassMap(Map<Vector2d, Grass> grassMap) {
        this.grassMap = grassMap;
    }

    public Map<Vector2d, Animal> getAnimalsMap() {
        return animalsMap;
    }

    public void setAnimalsMap(Map<Vector2d, Animal> animalsMap) {
        this.animalsMap = animalsMap;
    }

    public WorldElement objectAt(Vector2d position) {
        if (animalsMap.containsKey(position)) return animalsMap.get(position);
        if (grassMap.containsKey(position)) return grassMap.get(position);

        return null;
    }

    public boolean place(WorldElement element) {
        if (element instanceof Animal) {
            if (!animalsMap.containsKey(element.getPosition())) {
                this.animalsMap.put(element.getPosition(), (Animal) element);
                return true;
            }
        }
        if (element instanceof Grass) {
            grassMap.put(element.getPosition(), (Grass) element);
            return true;

        }
        return false;
    }

    public void move(WorldElement worldElement, MoveDirection direction, MoveValidator moveValidator) {
        if (worldElement instanceof Animal) {
            animalsMap.remove(worldElement.getPosition());
            worldElement.move(direction, moveValidator);
            animalsMap.put(worldElement.getPosition(), (Animal) worldElement);
        }
        if (worldElement instanceof Grass) {
            grassMap.remove(worldElement.getPosition());
            worldElement.move(direction, moveValidator);
            grassMap.put(worldElement.getPosition(), (Grass) worldElement);
        }
    }

    public boolean isOccupied(Vector2d position) {
        return animalsMap.containsKey(position) || grassMap.containsKey(position);
    }

    public List<WorldElement> getElements() {
        List<WorldElement> elements = new ArrayList<>();
        elements.addAll(grassMap.values());
        elements.addAll(animalsMap.values());
        return elements;
    }
}
