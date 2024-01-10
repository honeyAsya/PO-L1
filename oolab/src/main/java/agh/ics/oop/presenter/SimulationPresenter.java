package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import agh.ics.oop.ui.SimulationApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.lang.Math.abs;

public class SimulationPresenter implements MapChangeListener {
    private WorldMap worldMap;
    @FXML
    private Label moveInfo;

    @FXML
    private TextArea textField;

    @FXML
    private GridPane field;

    public void onSimulationStartClicked(MouseEvent mouseEvent) throws Exception {
        if (mouseEvent.getClickCount() < 2){
            runSimulation();
        } else {
            new SimulationApp().start(new Stage());
        }

    }


    private void runSimulation() {
        GrassField grassWorld = new GrassField(10);
        grassWorld.addObservator(this);
        grassWorld.addObservator(new FileMapDisplay());
        grassWorld.addObservator(((worldMap1, message) -> System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")) + " " + message)));
        List<MoveDirection> directions = OptionsParser.parseOptions(textField.getText().split(" "));
        List<Animal> animals = List.of(new Animal(new Vector2d(2, 6)), new Animal(new Vector2d(3, 4)));
        List<Vector2d> positions = animals.stream().map(Animal::getPosition).toList();
        animals.forEach(grassWorld::place);
        Simulation simulation = new Simulation(positions, directions, grassWorld);
        SimulationEngine simulationEngine = new SimulationEngine(List.of(simulation));
        simulationEngine.runAsync();
        setWorldMap(grassWorld);
        drawMap();
    }

    public void drawMap() {
        clearGrid();
        createColumnsAndRows();
        fillGridInfoForColumnsAndRows();
        field.add(new Label("y\\x"), 0, 0);
    }

    private void fillGridInfoForColumnsAndRows() {
        Vector2d highRight = worldMap.getCurrentBounds().highRight();
        Vector2d lowLeft = worldMap.getCurrentBounds().lowLeft();

        fillIndexes(lowLeft.getX() - 1, highRight.getX(), String::valueOf, true);
        fillIndexes(highRight.getY() + 1, lowLeft.getY(), String::valueOf, false);

        fillWorldElements(lowLeft.getX(), highRight.getY());
    }

    private void fillIndexes(Integer maxR, Integer minL, Function<Integer, String> fillRowColumn, boolean isRow) {
        for (int index = 1; index <= abs(maxR - minL); index++) {
            if (isRow) {
                fillCell(index, 0, fillRowColumn.apply(maxR + index));
            } else {
                fillCell(0, index, fillRowColumn.apply(maxR - index));
            }
        }
    }

    private void fillWorldElements(Integer minX, Integer maxY) {
        worldMap.getElements()
                .forEach(element -> {
                    Vector2d elementPosition = worldMap.objectAt(element.getPosition()).get().getPosition();

                    int reqX = abs(minX - elementPosition.getX()) + 1;
                    int reqY = abs(maxY - elementPosition.getY()) + 1;
                    WorldElementBox worldElementBox = new WorldElementBox( worldMap.objectAt(element.getPosition()).get());
                    field.add(worldElementBox.getvElementBox(), reqX, reqY);
                });
    }

    private void fillCell(int x, int y, Object text) {
        Label label = new Label(String.valueOf(text));
        field.add(label, x, y);
        GridPane.setHalignment(label, HPos.CENTER);
    }

    private void createColumnsAndRows() {
        Vector2d highRight = worldMap.getCurrentBounds().highRight();
        Vector2d lowLeft = worldMap.getCurrentBounds().lowLeft();
        IntStream.rangeClosed(lowLeft.getY(), highRight.getY() + 1).forEach(h -> field.getRowConstraints().add(new RowConstraints(50)));
        IntStream.rangeClosed(lowLeft.getX(), highRight.getX() + 1).forEach(h -> field.getColumnConstraints().add(new ColumnConstraints(50)));
    }


    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }


    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(() -> {
            setWorldMap(worldMap);
            drawMap();
            moveInfo.setText(message);
        });

    }

    private void clearGrid() {
        field.getChildren().retainAll(field.getChildren().get(0));
        field.getColumnConstraints().clear();
        field.getRowConstraints().clear();
    }

}
