package agh.ics.oop.model;

public interface WorldElement {
    Vector2d getPosition();

    void move(MoveDirection direction, MoveValidator moveValidator);
}