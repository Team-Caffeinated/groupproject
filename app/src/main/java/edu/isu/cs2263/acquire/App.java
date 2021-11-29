package edu.isu.cs2263.acquire;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class App extends Application {
    GridPane gridPane = new GridPane();
    static GameBoard gameBoard = new GameBoard();
    List<String> nebulas = Arrays.asList(gameBoard.tower.getName(), gameBoard.american.getName(), gameBoard.festival.getName(), gameBoard.continental.getName(), gameBoard.sackson.getName(), gameBoard.worldwide.getName(), gameBoard.imperial.getName());
    GameBoard gb = new GameBoard();
    private final ComboBox<String> mComboBox = new ComboBox<>();
    String selectedItem;
    static VBox contentVBox = new VBox();
    private final TextField place = new TextField();
    private final Button placebutton = new Button("PLACE");
    private final TextField place1 = new TextField();
    private final Button placebutton1 = new Button("second player PLACE");
    private static final Button selectyourcorporation = new Button("Select Your Corporation");
    ArrayList<String> hand = new ArrayList<>();
    ArrayList<String> hand1 = new ArrayList<>();
    Tile whhhholetiles = new Tile();
    static Stage stage = new Stage();
    public static String color;

    //--------------------------------------------------------------------------------------------------------------
    //stages
    Stage playerinfostage = new Stage();
    Stage boardstage = new Stage();
    Stage startpagestage = new Stage();


    @Override
    public void start(Stage primaryStage) throws Exception{
        PauseTransition pauseacquire = new PauseTransition(Duration.seconds(2.4));
        PauseTransition pausenewgame = new PauseTransition(Duration.seconds(5));
        PauseTransition pauseloadgame = new PauseTransition(Duration.seconds(6));
        PauseTransition pauseexitgame = new PauseTransition(Duration.seconds(7));

        //--------------------------------------------------------------------------------------------------------------
        startpagestage.setTitle("ACQUIRE GAME");
        Label acquire = new Label("WELCOME TO ACQUIRE");
        Button newgame = new Button("NEW GAME");
        Button loadgame = new Button("LOAD GAME");
        Button exitgame = new Button("EXIT GAME ");
        loadgame.setVisible(false);
        newgame.setVisible(false);
        exitgame.setVisible(false);
        //---------------------------------------------------------------------------------------------------------------
        //welcome title
        acquire.setTranslateX(50);
        acquire.setTranslateY(400);
        acquire.setTextFill(Color.BEIGE);
        acquire.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 100));
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
            newgame.setPrefSize(300, 80);
            newgame.setStyle("-fx-background-color: green ;-fx-font-size:30");
            Duration duration = Duration.millis(2500);
            TranslateTransition transition = new TranslateTransition(duration, newgame);
            transition.setByX(200);
            transition.play();
        });
        pausenewgame.play();
        newgame.setOnMouseClicked(event -> {
            playerInfo();
            //startpagestage.hide();
        });
        //-------------------------------------------------------------------------------------------------------------
        //button for load game
        pauseloadgame.setOnFinished(event -> {
            loadgame.setVisible(true);
            loadgame.setTranslateX(650);
            loadgame.setTranslateY(500);
            loadgame.setTextFill(Color.BLACK);
            loadgame.setPrefSize(300, 80);
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
            exitgame.setPrefSize(300, 80);
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


        Group root = new Group(imageView, loadgame, newgame, exitgame, acquire);
        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);
        startpagestage.setFullScreen(true);
        startpagestage.setScene(scene);
        startpagestage.show();

    }
    public void playerInfo() {
        Stage myStage=new Stage();
        myStage.setTitle("PLAYER'S INFORMATION");
        TextField firstValue = new TextField();
        TextField secondValue = new TextField();


        GridPane rootNode = new GridPane();
        Scene myScene = new Scene(rootNode, 500, 500);
        Button play = new Button("Let's Play");
        //Button back=new Button("Back to main page");
        Group buttons = new Group(play);


        rootNode.setPadding(new Insets(15));
        rootNode.setHgap(5);
        rootNode.setVgap(5);


        rootNode.add(new Label("Player1 Name:"), 0, 0);
        rootNode.add(firstValue, 1, 0);
        rootNode.add(new Label("Player2 Name:"), 0, 1);
        rootNode.add(secondValue, 1, 1);

        rootNode.add(buttons, 1, 2);
        GridPane.setHalignment(play, HPos.LEFT);


        play.setOnAction(e -> {
            makeboard(new Stage());
            myStage.close();


        });


        myStage.setScene(myScene);
        myStage.show();
    }
    /*public void makeboard(Stage primaryStage) {
        Button startthegame = new Button("Start the game");
        Button backtomain = new Button("Back to main");

        startthegame.setTranslateX(700);
        startthegame.setTranslateY(700);
        backtomain.setTranslateX(700);
        backtomain.setTranslateY(750);
        GameBoard game = new GameBoard();
        game.startGame();

        startthegame.setOnMouseClicked(event -> {
            String tile;
            tile = game.drawTile();
            startthegame.setText(tile);
            game.addPlayedTile(tile);
            System.out.println(game.getPlayedTiles());
        });

        backtomain.setOnMouseClicked(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("Do you want to save and back to main?");
            Optional<ButtonType> result = alert.showAndWait();
            result.ifPresent(btnType -> {
                if (btnType.getButtonData().isDefaultButton())
                    primaryStage.hide();
                    startpagestage.show();

            });

        });

        primaryStage.setTitle("GridPane example");
        GridPane gridPane = new GridPane();
        Button[][] btn = new Button[12][12];
        ArrayList<String> tile = new Tile().wholeTiles();
        for (int j = 0; j < 12; j++) {
            for (int i = 0; i < 9; i++) {
                btn[i][j] = new Button();
                btn[i][j].setText(tile.remove(0));
                btn[i][j].setPrefSize(70, 70);
                gridPane.add(btn[i][j], j, i);


            }
        }


        Group root = new Group(gridPane, startthegame, backtomain);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

     */


    public static void main(String[] args) {
        launch(args);
    }
    public void makeboard(Stage primaryStage){
        Button backtomain = new Button("Back to main");
        backtomain.setTranslateX(700);
        backtomain.setTranslateY(750);
        backtomain.setOnMouseClicked(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("Do you want to save and back to main?");
            Optional<ButtonType> result = alert.showAndWait();
            result.ifPresent(btnType -> {
                if (btnType.getButtonData().isDefaultButton())
                primaryStage.close();
                startpagestage.show();

            });

        });

        for (String nebular : nebulas)
        {
            mComboBox.getItems().add(nebular);
        }
        mComboBox.setValue("Select Item From ComboBox");
        //======================================================================================================
        //=============================================================================================================
        // making sample hand for players
        hand.add("1A");
        hand.add("3A");
        hand.add("4C");
        hand.add("5D");
        hand.add("4E");
        gameBoard.getPlayer1().setHand(hand);

        hand1.add("2A");
        hand1.add("1B");
        hand1.add("12I");
        hand1.add("4D");
        hand1.add("3D");

        gameBoard.getPlayer2().setHand(hand1);
        //===============================================================================================================
        //=============================================================================================================
        // making board with buttons
        primaryStage.setTitle("Board View");
        Button button;
        ArrayList<String> tileList = new ArrayList<>(new Tile().wholeTiles());
        String tilename;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 9; j++) {
                tilename = tileList.remove(0);
                button = new Button(tilename);
                button.setPrefSize(65, 65);
                gridPane.add(button, i, j);
            }
        }
        ArrayList<String> tileList1 = new ArrayList<>(new Tile().wholeTiles());
        for (int s = 0; s < 108; s++) {
            gridPane.getChildren().get(s).setAccessibleText(tileList1.remove(0));
        }
        //=============================================================================================================
        //=============================================================================================================
        //making player info label
        Label label = new Label("Player's Info");
        label.setFont(Font.font(50));
        label.setTranslateX(950);
        label.setTranslateY(20);
        //=============================================================================================================
        //=============================================================================================================
        //making text field and place button for player
        place.setLayoutX(600);
        place.setLayoutY(700);
        placebutton.setLayoutX(550);
        placebutton.setLayoutY(700);


        place1.setLayoutX(600);
        place1.setLayoutY(700);
        placebutton1.setLayoutX(430);
        placebutton1.setLayoutY(700);
        place1.setVisible(false);
        placebutton1.setVisible(false);


        selectyourcorporation.setLayoutY(500);
        selectyourcorporation.setLayoutX(500);
        contentVBox.setLayoutX(300);
        contentVBox.setLayoutY(300);

        //=============================================================================================================
        //=============================================================================================================
        //ObservableList<String> names = FXCollections.observableArrayList( "Name :"+gameBoard.getPlayer1().getName(),"Cash : $"+gameBoard.getPlayer1().getMoney(),"Stocks :"+gameBoard.getPlayer1().getHand());
        //ObservableList<String> names1 = FXCollections.observableArrayList( "Name :"+gameBoard.getPlayer2().getName(),"Cash : $"+gameBoard.getPlayer2().getMoney(),"Stocks :"+gameBoard.getPlayer2().getHand());


        ObservableList<String> names = FXCollections.observableArrayList(gameBoard.getPlayer1().getHand());
        ObservableList<String> names1 = FXCollections.observableArrayList(gameBoard.getPlayer2().getHand());


        ListView<String> listViewPlayer1 = new ListView<String>(names);
        ListView<String> listViewPlayer2 = new ListView<String>(names1);
        placebutton.setOnAction(event -> {
            update();
            place.setVisible(false);
            placebutton.setVisible(false);
            place.clear();
            place1.setVisible(true);
            placebutton1.setVisible(true);

        });

        placebutton1.setOnAction(event -> {
            update();
            place1.setVisible(false);
            placebutton1.setVisible(false);
            place1.clear();
            place.setVisible(true);
            placebutton.setVisible(true);

        });
        //=============================================================================================================
        //=============================================================================================================
        listViewPlayer1.setMaxSize(500, 200);
        listViewPlayer1.setTranslateX(950);
        listViewPlayer1.setTranslateY(100);

        listViewPlayer2.setMaxSize(300, 200);
        listViewPlayer2.setTranslateX(950);
        listViewPlayer2.setTranslateY(500);
        //=============================================================================================================


        Group group = new Group(gridPane, label, listViewPlayer1, listViewPlayer2, place, placebutton, place1, placebutton1,backtomain);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }
    private void update() {
        for (String value : gameBoard.getPlayer1().getHand()) {
            if (value.equals(place.getText())) {
                for (int s = 0; s < 108; s++) {
                    if (gridPane.getChildren().get(s).getAccessibleText().equals(place.getText())) {
                        gameBoard.listofwholetilesthatplayed.add(place.getText());
                        if (gameBoard.check(gameBoard.listofwholetilesthatplayed, place.getText())) {
                            if (s + 9 <= 107) {
                                if (gridPane.getChildren().get(s + 9).getStyle().equals("-fx-background-color: gray")) {
                                    demo();
                                    if (gameBoard.left(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.right(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval1)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                    if (gameBoard.up(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval2)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.down(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval3)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                }
                                if (!gridPane.getChildren().get(s + 9).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(s + 9).getStyle().equals("")) {
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(s + 9).getStyle());
                                }
                            }
                            if (s - 9 >= 0) {
                                if (gridPane.getChildren().get(s - 9).getStyle().equals("-fx-background-color: gray")) {
                                    demo();
                                    if (gameBoard.left(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.right(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval1)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                    if (gameBoard.up(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval2)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.down(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval3)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                }
                                if (!gridPane.getChildren().get(s - 9).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(s - 9).getStyle().equals("")) {
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(s - 9).getStyle());
                                }
                            }
                            if (s + 1 <= 107) {
                                if (gridPane.getChildren().get(s + 1).getStyle().equals("-fx-background-color: gray")) {
                                    demo();
                                    if (gameBoard.left(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.right(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval1)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                    if (gameBoard.up(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval2)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.down(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval3)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                }
                                if (!gridPane.getChildren().get(s + 1).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(s + 1).getStyle().equals("")) {
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(s + 1).getStyle());
                                }
                            }
                            if (s - 1 >= 0) {
                                if (gridPane.getChildren().get(s - 1).getStyle().equals("-fx-background-color: gray")) {
                                    demo();
                                    if (gameBoard.left(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.right(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval1)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                    if (gameBoard.up(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval2)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.down(gameBoard.listofwholetilesthatplayed, place.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval3)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                }
                                if (!gridPane.getChildren().get(s - 1).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(s - 1).getStyle().equals("")) {
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(s - 1).getStyle());
                                }
                            }
                        }
                        else {gridPane.getChildren().get(s).setStyle("-fx-background-color: gray");}

                    }
                }
            }
        }


        for (String value1 : gameBoard.getPlayer2().getHand()) {
            if (value1.equals(place1.getText())) {
                for (int s = 0; s < 108; s++) {
                    if (gridPane.getChildren().get(s).getAccessibleText().equals(place1.getText())) {

                        gameBoard.listofwholetilesthatplayed.add(place1.getText());
                        if (gameBoard.check(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                            if (s + 9 <= 107) {
                                if (gridPane.getChildren().get(s + 9).getStyle().equals("-fx-background-color: gray")) {
                                    demo();
                                    if (gameBoard.left(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.right(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval1)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                    if (gameBoard.up(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval2)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.down(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval3)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                }
                                if (!gridPane.getChildren().get(s + 9).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(s + 9).getStyle().equals("")) {
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(s + 9).getStyle());
                                }

                            }
                            if (s - 9 >= 0) {
                                if (gridPane.getChildren().get(s - 9).getStyle().equals("-fx-background-color: gray")) {
                                    demo();
                                    if (gameBoard.left(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.right(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval1)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                    if (gameBoard.up(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval2)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.down(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval3)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                }
                                if (!gridPane.getChildren().get(s - 9).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(s - 9).getStyle().equals("")) {
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(s - 9).getStyle());
                                }
                            }
                            if (s + 1 <= 107) {
                                if (gridPane.getChildren().get(s + 1).getStyle().equals("-fx-background-color: gray")) {
                                    demo();
                                    if (gameBoard.left(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.right(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval1)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                    if (gameBoard.up(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval2)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.down(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval3)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                }
                                if (!gridPane.getChildren().get(s + 1).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(s + 1).getStyle().equals("")) {
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(s + 1).getStyle());
                                }
                            }
                            if (s - 1 >= 0) {
                                if (gridPane.getChildren().get(s - 1).getStyle().equals("-fx-background-color: gray")) {
                                    demo();
                                    if (gameBoard.left(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.right(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval1)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                    if (gameBoard.up(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval2)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);
                                    }
                                    if (gameBoard.down(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                                        gridPane.getChildren().get(whhhholetiles.wholeTiles().indexOf(gameBoard.helpval3)).setStyle("-fx-background-color: " + color);
                                        gridPane.getChildren().get(s).setStyle("-fx-background-color: " + color);

                                    }
                                }
                                if (!gridPane.getChildren().get(s - 1).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(s -1).getStyle().equals("")) {
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(s - 1).getStyle());
                                }
                            }


                        }
                        else{gridPane.getChildren().get(s).setStyle("-fx-background-color: gray");}

                    }
                }
            }
        }
    }
    public void search() {
        selectedItem = mComboBox.getSelectionModel().getSelectedItem();
        for (Corporation co : gb.lisrofCorp()) {
            if (selectedItem.equals(co.getName())) {
                color = co.getColor();}


        }

    }
    private void handleSelection(){
        mComboBox.getItems().remove(selectedItem);
        mComboBox.setOnAction(event -> {
            search();
        });

    }
    public void demo(){
        selectyourcorporation.setLayoutX(100);
        selectyourcorporation.setLayoutY(100);
        handleSelection();
        selectyourcorporation.setOnAction(event -> {
            mComboBox.getItems().remove(selectedItem);
            stage.close();});
        Group group=new Group(selectyourcorporation,mComboBox);
        Scene scene=new Scene(group);
        stage.setScene(scene);
        stage.showAndWait();

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


}




