package edu.isu.cs2263.acquire;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
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
public class GameBoardView extends Application {



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button startthegame=new Button("Start the game");
        startthegame.setTranslateX(700);
        startthegame.setTranslateY(700);
        GameBoard board2=new GameBoard();
        final String firsttile;
        GameBoard game = new GameBoard();
        game.startGame();

        startthegame.setOnMouseClicked(event -> {
            String tile;
            tile = game.drawTile(game.getDeck());
            startthegame.setText(tile);
            game.addPlayedTile(tile);
            System.out.println(game.getPlayedTiles());
        });
        System.out.println("this bitch "+game.getPlayedTiles());

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

        Group root = new Group(gridPane,startthegame);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}