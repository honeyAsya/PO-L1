package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    private static Long notifiedCount = 0L;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        notifiedCount ++;
        System.out.println("Ilość zmian: " + notifiedCount);
        System.out.println("Wykonana operacja: " + message);
        System.out.println(worldMap.toString());
    }
}