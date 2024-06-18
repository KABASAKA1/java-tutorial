package com.java_javafx_tutorial.database.course;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainCourse extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("/com/java_javafx_tutorial/CourseView.fxml"));
        Scene scene=new Scene(root , 800 , 800);
        stage.setScene(scene);
        stage.show();
    }
}
