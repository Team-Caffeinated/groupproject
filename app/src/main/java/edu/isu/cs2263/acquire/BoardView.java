package edu.isu.cs2263.acquire;

import edu.isu.cs2263.acquire.GameBoard;
import edu.isu.cs2263.acquire.Tile;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BoardView extends Application {
    public static GameBoard game = new GameBoard();
    private String tile;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Button startthegame=new Button("Start the game");
        //startthegame.setTranslateX(700);
        //startthegame.setTranslateY(700);

        final String firsttile;

        //game.startGame();

        //startthegame.setOnAction(event -> {

         //   tile = game.drawTile(game.getDeck());
         //   startthegame.setText(tile);
         //   game.addPlayedTile(tile);
         //   System.out.println(tile);
        //});
        //System.out.println(tile);

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

        Group root = new Group(gridPane);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
