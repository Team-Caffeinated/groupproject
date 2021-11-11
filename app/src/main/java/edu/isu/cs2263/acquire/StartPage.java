package edu.isu.cs2263.acquire;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.Optional;

public class StartPage extends Application {
    @Override
    public void start(Stage stage) {
        //Label label=new Label("ACQUIRE");
        //label.setTranslateX(585);
        //label.setTranslateY(200);
        //label.setFont(new Font("Verdana", FontWeight.BOLD, FontPosture.ITALIC,50));

        Text text=new Text(500,300,"ACQUIRE");
        Font font=Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 75);
        text.setFont(font);



        //Creating a Button
        Button button1 = new Button();
        Button button2=new Button();
        Button button3=new Button();

        //Setting text to the button
        button1.setText("Start Game");
        button2.setText("Load Game");
        button3.setText("Exit Game ");
        //Setting the location of the button
        button1.setTranslateX(650);
        button1.setTranslateY(450);

        button2.setTranslateX(650);
        button2.setTranslateY(500);

        button3.setTranslateX(650);
        button3.setTranslateY(550);
        //---------------------------------------------------------------
        button1.setOnAction(event -> {
            Stage stage1=new Stage();
            startGame(stage1);
        });


        button3.setOnAction(event -> {
            exit();
        });







        //Setting the stage
        Group root = new Group(button1,button2,button3,text);
        Scene scene = new Scene(root, 595, 150, Color.WHITE);
        stage.setTitle("Start Page");
        stage.setScene(scene);
        stage.show();
    }
    public void startGame(Stage start) {

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
                //tf.setStyle("-fx-text-inner-color: #BA55D3;");
                tf.setEditable(false);

                tf.setText( tile.remove(0));

                // Iterate the Index using the loops
                root.setRowIndex(tf,y);
                root.setColumnIndex(tf,x);
                root.getChildren().add(tf);
            }
        }

        Scene scene = new Scene(root, 500, 500);
        start.setTitle("!!! Acquire Game !!!");
        start.setScene(scene);
        start.show();}
    public void exit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Are you sure you want to exit?");

        Optional<ButtonType> result = alert.showAndWait();
        result.ifPresent(btnType -> {
            if (btnType.getButtonData().isDefaultButton())
                System.exit(0);
        });
    }
    public static void main(String args[]){
        launch(args);
    }
}