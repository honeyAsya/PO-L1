package agh.ics.oop.model;

import java.sql.SQLOutput;

public class ConsoleMapDisplay implements MapChangeListener{
    private static Long notifiedCount = 0L;

    @Override
    public synchronized void mapChanged(WorldMap worldMap, String message) {
        notifiedCount ++;
        Object mapId = worldMap.getId();
        System.out.println("Ilość zmian: " + notifiedCount);
        System.out.println("Wykonana operacja: " + message);
        System.out.println(worldMap.toString());
        System.out.println("Map ID: " + mapId);
    }
}