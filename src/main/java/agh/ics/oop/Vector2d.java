package agh.ics.oop;

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

    boolean precedes(Vector2d other){
        return this.x <= other.getX() && this.y <= other.getY();
    }

    boolean follows(Vector2d other){
        return this.x >= other.getX() && this.y >= other.getY();
    }

    Vector2d add(Vector2d other){
        int newX = this.x + other.getX();
        int newY = this.y + other.getY();
        return new Vector2d(newX, newY);
    }



}
