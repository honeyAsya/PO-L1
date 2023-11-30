package agh.ics.oop.model;

import java.util.Objects;

public class Grass implements WorldElement {
    private Vector2d position;

    public Grass(Vector2d position) {

        this.position = position;
    }

    public void setPosition(Vector2d vector2d){
        this.position = vector2d;
    }
    public Vector2d getPosition() {
        return position;
        }

    public void move(MoveDirection direction, MoveValidator moveValidator) {
        switch (direction) {
            case LEFT -> {
                if (moveValidator.canMoveTo(this.position.substract(new Vector2d(1,0))))
                {
                    setPosition(this.position.substract(new Vector2d(1,0)));
                }
            }

            case RIGHT ->{
            if (moveValidator.canMoveTo(this.position.add(new Vector2d(1,0))))
            {
                setPosition(this.position.add(new Vector2d(1,0)));
            }
        }

            case FORWARD -> {
                if (moveValidator.canMoveTo(this.position.add(new Vector2d(0,1))))
                {
                    setPosition(this.position.add(new Vector2d(0,1)));
                }
            }
            case BACKWARD -> {
                if (moveValidator.canMoveTo(this.position.substract(new Vector2d(0,1))))
                {
                    setPosition(this.position.substract(new Vector2d(0,1)));
                }
            }
        }
    }

    @Override
    public String toString(){
        return "*";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grass grass = (Grass) o;
        return Objects.equals(position, grass.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
