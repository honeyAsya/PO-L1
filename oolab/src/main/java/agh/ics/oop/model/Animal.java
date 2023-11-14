package agh.ics.oop.model;

import agh.ics.oop.MapDirection;
import agh.ics.oop.Vector2d;

public class Animal {
    private MapDirection mapDirection;
    private Vector2d mapCoordinates;

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
        return this.mapCoordinates.toString() + " : " + this.mapDirection.name();
    }

    public boolean isAt(Vector2d position) {
        return this.mapCoordinates.equals(position);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case LEFT -> this.mapDirection = this.mapDirection.previous();
            case RIGHT -> this.mapDirection = this.mapDirection.next();
            case FORWARD -> {
                switch (this.mapDirection) {
                    case NORTH -> {
                        if (this.mapCoordinates.getY() < 4) {
                            this.mapCoordinates = this.mapCoordinates.add(this.mapDirection.toUnitVector());
                        }
                    }
                    case EAST -> {
                        if (this.mapCoordinates.getX() < 4) {
                            this.mapCoordinates = this.mapCoordinates.add(this.mapDirection.toUnitVector());
                        }
                    }
                    case WEST -> {
                        if (this.mapCoordinates.getX() > 0) {
                            this.mapCoordinates = this.mapCoordinates.add(this.mapDirection.toUnitVector());
                        }
                    }
                    case SOUTH -> {
                        if (this.mapCoordinates.getY() > 0) {
                            this.mapCoordinates = this.mapCoordinates.add(this.mapDirection.toUnitVector());
                        }
                    }

                }
            }
            case BACKWARD -> {
                switch (this.mapDirection) {
                    case NORTH -> {
                        if (this.mapCoordinates.getY() > 0) {
                            this.mapCoordinates = this.mapCoordinates.substract(this.mapDirection.toUnitVector());
                        }
                    }
                    case EAST -> {
                        if (this.mapCoordinates.getX() > 0) {
                            this.mapCoordinates = this.mapCoordinates.substract(this.mapDirection.toUnitVector());
                        }
                    }
                    case WEST -> {
                        if (this.mapCoordinates.getX() < 4) {
                            this.mapCoordinates = this.mapCoordinates.substract(this.mapDirection.toUnitVector());
                        }
                    }
                    case SOUTH -> {
                        if (this.mapCoordinates.getY() < 4) {
                            this.mapCoordinates = this.mapCoordinates.substract(this.mapDirection.toUnitVector());
                        }
                    }
                }
            }
        }
    }
}