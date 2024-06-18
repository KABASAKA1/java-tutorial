package com.java_javafx_tutorial.textDers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RegistrationForm extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(true);

        Label lblTitle = new Label("Registration Form");
        lblTitle.setFont(Font.font(24));
        lblTitle.setTextFill(Color.NAVY );
        grid.add(lblTitle, 1, 1);

        Label lblUsername = new Label("Username : ");
        lblUsername.setFont(Font.font(18));

        TextField tfUsername = new TextField();
        tfUsername.setPromptText("Username");
        tfUsername.setFont(Font.font(18));
        tfUsername.setOnAction(actionEvent -> {
            System.out.println(tfUsername.getText());
        });

        grid.add(lblUsername, 1, 2);
        grid.add(tfUsername, 2, 2);


        Label lblPassword = new Label("Password : ");
        lblPassword.setFont(Font.font(18));

        PasswordField pfPassword = new PasswordField();
        pfPassword.setPromptText("password");
        pfPassword.setFont(Font.font(18));

        grid.add(lblPassword, 1, 3);
        grid.add(pfPassword, 2, 3);


        Label lblskills = new Label("Skills : ");
        lblskills.setFont(Font.font(18));

        CheckBox cbCPP = new CheckBox("C++");
        cbCPP.setFont(Font.font(18));
        CheckBox cbJava = new CheckBox("Java");
        cbJava.setFont(Font.font(18));
        CheckBox cbPython = new CheckBox("Python");
        cbPython.setFont(Font.font(18));


        HBox boxSkills = new HBox();
        boxSkills.getChildren().addAll(cbCPP, cbJava, cbPython);
        boxSkills.setSpacing(10);

        grid.add(lblskills, 1, 4);
        grid.add(boxSkills, 2, 4);


        Label lblGender = new Label("Gender : ");
        lblGender.setFont(Font.font(18));

        RadioButton rbFemale = new RadioButton("Female");
        rbFemale.setFont(Font.font(18));
        RadioButton rbMale = new RadioButton("Male");
        rbMale.setFont(Font.font(18));
        ToggleGroup gender = new ToggleGroup();
        rbFemale.setToggleGroup(gender);
        rbMale.setToggleGroup(gender);
        HBox boxGender = new HBox();
        boxGender.getChildren().addAll(rbFemale, rbMale);
        boxGender.setSpacing(10);

        grid.add(lblGender, 1, 5);
        grid.add(boxGender, 2, 5);



        Label lblUniversity = new Label("University : ");
        lblUniversity.setFont(Font.font(18));
        ComboBox<String> cbUniversity = new ComboBox<>();
        cbUniversity.getItems().addAll("Kayseri university" , "Erciyes univeersity" , "Mali University");
        cbUniversity.setPromptText("University");
        cbUniversity.setEditable(true);

        grid.add(lblUniversity, 1, 6);
        grid.add(cbUniversity, 2, 6);



        EventHandler<ActionEvent> eventHandler = e -> {
            String skills = "Skills = ";
            if (cbCPP.isSelected()) {
                skills += " CPP ";
            }
            if (cbJava.isSelected()) {
                skills += " Java ";
            }
            if (cbPython.isSelected()) {
                skills += " Python ";
            }
            System.out.println(skills);

        };

        Button button = new Button("Kayit");
        button.setFont(Font.font(18));
        button.setOnAction(eventHandler);
        grid.add(button, 1, 5);
        //button.setGraphic(new ImageView("//home//serkan//İndirilenler//cwacw.jpg"));





        Scene scene = new Scene(grid , 600,600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
