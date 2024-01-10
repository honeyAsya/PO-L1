package agh.ics.oop.model;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class WorldElementBox {
    private VBox vElementBox;

    public VBox getvElementBox() {
        return vElementBox;
    }

    public WorldElementBox(WorldElement worldElement){
        VBox vBox = new VBox();
        ImageView imageView = new ImageView();
        configureImageViewWithImageByName(worldElement.getElementImageName(), imageView);
        Label elementName = new Label(worldElement.toString());
        vBox.getChildren().add(imageView);
        vBox.getChildren().add(elementName);
        vBox.alignmentProperty().setValue(Pos.CENTER);
        this.vElementBox = vBox;
    }

    private void configureImageViewWithImageByName(String imageName, ImageView imageView){
        imageView.setImage(new Image(getClass().getClassLoader().getResourceAsStream(imageName)));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
    }
}
