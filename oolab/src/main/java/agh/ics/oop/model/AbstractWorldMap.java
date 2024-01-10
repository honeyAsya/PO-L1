package agh.ics.oop.model;

import agh.ics.oop.exception.PositionAlreadyOccupiedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractWorldMap implements WorldMap {
   public Boundary getCurrentBounds(){
       int maxX = 0;
       int maxY = 0;

       int minX =0;
       int minY = 0;

       for (Vector2d position : animalsMap.keySet()) {
           maxX = Math.max(maxX, position.getX());
           maxY = Math.max(maxY, position.getY());
           minX = Math.min(minX, position.getX());
           minY = Math.min(minY, position.getY());
       }

       for (Vector2d position : grassMap.keySet()) {
           maxX = Math.max(maxX, position.getX());
           maxY = Math.max(maxY, position.getY());
           minX = Math.min(minX, position.getX());
           minY = Math.min(minY, position.getY());
       }


       Vector2d lowerLeft = new Vector2d(0, 0);
       Vector2d upperRight = new Vector2d(maxX, maxY);
       return new Boundary(upperRight, lowerLeft);
   }

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

    public Optional<WorldElement> objectAt(Vector2d position) {
        if (animalsMap.containsKey(position)) return Optional.of(animalsMap.get(position));
        if (grassMap.containsKey(position)) return Optional.of(grassMap.get(position));
        return Optional.empty();
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

    }

    public boolean isOccupied(Vector2d position) {
        return animalsMap.containsKey(position) || grassMap.containsKey(position);
    }

    public List<WorldElement> getElements() {
       return Stream.concat(grassMap.values().stream(), animalsMap.values().stream()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(getCurrentBounds().lowLeft(), getCurrentBounds().highRight());
    }

    @Override
    public List<Animal> getOrderedAnimals() {
        return animalsMap.entrySet()
                .stream()
                .sorted(Comparator.comparing((Map.Entry<Vector2d, Animal> v) -> v.getKey().getX())
                        .thenComparing((Map.Entry<Vector2d, Animal> v) ->  v.getKey().getY()))
                .map(Map.Entry::getValue)
                .toList();

    }
}
