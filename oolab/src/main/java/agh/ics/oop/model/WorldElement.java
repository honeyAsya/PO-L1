package agh.ics.oop.model;

public interface WorldElement {
    Vector2d getPosition();

    String getElementImageName();

    void move(MoveDirection direction, MoveValidator moveValidator);
}