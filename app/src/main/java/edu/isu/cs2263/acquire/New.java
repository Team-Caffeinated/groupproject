package edu.isu.cs2263.acquire;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class New extends Application {
    GridPane gridPane = new GridPane();
    static GameBoard gameBoard = new GameBoard();
    List<String> nebulas=Arrays.asList(gameBoard.tower.getName(),gameBoard.american.getName(),gameBoard.festival.getName(),gameBoard.continental.getName(),gameBoard.sackson.getName(),gameBoard.worldwide.getName(),gameBoard.imperial.getName());
    GameBoard gb=new GameBoard();
    private final ComboBox<String> mComboBox=new ComboBox<>();
    String selectedItem;
    static VBox contentVBox = new VBox();
    private final TextField place = new TextField();
    private final Button placebutton = new Button("PLACE");
    private final TextField place1 = new TextField();
    private final Button placebutton1 = new Button("second player PLACE");
    private static final Button selectyourcorporation=new Button("Select Your Corporation");
    ArrayList<String> hand = new ArrayList<>();
    ArrayList<String> hand1 = new ArrayList<>();
    Tile whhhholetiles = new Tile();
    static Stage stage=new Stage();
    public static String color;

    @Override
    public void start(Stage primaryStage) throws Exception {
        for (String nebular : nebulas)
        {
            mComboBox.getItems().add(nebular);
        }
        mComboBox.setValue("Select Item From ComboBox");
        //======================================================================================================
        //=============================================================================================================
        // making sample hand for players
        hand.add(gameBoard.drawTile());
        hand.add(gameBoard.drawTile());
        hand.add(gameBoard.drawTile());
        hand.add(gameBoard.drawTile());
        hand.add(gameBoard.drawTile());
        gameBoard.getPlayer1().setHand(hand);

        hand1.add("2A");
        hand1.add("4A");
        hand1.add("5A");
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


        Group group = new Group(gridPane, label, listViewPlayer1, listViewPlayer2, place, placebutton, place1, placebutton1);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    private void update() {
        place.setText(place.getText().toUpperCase());
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
        place1.setText(place1.getText().toUpperCase());
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
        selectedItem = mComboBox.getSelectionModel().getSelectedItem().toString();
        for (Corporation co : gb.lisrofCorp()) {
            if (selectedItem.equals(co.getName())) {
                color = co.getColor();
                co.increaseSize(1, place.getText());
                co.increaseSize(1, place1.getText());
                System.out.println(co.getSize());
            }


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
            stage.close();});
        Group group=new Group(selectyourcorporation,mComboBox);
        Scene scene=new Scene(group);
        stage.setScene(scene);
        stage.showAndWait();

    }







    public void makeCorporationScene(){
        Label secondLabel = new Label("I'm a Label on new Window");

        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(secondLabel);
        Scene secondScene = new Scene(secondaryLayout, 230, 100);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);
        newWindow.show();
    }

    /*public void populatedata(){
        List<String> nebulas=Arrays.asList(gameBoard.tower.getName(),gameBoard.american.getName(),gameBoard.festival.getName(),gameBoard.continental.getName(),gameBoard.sackson.getName(),gameBoard.worldwide.getName(),gameBoard.imperial.getName());


        for (String nebular : nebulas)
        {
            mComboBox.getItems().add(nebular);
        }
        mComboBox.setValue("Select Item From ComboBox");

    }

     */



}
