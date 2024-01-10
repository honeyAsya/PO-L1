package agh.ics.oop.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class FileMapDisplay implements MapChangeListener{
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        try{
            File logFile = new File("map_%s.log".formatted(worldMap.getId().toString()));
            if (!logFile.exists()){
                logFile.createNewFile();
            }
            Files.write(logFile.toPath(), (message + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
