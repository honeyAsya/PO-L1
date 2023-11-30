package agh.ics.oop.model;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap implements WorldMap{

    public GrassField(int grassCount) {
        IntStream.range(0, grassCount)
                .forEach(ind -> {
                    boolean placed = false;
                    do {
                        int x = (int) (Math.random() * sqrt(grassCount * 10));
                        int y = (int) (Math.random() * sqrt(grassCount * 10));
                        Vector2d positionToPlace = new Vector2d(x, y);
                        if (!getGrassMap().containsKey(positionToPlace)) {
                            getGrassMap().put(positionToPlace, new Grass(positionToPlace));
                            placed = true;
                        }
                    } while (!placed);
                });

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
      return super.objectAt(position);
    }

    @Override
    public boolean place(WorldElement element) {
       return super.place(element);
    }

    @Override
    public void move(WorldElement worldElement, MoveDirection direction) {
        super.move(worldElement, direction, this);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
       return super.isOccupied(position);
    }

    @Override
    public String toString() {

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

        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d lowerLeft = new Vector2d(0, 0);
        Vector2d upperRight = new Vector2d(maxX, maxY);
        return visualizer.draw(lowerLeft, upperRight);
    }

}
