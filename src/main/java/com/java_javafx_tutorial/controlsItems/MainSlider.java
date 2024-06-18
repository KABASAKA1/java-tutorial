package com.java_javafx_tutorial.controlsItems;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainSlider extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Slider slHorizantal = new Slider(0,100,50);
        Slider slVertical = new Slider(0,100,50);
        slHorizantal.setShowTickLabels(true);
        slHorizantal.setShowTickMarks(true);
        slVertical.setShowTickLabels(true);
        slVertical.setShowTickMarks(true);
        slHorizantal.setMajorTickUnit(25);
        slHorizantal.setMinorTickCount(5);
        slHorizantal.setBlockIncrement(10);
        slVertical.setBlockIncrement(10);
        slVertical.setMajorTickUnit(25);
        slVertical.setMinorTickCount(5);

        Label horizantalLabel = new Label("Horizantal Value" + slHorizantal.getValue());
        slHorizantal.valueProperty().addListener((observable, oldValue, newValue) -> {
            horizantalLabel.setText("Horizantal valoe" + newValue.toString());
        });
        Label verticalLabel = new Label("Vertical Value" + slVertical.getValue());
        slVertical.valueProperty().addListener((observable, oldValue, newValue) -> {
            verticalLabel.setText("Vertical valoe" + newValue.toString());
        });
        VBox root = new VBox(20 ,slHorizantal,slVertical,horizantalLabel,verticalLabel);
        Scene scene = new Scene(root ,400,300);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
