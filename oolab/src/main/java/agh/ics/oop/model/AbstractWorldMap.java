package agh.ics.oop.model;

import agh.ics.oop.exception.PositionAlreadyOccupiedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {
   abstract Boundary getCurrentBounds();

   public static final String ANIMAL_PLACED = "Dodano zwierzęcie";
    public static final String ANIMAL_MOVED = "Zmieniono pozycje zwierzęcia";

  public void addObservator(MapChangeListener mapChangeListener){
      listeners.add(mapChangeListener);
   }

  public void removeObservator(MapChangeListener mapChangeListener){
       listeners.remove(mapChangeListener);
   }

   void mapChanged(String message) {
      listeners
              .stream().forEach(listener -> listener.mapChanged(this, message));
   }

    Map<Vector2d, Grass> grassMap = new HashMap<>();
    Map<Vector2d, Animal> animalsMap = new HashMap<>();
    List<MapChangeListener> listeners = new ArrayList<>();

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

    public boolean place(WorldElement element) throws PositionAlreadyOccupiedException {
        if (element instanceof Animal) {
            if (!animalsMap.containsKey(element.getPosition())) {
                this.animalsMap.put(element.getPosition(), (Animal) element);
                mapChanged(ANIMAL_PLACED);
                return true;
            }
        }
        if (element instanceof Grass) {
            grassMap.put(element.getPosition(), (Grass) element);
            mapChanged(ANIMAL_PLACED);
            return true;

        }
        throw new PositionAlreadyOccupiedException(element.getPosition());
    }

    public void move(WorldElement worldElement, MoveDirection direction, MoveValidator moveValidator) {
        if (worldElement instanceof Animal) {
            animalsMap.remove(worldElement.getPosition());
            worldElement.move(direction, moveValidator);
            animalsMap.put(worldElement.getPosition(), (Animal) worldElement);
            mapChanged(ANIMAL_MOVED);
        }
        if (worldElement instanceof Grass) {
            grassMap.remove(worldElement.getPosition());
            worldElement.move(direction, moveValidator);
            grassMap.put(worldElement.getPosition(), (Grass) worldElement);
            mapChanged(ANIMAL_MOVED);
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

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(getCurrentBounds().lowLeft(), getCurrentBounds().highRight());
    }
}
