package agh.ics.oop.model;

public class Animal {
    private MapDirection mapDirection;
    private Vector2d mapCoordinates;

    public void setMapDirection(MapDirection mapDirection) {
        this.mapDirection = mapDirection;
    }

    public void setMapCoordinates(Vector2d mapCoordinates) {
        this.mapCoordinates = mapCoordinates;
    }

    public MapDirection getMapDirection() {
        return mapDirection;
    }

    public Vector2d getMapCoordinates() {
        return mapCoordinates;
    }

    public Animal() {
        this.mapDirection = MapDirection.NORTH;
        this.mapCoordinates = new Vector2d(2, 2);
    }

    public Animal(Vector2d mapCoordinates) {
        this.mapDirection = MapDirection.NORTH;
        this.mapCoordinates = mapCoordinates;
    }

    @Override
    public String toString() {
        return this.mapCoordinates.toString() + " : " + this.mapDirection.name().charAt(0);
    }

    public boolean isAt(Vector2d position) {
        return this.mapCoordinates.equals(position);
    }

    public void move(MoveDirection direction, MoveValidator moveValidator) {
        switch (direction) {
            case LEFT -> this.mapDirection = this.mapDirection.previous();
            case RIGHT -> this.mapDirection = this.mapDirection.next();
            case FORWARD -> {
                if (moveValidator.canMoveTo(this.mapCoordinates.add(this.mapDirection.toUnitVector()))) {
                    setMapCoordinates(this.mapCoordinates.add(this.mapDirection.toUnitVector()));
                }
            }
            case BACKWARD -> {
                if (moveValidator.canMoveTo(this.mapCoordinates.substract(this.mapDirection.toUnitVector()))) {
                    setMapCoordinates(this.mapCoordinates.substract(this.mapDirection.toUnitVector()));
                }
            }
        }
    }
}