package agh.ics.oop.model;


import agh.ics.oop.exception.PositionAlreadyOccupiedException;

public class RectangularMap extends AbstractWorldMap implements WorldMap {

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
    public boolean place(WorldElement element) {
        try{
        return super.place(element);
    } catch (PositionAlreadyOccupiedException e) {
        System.out.println("Error while adding: " + e.getMessage());
    }
        return false;
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
    Boundary getCurrentBounds() {
        int maxX = 0;
        int maxY = 0;

        int minX = 0;
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

    @Override
    public WorldElement objectAt(Vector2d position) {
        return super.objectAt(position);
    }

}
