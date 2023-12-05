package agh.ics.oop.exception;

import agh.ics.oop.model.Vector2d;

public class PositionAlreadyOccupiedException extends Exception {

    public PositionAlreadyOccupiedException(Vector2d vector2d){
            super("Position (%s, %s) is already occupied".formatted(vector2d.getX(), vector2d.getY()));
    }
}