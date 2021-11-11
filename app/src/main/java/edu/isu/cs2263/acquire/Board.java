package edu.isu.cs2263.acquire;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Board extends Application {

    @Override
    public void start(Stage primaryStage) {

        //int SIZE = 5;
        int length = 12;
        int width = 9;
        String text;

        GridPane root = new GridPane();
        ArrayList<String> tile= new Tile().wholeTiles();
        for(int x = 0; x < length; x++){
            for(int y = 0; y < width; y++){
                // Create a new TextField in each Iteration
                TextField tf = new TextField();
                tf.setPrefHeight(60);
                tf.setPrefWidth(60);
                tf.setAlignment(Pos.CENTER);
                tf.setEditable(false);

                tf.setText( tile.remove(0));

                // Iterate the Index using the loops
                root.setRowIndex(tf,y);
                root.setColumnIndex(tf,x);
                root.getChildren().add(tf);
            }
        }

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("!!! Acquire Game !!!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}