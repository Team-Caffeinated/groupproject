package edu.isu.cs2263.acquire;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 *
 * @web http://zoranpavlovic.blogspot.com/
 */
public class Sample extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Board1 board2=new Board1();
        final String firsttile;
        Button drawA=new Button("Click");
        drawA.setTranslateX(700);
        drawA.setTranslateY(700);
        drawA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //firsttile = board2.startGame();
                drawA.setText(board2.startGame());
            }
        });
        primaryStage.setTitle("GridPane example");

//Adding GridPane
        GridPane gridPane = new GridPane();

// 2D array of Buttons with value of 5,5
        Button[][] btn = new Button[12][12];
        ArrayList<String> tile= new Tile().wholeTiles();

//Column is a vertical line and row is a horizontal line
//Two FOR loops used for creating 2D array of buttons with values i,j

        for(int j=0; j<12;j++){
                for(int i=0; i<9; i++){
//Initializing 2D buttons with values i,j
                    btn[i][j] = new Button();
                    btn[i][j].setText(tile.remove(0));
                    btn[i][j].setPrefSize(50, 50);
                    gridPane.add(btn[i][j], j, i);
            }
        }

//Adding GridPane to the scene
        System.out.println();
        Group root = new Group(gridPane,drawA);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}