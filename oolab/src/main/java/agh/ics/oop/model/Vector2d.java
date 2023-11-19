package agh.ics.oop.model;
import java.util.Objects;

public class Vector2d {
    private final int x;
    private final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public String toString(){
        return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2d other){
        return this.x <= other.getX() && this.y <= other.getY();
    }

    public boolean follows(Vector2d other){
        return this.x >= other.getX() && this.y >= other.getY();
    }

    public Vector2d add(Vector2d other){
        int newX = this.x + other.getX();
        int newY = this.y + other.getY();
        return new Vector2d(newX, newY);
    }

    public Vector2d substract(Vector2d other){
        int newX = this.x - other.getX();
        int newY = this.y - other.getY();
        return new Vector2d(newX, newY);

    }

    public Vector2d upperRight(Vector2d other){
        int upperRightX = Math.max(this.x, other.getX());
        int upperRightY = Math.max(this.y, other.getY());
        return new Vector2d(upperRightX, upperRightY);
    }

    public Vector2d lowerLeft(Vector2d other){
        int lowerLeftX = Math.min(this.x, other.getX());
        int lowerLeftY = Math.min(this.y, other.getY());
        return new Vector2d(lowerLeftX, lowerLeftY);
    }

    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }
    @Override
    public boolean equals(Object other){
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Vector2d vector2d = (Vector2d) other;
        return x == vector2d.x && y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }



}
