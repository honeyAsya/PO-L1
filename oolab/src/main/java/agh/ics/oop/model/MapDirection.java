package agh.ics.oop.model;

public enum MapDirection {
    EAST("Wschód", "SOUTH", "NORTH", new Vector2d(1, 0)),
    NORTH("Północ", "EAST", "WEST", new Vector2d(0, 1)),
    WEST("Zachód", "NORTH", "SOUTH", new Vector2d(-1, 0)),
    SOUTH("Południe", "WEST", "EAST", new Vector2d(0, -1));


    private final String name;
    private final String nextDirection;
    private final String previousDirection;

    private final Vector2d coords;

    MapDirection(String name, String nextDirection, String previousDirection, Vector2d coords) {
        this.name = name;
        this.nextDirection = nextDirection;
        this.previousDirection = previousDirection;

        this.coords = coords;
    }

    @Override
    public String toString() {
        return name;
    }

    public MapDirection next() {
        return MapDirection.valueOf(this.nextDirection);
    }

    public MapDirection previous() {
        return MapDirection.valueOf(this.previousDirection);
    }

    public Vector2d toUnitVector() {
        return this.coords;
    }
}
