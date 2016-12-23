package com.example.projekt;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

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


        Pildiobjekt sokid = new Pildiobjekt(getClass().getResource("sokid.png").toExternalForm());
        sokid.setCenterX(100);
        sokid.setCenterY(400);
//        sokid.setFill(Color.WHITE);
//        sokid.setStroke(Color.BLACK);
        sokid.setCursor(Cursor.HAND);
        sokid.setOnMouseClicked(event -> {
        });
        sokid.setOnMouseDragged(event -> {
            double x = event.getX();
            sokid.setCenterX(x);
            double y = event.getY();
            sokid.setCenterY(y);
            sokid.toFront();
        });

        Circle ring1 = new Circle(50);
        ring1.setCenterX(400);
        ring1.setCenterY(400);
        ring1.setCursor(Cursor.HAND);
        ring1.setOnMouseClicked(event -> {
            // System.out.println("X: " + MouseEvent.getX() + " Y: " + MouseEvent.getY());
        });
        ring1.setOnMouseDragged(event -> {
            double x = event.getX();
            ring1.setCenterX(x);
            double y = event.getY();
            ring1.setCenterY(y);
            ring1.toFront();
        });

        Rectangle rectangle = new Rectangle(170, 30, 190, 250);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        Rectangle rectangle1;
        Circle ring3;
        {
            rectangle1 = new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), 50);
            rectangle1.setFill(Color.WHITE);
            rectangle1.setStroke(Color.BLACK);
            rectangle1.toFront();

            ring3 = new Circle(60);
            ring3.setCenterX(rectangle.getX()+ rectangle.getWidth()/2);
            ring3.setCenterY(rectangle.getY() + rectangle.getHeight()/2);
            ring3.toFront();
        }

        ring1.setOnMouseReleased(event -> {
            if (event.getX() > rectangle.getX()
                    && event.getY() > rectangle.getY()
                    && event.getX() < rectangle.getX() + rectangle.getWidth()
                    && event.getY() < rectangle.getY() + rectangle.getHeight()) {
                ring1.setCenterX(ring3.getCenterX());
                ring1.setCenterY(ring3.getCenterY());
                System.out.println("On sees");
                // ring1.removeEventHandler();
            }
        });
        sokid.setOnMouseReleased(event -> {
            if (event.getX() > rectangle.getX()
                    && event.getY() > rectangle.getY()
                    && event.getX() < rectangle.getX() + rectangle.getWidth()
                    && event.getY() < rectangle.getY() + rectangle.getHeight()) {
                sokid.setCenterX(100);
                sokid.setCenterY(400);
                // ring1.removeEventHandler();
            }
        });



        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: yellow;");
        pane.getChildren().add(sokid);
        pane.getChildren().add(ring1);
        pane.getChildren().add(rectangle);
        pane.getChildren().add(rectangle1);
        pane.getChildren().add(ring3);
        Scene seesStseen = new Scene(pane, 500, 500);


        submitButton.setOnAction(event -> {
            String kasutajanimi = usernameField.getText();
            String parool = pf.getText();
            if (kasutajanimi.equals("Linda") && parool.equals("parool123")) {
                System.out.println("Hakkame mängima!");
                primaryStage.setScene(seesStseen);
            } else {
                System.out.println("Vale kasutaja või parool");
            }
        });
    }
}