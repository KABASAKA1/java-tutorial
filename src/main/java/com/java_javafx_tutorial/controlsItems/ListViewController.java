package com.java_javafx_tutorial.controlsItems;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class ListViewController extends Application implements Initializable  {
    @FXML
    ListView<Person> listView;
    @FXML
    Button button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Person> items = FXCollections.observableArrayList(
                new Person("Serkan" , 28),
                new Person("Ibrahim" , 24),
                new Person("Ahmet" , 25)
        );
        listView.setItems(items);
        listView.setCellFactory( new Callback<ListView<Person>, ListCell<Person>>() {
            @Override
            public ListCell<Person> call(ListView<Person> param) {
                return new ListCell<Person>(){
                    @Override
                    protected void updateItem(Person person, boolean empty) {
                        super.updateItem(person, empty);
                        if (empty || person == null) {
                            setText(null);
                        }else {
                            HBox hbox = new HBox(new Label(person.getName()), new Label(" (" + person.getAge() + " years old)"));
                            hbox.setSpacing(10);
                            setGraphic(hbox);
                        }
                    }
                };
            }
        });


        listView.setOnMouseClicked(event -> {

        });
    }


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/java_javafx_tutorial/ControlsDeneme.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("Hello World");
        stage.setWidth(800);
        stage.setHeight(800);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
