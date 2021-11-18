package edu.isu.cs2263.acquire;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Optional;

public class StartPage extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PauseTransition pauseacquire = new PauseTransition(Duration.seconds(2.4));
        PauseTransition pausenewgame = new PauseTransition(Duration.seconds(5));
        PauseTransition pauseloadgame = new PauseTransition(Duration.seconds(6));
        PauseTransition pauseexitgame = new PauseTransition(Duration.seconds(7));
        //--------------------------------------------------------------------------------------------------------------
        primaryStage.setTitle("ACQUIRE GAME");
        Label acquire=new Label("WELCOME TO ACQUIRE");
        Button newgame=new Button("NEW GAME");
        Button loadgame=new Button("LOAD GAME");
        Button exitgame=new Button("EXIT GAME ");
        loadgame.setVisible(false);
        newgame.setVisible(false);
        exitgame.setVisible(false);
        //---------------------------------------------------------------------------------------------------------------
        //welcome titel
        acquire.setTranslateX(50);
        acquire.setTranslateY(400);
        acquire.setTextFill(Color.BEIGE);
        acquire.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD,100));
        acquire.setStyle("-fx-font-style:italic");
        pauseacquire.setOnFinished(event -> {
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(200), acquire);
            fadeTransition.setToValue(0);
            fadeTransition.play();
        });
        pauseacquire.play();
        //-------------------------------------------------------------------------------------------------------------
        //button for new game
        pausenewgame.setOnFinished(event -> {
            newgame.setVisible(true);
            newgame.setTranslateX(650);
            newgame.setTranslateY(300);
            newgame.setTextFill(Color.BLACK);
            newgame.setPrefSize(300,80);
            newgame.setStyle("-fx-background-color: green ;-fx-font-size:30");
            Duration duration = Duration.millis(2500);
            TranslateTransition transition = new TranslateTransition(duration, newgame);
            transition.setByX(200);
            transition.play();
        });
        pausenewgame.play();
        newgame.setOnMouseClicked(event -> {
            playerInfo();
        });
        //-------------------------------------------------------------------------------------------------------------
        //button for load game
        pauseloadgame.setOnFinished(event -> {
            loadgame.setVisible(true);
            loadgame.setTranslateX(650);
            loadgame.setTranslateY(500);
            loadgame.setTextFill(Color.BLACK);
            loadgame.setPrefSize(300,80);
            loadgame.setStyle("-fx-background-color: HONEYDEW;-fx-font-size:30");
            Duration duration = Duration.millis(2500);
            TranslateTransition transition = new TranslateTransition(duration, loadgame);
            transition.setByX(300);
            transition.play();
        });
        pauseloadgame.play();
        loadgame.setOnMouseClicked(event -> {
            loadgame.setText("sala");
        });
        //-------------------------------------------------------------------------------------------------------------
        //button for exit game
        pauseexitgame.setOnFinished(event -> {
            exitgame.setVisible(true);
            exitgame.setTranslateX(650);
            exitgame.setTranslateY(700);
            exitgame.setTextFill(Color.BLACK);
            exitgame.setPrefSize(300,80);
            exitgame.setStyle("-fx-background-color: CRIMSON;-fx-font-size:30");
            Duration duration = Duration.millis(2500);
            TranslateTransition transition = new TranslateTransition(duration, exitgame);
            transition.setByX(350);
            transition.play();
        });
        pauseexitgame.play();
        exitgame.setOnMouseClicked(event -> {
            exit();
        });
        //==============================================================================================================
        Image image = new Image("https://cdn.shopify.com/s/files/1/0274/9631/products/Acquire_1000x.jpg?v=1578608845");
        ImageView imageView = new ImageView(image);
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(8500), imageView);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        imageView.setVisible(true);
        imageView.setFitWidth(1400);
        imageView.setFitHeight(1000);







        Group root=new Group(imageView,loadgame,newgame,exitgame,acquire);
        Scene scene=new Scene(root);
        scene.setFill(Color.BLACK);
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }


    public void exit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Do you want to exit?");
        Optional<ButtonType> result = alert.showAndWait();
        result.ifPresent(btnType -> {
            if (btnType.getButtonData().isDefaultButton())
                System.exit(0);
        });
    }



    public void playerInfo() {
        Stage myStage=new Stage();
        myStage.setTitle("PLAYER'S INFORMATION");
        TextField firstValue = new TextField();
        TextField secondValue = new TextField();


        GridPane rootNode = new GridPane();
        Scene myScene = new Scene(rootNode, 300, 200);
        Button aButton = new Button("Let's Play");


        rootNode.setPadding(new Insets(15));
        rootNode.setHgap(5);
        rootNode.setVgap(5);



        rootNode.add(new Label("Player1 Name:"), 0, 0);
        rootNode.add(firstValue, 1, 0);
        rootNode.add(new Label("Player2 Name:"), 0, 1);
        rootNode.add(secondValue, 1, 1);

        rootNode.add(aButton, 1, 2);
        GridPane.setHalignment(aButton, HPos.LEFT);


            aButton.setOnAction(e -> {
                makeboard();
            /*
            Integer value1 = Integer.valueOf(firstValue.getText());
            Integer value2 = Integer.valueOf(secondValue.getText());
            Integer r = value1 + value2;

             */
                //result.setText(r.toString());
            });
            myStage.setScene(myScene);
            myStage.show();
        }


    public void makeboard() {
        Stage primaryStage=new Stage();
        Button startthegame=new Button("Start the game");
        startthegame.setTranslateX(700);
        startthegame.setTranslateY(700);
        GameBoard game = new GameBoard();
        game.startGame();

        startthegame.setOnMouseClicked(event -> {
            String tile;
            tile = game.drawTile();
            startthegame.setText(tile);
            game.addPlayedTile(tile);
            System.out.println(game.getPlayedTiles());
        });

        primaryStage.setTitle("GridPane example");
        GridPane gridPane = new GridPane();
        Button[][] btn = new Button[12][12];
        ArrayList<String> tile= new Tile().wholeTiles();
        for(int j=0; j<12;j++){
            for(int i=0; i<9; i++){
                btn[i][j] = new Button();
                btn[i][j].setText(tile.remove(0));
                btn[i][j].setPrefSize(50, 50);
                gridPane.add(btn[i][j], j, i);
            }
        }

        Group root = new Group(gridPane,startthegame);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }



    }


