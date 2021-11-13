package edu.isu.cs2263.acquire;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StartPage extends Application {
    Board1 board1=new Board1();
    Button drawANDplace= new Button("Start the game");
    String startTile;




    @Override
    public void start(Stage stage) {
        Text text=new Text(500,300,"ACQUIRE");
        text.setFill(Color.WHITESMOKE);
        Font font=Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 75);
        text.setFont(font);



        //Creating a Button
        Button button1 = new Button();
        Button button2=new Button();
        Button button3=new Button();
        button1.setStyle("-fx-font: 22 arial; -fx-base: green");
        button2.setStyle("-fx-font: 22 arial; -fx-base: Gray");
        button3.setStyle("-fx-font: 22 arial; -fx-base: red;");

        //Setting text to the button
        button1.setText("Start Game");
        button2.setText("Load Game");
        button3.setText("Exit Game ");
        //Setting the location of the button
        button1.setTranslateX(600);
        button1.setTranslateY(450);

        button2.setTranslateX(600);
        button2.setTranslateY(500);

        button3.setTranslateX(600);
        button3.setTranslateY(550);

        //---------------------------------------------------------------

        button1.setOnAction(event -> {

            Stage stageboard=new Stage();
            startgame(stageboard);
        });


        button3.setOnAction(event -> {
            exit();
        });







        //Setting the stage
        Group root = new Group(button1,button2,button3,text);
        Scene scene = new Scene(root, 595, 150, Color.WHITE);
        stage.setTitle("Start Page");
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }




        public void startgame(Stage start1){
            drawANDplace.setTranslateX(700);
            drawANDplace.setTranslateY(700);
            drawANDplace.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    startTile= board1.startGame();
                    drawANDplace.setText(startTile);
                }
            });
            int length = 12;
            int width = 9;
            GridPane root = new GridPane();
            ArrayList<String> tile= new Tile().wholeTiles();
            for(int x = 0; x < length; x++){
                for(int y = 0; y < width; y++){
                    // Create a new TextField in each Iteration
                    TextField tf = new TextField();
                    tf.setPrefHeight(60);
                    tf.setPrefWidth(60);
                    tf.setAlignment(Pos.CENTER);
                    tf.setText(tile.remove(0));
                    if(tf.getText().equals(startTile)){
                    //tf.setText(startTile);}
                    tf.setStyle("-fx-text-inner-color: #BA55D3;");}
                    //tf.setEditable(false);
                    // Iterate the Index using the loops
                    GridPane.setRowIndex(tf,y);
                    GridPane.setColumnIndex(tf,x);
                    root.getChildren().add(tf);
                }
            }


            Group root1=new Group(root,drawANDplace);
            Scene scene = new Scene(root1, 500, 500);
            scene.setFill(Color.BLACK);
            start1.setTitle("!!! Acquire Game !!!");
            start1.setScene(scene);
            start1.show();



        }













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