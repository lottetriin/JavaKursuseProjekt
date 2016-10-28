package com.example.projekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by lotte-triin on 17.10.2016.
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("PESUPESEMISE MÄNG");
        primaryStage.show();
        VBox vbox = new VBox();
        Scene login = new Scene(vbox, 300, 150);
        primaryStage.setScene(login);
        primaryStage.show();

        Label username = new Label("Kasutajanimi");
        TextField usernameField = new TextField();
        Label password = new Label("Parool");
        PasswordField pf = new PasswordField();
        Button submitButton = new Button("Login");

        vbox.getChildren().addAll(username, usernameField, password, pf, submitButton);

        Circle ring = new Circle(50);
        Pane pane = new Pane();
        pane.getChildren().add(ring);
        Scene seesStseen = new Scene(pane, 600, 500);

        submitButton.setOnAction(event -> {
            String Linda = usernameField.getText();
            String parool123 = pf.getText();
            if(Linda.equals(Linda) && parool123.equals(parool123)){
                System.out.println("Hakkame mängima!");
                primaryStage.setScene(seesStseen);
            }
            else{
                System.out.println("Vale kasutaja või parool");
            }
        });
    }
}