package com.java_javafx_tutorial.event_handle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class ClickEvent implements EventHandler<ActionEvent> {
    private Label label;
    public ClickEvent(Label label){
        this.label = label;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        double r = Math.random();
        double g = Math.random();
        double b = Math.random();
        Color color=Color.color(r,g,b);
        label.setTextFill(color);
    }
}
