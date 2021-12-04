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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class testingboard extends Application {

    ArrayList<Integer> forchangingtilescolor=new ArrayList<>();


    Tile ttt=new Tile();
    ArrayList<Integer> integerArrayList=new ArrayList<>();
    Integer size=0;
    Integer sizetower=0;
    Integer sizeamerican=0;
    Integer sizefestival=0;
    Integer sizecontinental=0;
    Integer sizesackson=0;
    Integer sizeworldwide=0;
    Integer sizeimperial=0;


    ArrayList<Integer> towerintegertiles =new ArrayList<>();
    ArrayList<Integer> americanintegertiles =new ArrayList<>();
    ArrayList<Integer> festivalintegertiles =new ArrayList<>();
    ArrayList<Integer> continentalintegertiles =new ArrayList<>();
    ArrayList<Integer> sacksonintegertiles =new ArrayList<>();
    ArrayList<Integer> worldwideintegertiles =new ArrayList<>();
    ArrayList<Integer> imperialintegertiles =new ArrayList<>();



    GridPane gridPane = new GridPane();
    static GameBoard gameBoard = new GameBoard();
    //List<String> nebulas=Arrays.asList(gameBoard.tower.getName(),gameBoard.american.getName(),gameBoard.festival.getName(),gameBoard.continental.getName(),gameBoard.sackson.getName(),gameBoard.worldwide.getName(),gameBoard.imperial.getName());
    List<Corporation> nebulas=Arrays.asList(gameBoard.tower,gameBoard.american,gameBoard.festival,gameBoard.continental,gameBoard.sackson,gameBoard.worldwide,gameBoard.imperial);


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
        for (Corporation nebular : nebulas)
        {
            mComboBox.getItems().add(nebular.getName());
        }
        mComboBox.setValue("Select Item From ComboBox");
        //======================================================================================================
        //=============================================================================================================
        // making sample hand for players
/*

        hand.add(gameBoard.drawTile());
        hand.add(gameBoard.drawTile());
        hand.add(gameBoard.drawTile());
        hand.add(gameBoard.drawTile());
        hand.add(gameBoard.drawTile());
        hand.add(gameBoard.drawTile());


 */

        hand.add("1A");
        hand.add("2A");
        hand.add("2B");
        hand.add("3B");










        gameBoard.getPlayer1().setHand(hand);


/*
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());

 */


        hand1.add("3A");
        hand1.add("4A");
        hand1.add("5A");
        hand1.add("1B");



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
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-border-color: white;-fx-background-color: black");
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
        listViewPlayer2.setVisible(false);
        placebutton.setOnAction(event -> {

            update();
            updateplayerhand(names,gameBoard.getPlayer1().getHand(),place.getText());
            listViewPlayer1.setVisible(false);
            place.setVisible(false);
            placebutton.setVisible(false);
            place.clear();
            place1.setVisible(true);
            placebutton1.setVisible(true);
            listViewPlayer2.setVisible(true);

        });

        placebutton1.setOnAction(event -> {
            update();
            updateplayerhand(names1,gameBoard.getPlayer2().getHand(),place1.getText());
            listViewPlayer2.setVisible(false);
            place1.setVisible(false);
            placebutton1.setVisible(false);
            place1.clear();
            place.setVisible(true);
            placebutton.setVisible(true);
            listViewPlayer1.setVisible(true);

        });
        //=============================================================================================================
        //=============================================================================================================
        listViewPlayer1.setMaxSize(50, 200);
        listViewPlayer1.setTranslateX(950);
        listViewPlayer1.setTranslateY(100);

        listViewPlayer2.setMaxSize(50, 200);
        listViewPlayer2.setTranslateX(950);
        listViewPlayer2.setTranslateY(100);
        //=============================================================================================================


        Group group = new Group(gridPane, label, listViewPlayer1, listViewPlayer2, place, placebutton, place1, placebutton1);
        Scene scene = new Scene(group);
        scene.setFill(Color.DIMGRAY);
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
                    if (gridPane.getChildren().get(s).getAccessibleText().equals(place.getText())){
                        gameBoard.listofwholetilesthatplayed.add(place.getText());
                        gameBoard.integeroflistofwholetilesthatplayed.add(s);
                        if (gameBoard.check(gameBoard.listofwholetilesthatplayed, place.getText())) {
                            integerArrayList=new ArrayList<>();
                            changecolor(place.getText());
                            setneighbor(integerArrayList);
                            List<Integer> newList = integerArrayList.stream()
                                    .distinct()
                                    .collect(Collectors.toList());
                            if(newList.size()==1){
                                if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color: gray")){
                                    demo();
                                    gridPane.getChildren().get(s).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(newList.get(0)).setStyle("-fx-background-color:"+color);
                                    if(color.equals("red")){towerintegertiles.add(s);towerintegertiles.add(newList.get(0));}
                                    if(color.equals("yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(newList.get(0));}
                                    if(color.equals("teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(newList.get(0));}
                                    if(color.equals("orange")){imperialintegertiles.add(s);imperialintegertiles.add(newList.get(0));}
                                    if(color.equals("green")){americanintegertiles.add(s);americanintegertiles.add(newList.get(0));}
                                    if(color.equals("purple")){continentalintegertiles.add(s);continentalintegertiles.add(newList.get(0));}
                                    if(color.equals("blue")){festivalintegertiles.add(s);festivalintegertiles.add(newList.get(0));}}
                                else {
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(newList.get(0)).getStyle());
                                    if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);;}
                                    if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);}
                                    if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);}
                                    if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);}
                                    if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);}
                                    if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);}
                                    if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);}

                                    ;}



                            }
                            if(newList.size()==2){
                                setneighbor(newList);
                                if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){
                                    demo();
                                    gridPane.getChildren().get(s).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color:"+color);
                                    if(color.equals("red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);}
                                    if(color.equals("yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);}
                                    if(color.equals("teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);}
                                    if(color.equals("orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);}
                                    if(color.equals("green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);}
                                    if(color.equals("purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);}
                                    if(color.equals("blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);}
                                }
                                else if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);}


                                }
                                else if(!gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor2);}

                                }
                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");towerintegertiles.add(s);}
                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);}
                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);}
                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);}
                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);}
                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);}
                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");americanintegertiles.add(s);}

                            }
                            if(newList.size()==3){
                                setneighbor(newList);
                                //======================================================================================
                                //three of them are gray
                                if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") &&gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){
                                    demo();
                                    gridPane.getChildren().get(s).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color:"+color);
                                    if(color.equals("red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor3);}
                                    if(color.equals("yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor3);}
                                    if(color.equals("teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor3);}
                                    if(color.equals("orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor3);}
                                    if(color.equals("green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor3);}
                                    if(color.equals("purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor3);}
                                    if(color.equals("blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor3);}

                                }
                                //======================================================================================
                                //two of them are gray
                                else if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);}

                                }
                                else if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") &&gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor3);}


                                }
                                else if(!gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") &&gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor3);towerintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor3);sacksonintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor3);worldwideintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor3);imperialintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor3);americanintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor3);continentalintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor3);festivalintegertiles.add(ttt.neghbor2);}

                                }

                                //======================================================================================
                                //none of them is gray
                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor3);}
                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor2);}
                                else if(towerintegertiles.contains(ttt.neghbor2) && towerintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);}

                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor3);}
                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor2);}
                                else if(sacksonintegertiles.contains(ttt.neghbor2) && sacksonintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);}

                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor3);}
                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor2);}
                                else if(worldwideintegertiles.contains(ttt.neghbor2) && worldwideintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);}

                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor3);}
                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor2);}
                                else if(festivalintegertiles.contains(ttt.neghbor2) && festivalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);}

                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor3);}
                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor2);}
                                else if(continentalintegertiles.contains(ttt.neghbor2) && continentalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);}

                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor3);}
                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor2);}
                                else if(americanintegertiles.contains(ttt.neghbor2) && americanintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);}


                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor3);}
                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor2);}
                                else if(imperialintegertiles.contains(ttt.neghbor2) && imperialintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);}

                            }
                            if(newList.size()==4){
                                setneighbor(newList);
                                if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") &&gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&&gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){
                                    demo();
                                    gridPane.getChildren().get(s).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color:"+color);
                                    if(color.equals("red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor3);towerintegertiles.add(ttt.neghbor4);}
                                    if(color.equals("yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor3);sacksonintegertiles.add(ttt.neghbor4);}
                                    if(color.equals("teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor3);worldwideintegertiles.add(ttt.neghbor4);}
                                    if(color.equals("orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor3);imperialintegertiles.add(ttt.neghbor4);}
                                    if(color.equals("green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor3);americanintegertiles.add(ttt.neghbor4);}
                                    if(color.equals("purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor3);continentalintegertiles.add(ttt.neghbor4);}
                                    if(color.equals("blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor3);festivalintegertiles.add(ttt.neghbor4);}

                                }
                                else if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&&!gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor3);}

                                }
                                else if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&&gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor4).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor4);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor4);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor4);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor4);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor4);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor4);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor4);}


                                }
                                else if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&&gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor4).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor4);towerintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor4);sacksonintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor4);worldwideintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor4);imperialintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor4);americanintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor4);continentalintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor4);festivalintegertiles.add(ttt.neghbor3);}

                                }
                                else if(!gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&&gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor4).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor4);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor4);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor4);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor4);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor4);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor4);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor4);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor3);}

                                }

                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor3);towerintegertiles.add(ttt.neghbor4);}
                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor4);}
                                else if(towerintegertiles.contains(ttt.neghbor2) && towerintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor4);}
                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor4) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor3);towerintegertiles.add(ttt.neghbor2);}
                                else if(towerintegertiles.contains(ttt.neghbor2) && towerintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor3);}
                                else if(towerintegertiles.contains(ttt.neghbor3) && towerintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);}

                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor3);sacksonintegertiles.add(ttt.neghbor4);}
                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor4);}
                                else if(sacksonintegertiles.contains(ttt.neghbor2) && sacksonintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor4);}
                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor4) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor3);sacksonintegertiles.add(ttt.neghbor2);}
                                else if(sacksonintegertiles.contains(ttt.neghbor2) && sacksonintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor3);}
                                else if(sacksonintegertiles.contains(ttt.neghbor3) && sacksonintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);}

                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor3);worldwideintegertiles.add(ttt.neghbor4);}
                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor4);}
                                else if(worldwideintegertiles.contains(ttt.neghbor2) && worldwideintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor4);}
                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor4) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor3);worldwideintegertiles.add(ttt.neghbor2);}
                                else if(worldwideintegertiles.contains(ttt.neghbor2) && worldwideintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor3);}
                                else if(worldwideintegertiles.contains(ttt.neghbor3) && worldwideintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);}

                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor3);festivalintegertiles.add(ttt.neghbor4);}
                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor4);}
                                else if(festivalintegertiles.contains(ttt.neghbor2) && festivalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor4);}
                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor4) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor3);festivalintegertiles.add(ttt.neghbor2);}
                                else if(festivalintegertiles.contains(ttt.neghbor2) && festivalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor3);}
                                else if(festivalintegertiles.contains(ttt.neghbor3) && festivalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);}

                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor3);americanintegertiles.add(ttt.neghbor4);}
                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor4);}
                                else if(americanintegertiles.contains(ttt.neghbor2) && americanintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor4);}
                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor4) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor3);americanintegertiles.add(ttt.neghbor2);}
                                else if(americanintegertiles.contains(ttt.neghbor2) && americanintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor3);}
                                else if(americanintegertiles.contains(ttt.neghbor3) && americanintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);}

                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor3);imperialintegertiles.add(ttt.neghbor4);}
                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor4);}
                                else if(imperialintegertiles.contains(ttt.neghbor2) && imperialintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor4);}
                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor4) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor3);imperialintegertiles.add(ttt.neghbor2);}
                                else if(imperialintegertiles.contains(ttt.neghbor2) && imperialintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor3);}
                                else if(imperialintegertiles.contains(ttt.neghbor3) && imperialintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);}

                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor3);continentalintegertiles.add(ttt.neghbor4);}
                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor4);}
                                else if(continentalintegertiles.contains(ttt.neghbor2) && continentalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor4);}
                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor4) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor3);continentalintegertiles.add(ttt.neghbor2);}
                                else if(continentalintegertiles.contains(ttt.neghbor2) && continentalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor3);}
                                else if(continentalintegertiles.contains(ttt.neghbor3) && continentalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);}

                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor2) && towerintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: red");towerintegertiles.add(ttt.neghbor4);}
                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor2) && towerintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: red");towerintegertiles.add(ttt.neghbor4);}
                                else if(towerintegertiles.contains(ttt.neghbor2) && towerintegertiles.contains(ttt.neghbor3) && towerintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: red");towerintegertiles.add(ttt.neghbor1);}
                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor3) && towerintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: red");towerintegertiles.add(ttt.neghbor2);}

                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor2) && sacksonintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(ttt.neghbor4);}
                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor2) && sacksonintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(ttt.neghbor4);}
                                else if(sacksonintegertiles.contains(ttt.neghbor2) && sacksonintegertiles.contains(ttt.neghbor3) && sacksonintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(ttt.neghbor1);}
                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor3) && sacksonintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(ttt.neghbor2);}

                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor2) && imperialintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: orange");imperialintegertiles.add(ttt.neghbor4);}
                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor2) && imperialintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: orange");imperialintegertiles.add(ttt.neghbor4);}
                                else if(imperialintegertiles.contains(ttt.neghbor2) && imperialintegertiles.contains(ttt.neghbor3) && imperialintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: orange");imperialintegertiles.add(ttt.neghbor1);}
                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor3) && imperialintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: orange");imperialintegertiles.add(ttt.neghbor2);}

                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor2) && continentalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: purple");continentalintegertiles.add(ttt.neghbor4);}
                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor2) && continentalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: purple");continentalintegertiles.add(ttt.neghbor4);}
                                else if(continentalintegertiles.contains(ttt.neghbor2) && continentalintegertiles.contains(ttt.neghbor3) && continentalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: purple");continentalintegertiles.add(ttt.neghbor1);}
                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor3) && continentalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: purple");continentalintegertiles.add(ttt.neghbor2);}

                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor2) && festivalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: blue");festivalintegertiles.add(ttt.neghbor4);}
                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor2) && festivalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: blue");festivalintegertiles.add(ttt.neghbor4);}
                                else if(festivalintegertiles.contains(ttt.neghbor2) && festivalintegertiles.contains(ttt.neghbor3) && festivalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: blue");festivalintegertiles.add(ttt.neghbor1);}
                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor3) && festivalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: blue");festivalintegertiles.add(ttt.neghbor2);}

                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor2) && americanintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: green");americanintegertiles.add(ttt.neghbor4);}
                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor2) && americanintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: green");americanintegertiles.add(ttt.neghbor4);}
                                else if(americanintegertiles.contains(ttt.neghbor2) && americanintegertiles.contains(ttt.neghbor3) && americanintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: green");americanintegertiles.add(ttt.neghbor1);}
                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor3) && americanintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: green");americanintegertiles.add(ttt.neghbor2);}

                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor2) && worldwideintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: teal");worldwideintegertiles.add(ttt.neghbor4);}
                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor2) && worldwideintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: teal");worldwideintegertiles.add(ttt.neghbor4);}
                                else if(worldwideintegertiles.contains(ttt.neghbor2) && worldwideintegertiles.contains(ttt.neghbor3) && worldwideintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: teal");worldwideintegertiles.add(ttt.neghbor1);}
                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor3) && worldwideintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: teal");worldwideintegertiles.add(ttt.neghbor2);}


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
                        gameBoard.integeroflistofwholetilesthatplayed.add(s);
                        if (gameBoard.check(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                            integerArrayList=new ArrayList<>();
                            changecolor(place1.getText());
                            setneighbor(integerArrayList);
                            List<Integer> newList = integerArrayList.stream()
                                    .distinct()
                                    .collect(Collectors.toList());
                            if(newList.size()==1){
                                System.out.println(gridPane.getChildren().get(newList.get(0)).getStyle());
                                if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color: gray")){
                                demo();
                                gridPane.getChildren().get(s).setStyle("-fx-background-color:"+color);
                                gridPane.getChildren().get(newList.get(0)).setStyle("-fx-background-color:"+color);
                                if(color.equals("red")){towerintegertiles.add(s);towerintegertiles.add(newList.get(0));}
                                if(color.equals("yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(newList.get(0));}
                                if(color.equals("teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(newList.get(0));}
                                if(color.equals("orange")){imperialintegertiles.add(s);imperialintegertiles.add(newList.get(0));}
                                if(color.equals("green")){americanintegertiles.add(s);americanintegertiles.add(newList.get(0));}
                                if(color.equals("purple")){continentalintegertiles.add(s);continentalintegertiles.add(newList.get(0));}
                                if(color.equals("blue")){festivalintegertiles.add(s);festivalintegertiles.add(newList.get(0));}}
                                else {
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(newList.get(0)).getStyle());
                                    if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);;}
                                    if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);}
                                    if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);}
                                    if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);}
                                    if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);}
                                    if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);}
                                    if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);}

                                ;}

                            }
                            if(newList.size()==2){
                                setneighbor(newList);
                                if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){
                                    demo();
                                    gridPane.getChildren().get(s).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color:"+color);
                                    if(color.equals("red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);}
                                    if(color.equals("yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);}
                                    if(color.equals("teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);}
                                    if(color.equals("orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);}
                                    if(color.equals("green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);}
                                    if(color.equals("purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);}
                                    if(color.equals("blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);}
                                }
                                else if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);}


                                }
                                else if(!gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor2);}

                                }
                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");towerintegertiles.add(s);}
                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);}
                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);}
                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);}
                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);}
                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);}
                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");americanintegertiles.add(s);}

                            }
                            if(newList.size()==3){
                                setneighbor(newList);
                                //======================================================================================
                                //three of them are gray
                                if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") &&gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){
                                    demo();
                                    gridPane.getChildren().get(s).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color:"+color);
                                    if(color.equals("red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor3);}
                                    if(color.equals("yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor3);}
                                    if(color.equals("teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor3);}
                                    if(color.equals("orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor3);}
                                    if(color.equals("green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor3);}
                                    if(color.equals("purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor3);}
                                    if(color.equals("blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor3);}

                                }
                                //======================================================================================
                                //two of them are gray
                                else if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);}

                                }
                                else if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") &&gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor3);}


                                }
                                else if(!gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") &&gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor3);towerintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor3);sacksonintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor3);worldwideintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor3);imperialintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor3);americanintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor3);continentalintegertiles.add(ttt.neghbor2);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor3);festivalintegertiles.add(ttt.neghbor2);}

                                }

                                //======================================================================================
                                //none of them is gray
                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor3);}
                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor2);}
                                else if(towerintegertiles.contains(ttt.neghbor2) && towerintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);}

                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor3);}
                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor2);}
                                else if(sacksonintegertiles.contains(ttt.neghbor2) && sacksonintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);}

                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor3);}
                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor2);}
                                else if(worldwideintegertiles.contains(ttt.neghbor2) && worldwideintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);}

                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor3);}
                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor2);}
                                else if(festivalintegertiles.contains(ttt.neghbor2) && festivalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);}

                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor3);}
                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor2);}
                                else if(continentalintegertiles.contains(ttt.neghbor2) && continentalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);}

                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor3);}
                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor2);}
                                else if(americanintegertiles.contains(ttt.neghbor2) && americanintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);}


                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor3);}
                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor2);}
                                else if(imperialintegertiles.contains(ttt.neghbor2) && imperialintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);}


                                /*
                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);}
                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);}
                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);}
                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);}
                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);}
                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor2)){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");americanintegertiles.add(s);}


                                 */

                            }
                            if(newList.size()==4){
                                setneighbor(newList);
                                if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") &&gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&&gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){
                                    demo();
                                    gridPane.getChildren().get(s).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color:"+color);
                                    if(color.equals("red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor3);towerintegertiles.add(ttt.neghbor4);}
                                    if(color.equals("yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor3);sacksonintegertiles.add(ttt.neghbor4);}
                                    if(color.equals("teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor3);worldwideintegertiles.add(ttt.neghbor4);}
                                    if(color.equals("orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor3);imperialintegertiles.add(ttt.neghbor4);}
                                    if(color.equals("green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor3);americanintegertiles.add(ttt.neghbor4);}
                                    if(color.equals("purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor3);continentalintegertiles.add(ttt.neghbor4);}
                                    if(color.equals("blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor3);festivalintegertiles.add(ttt.neghbor4);}

                                }
                                else if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&&!gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor3);}

                                }
                                else if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&&gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor4).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor4);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor4);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor4);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor4);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor4);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor4);}
                                    if(gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor4);}


                                }
                                else if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&&gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor1).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor4).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor4);towerintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor4);sacksonintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor4);worldwideintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor4);imperialintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor4);americanintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor4);continentalintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor4);festivalintegertiles.add(ttt.neghbor3);}

                                }
                                else if(!gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&&gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor4).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor4);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:yellow")){sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor4);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:teal")){worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor4);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:orange")){imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor4);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:green")){americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor4);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:purple")){continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor4);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor3);}
                                    if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color:blue")){festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor4);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor3);}

                                }

                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor3);towerintegertiles.add(ttt.neghbor4);}
                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor4);}
                                else if(towerintegertiles.contains(ttt.neghbor2) && towerintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor4);}
                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor4) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor3);towerintegertiles.add(ttt.neghbor2);}
                                else if(towerintegertiles.contains(ttt.neghbor2) && towerintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor3);}
                                else if(towerintegertiles.contains(ttt.neghbor3) && towerintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: red");towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);}

                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor3);sacksonintegertiles.add(ttt.neghbor4);}
                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor4);}
                                else if(sacksonintegertiles.contains(ttt.neghbor2) && sacksonintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor4);}
                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor4) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor3);sacksonintegertiles.add(ttt.neghbor2);}
                                else if(sacksonintegertiles.contains(ttt.neghbor2) && sacksonintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor3);}
                                else if(sacksonintegertiles.contains(ttt.neghbor3) && sacksonintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);}

                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor3);worldwideintegertiles.add(ttt.neghbor4);}
                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor4);}
                                else if(worldwideintegertiles.contains(ttt.neghbor2) && worldwideintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor4);}
                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor4) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor3);worldwideintegertiles.add(ttt.neghbor2);}
                                else if(worldwideintegertiles.contains(ttt.neghbor2) && worldwideintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor3);}
                                else if(worldwideintegertiles.contains(ttt.neghbor3) && worldwideintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: teal");worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);}

                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor3);festivalintegertiles.add(ttt.neghbor4);}
                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor4);}
                                else if(festivalintegertiles.contains(ttt.neghbor2) && festivalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor4);}
                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor4) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor3);festivalintegertiles.add(ttt.neghbor2);}
                                else if(festivalintegertiles.contains(ttt.neghbor2) && festivalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor3);}
                                else if(festivalintegertiles.contains(ttt.neghbor3) && festivalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: blue");festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);}

                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor3);americanintegertiles.add(ttt.neghbor4);}
                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor4);}
                                else if(americanintegertiles.contains(ttt.neghbor2) && americanintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor4);}
                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor4) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor3);americanintegertiles.add(ttt.neghbor2);}
                                else if(americanintegertiles.contains(ttt.neghbor2) && americanintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor3);}
                                else if(americanintegertiles.contains(ttt.neghbor3) && americanintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: green");americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);}

                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor3);imperialintegertiles.add(ttt.neghbor4);}
                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor4);}
                                else if(imperialintegertiles.contains(ttt.neghbor2) && imperialintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor4);}
                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor4) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor3);imperialintegertiles.add(ttt.neghbor2);}
                                else if(imperialintegertiles.contains(ttt.neghbor2) && imperialintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor3);}
                                else if(imperialintegertiles.contains(ttt.neghbor3) && imperialintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: orange");imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);}

                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor2) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor3);continentalintegertiles.add(ttt.neghbor4);}
                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor4);}
                                else if(continentalintegertiles.contains(ttt.neghbor2) && continentalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor4);}
                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor4) && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor3);continentalintegertiles.add(ttt.neghbor2);}
                                else if(continentalintegertiles.contains(ttt.neghbor2) && continentalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor3);}
                                else if(continentalintegertiles.contains(ttt.neghbor3) && continentalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: purple");continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);}

                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor2) && towerintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: red");towerintegertiles.add(ttt.neghbor4);}
                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor2) && towerintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: red");towerintegertiles.add(ttt.neghbor4);}
                                else if(towerintegertiles.contains(ttt.neghbor2) && towerintegertiles.contains(ttt.neghbor3) && towerintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: red");towerintegertiles.add(ttt.neghbor1);}
                                else if(towerintegertiles.contains(ttt.neghbor1) && towerintegertiles.contains(ttt.neghbor3) && towerintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: red");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: red");towerintegertiles.add(ttt.neghbor2);}

                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor2) && sacksonintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(ttt.neghbor4);}
                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor2) && sacksonintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(ttt.neghbor4);}
                                else if(sacksonintegertiles.contains(ttt.neghbor2) && sacksonintegertiles.contains(ttt.neghbor3) && sacksonintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(ttt.neghbor1);}
                                else if(sacksonintegertiles.contains(ttt.neghbor1) && sacksonintegertiles.contains(ttt.neghbor3) && sacksonintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: yellow");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: yellow");sacksonintegertiles.add(ttt.neghbor2);}

                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor2) && imperialintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: orange");imperialintegertiles.add(ttt.neghbor4);}
                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor2) && imperialintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: orange");imperialintegertiles.add(ttt.neghbor4);}
                                else if(imperialintegertiles.contains(ttt.neghbor2) && imperialintegertiles.contains(ttt.neghbor3) && imperialintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: orange");imperialintegertiles.add(ttt.neghbor1);}
                                else if(imperialintegertiles.contains(ttt.neghbor1) && imperialintegertiles.contains(ttt.neghbor3) && imperialintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: orange");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: orange");imperialintegertiles.add(ttt.neghbor2);}

                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor2) && continentalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: purple");continentalintegertiles.add(ttt.neghbor4);}
                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor2) && continentalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: purple");continentalintegertiles.add(ttt.neghbor4);}
                                else if(continentalintegertiles.contains(ttt.neghbor2) && continentalintegertiles.contains(ttt.neghbor3) && continentalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: purple");continentalintegertiles.add(ttt.neghbor1);}
                                else if(continentalintegertiles.contains(ttt.neghbor1) && continentalintegertiles.contains(ttt.neghbor3) && continentalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: purple");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: purple");continentalintegertiles.add(ttt.neghbor2);}

                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor2) && festivalintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: blue");festivalintegertiles.add(ttt.neghbor4);}
                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor2) && festivalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: blue");festivalintegertiles.add(ttt.neghbor4);}
                                else if(festivalintegertiles.contains(ttt.neghbor2) && festivalintegertiles.contains(ttt.neghbor3) && festivalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: blue");festivalintegertiles.add(ttt.neghbor1);}
                                else if(festivalintegertiles.contains(ttt.neghbor1) && festivalintegertiles.contains(ttt.neghbor3) && festivalintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: blue");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: blue");festivalintegertiles.add(ttt.neghbor2);}

                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor2) && americanintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: green");americanintegertiles.add(ttt.neghbor4);}
                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor2) && americanintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: green");americanintegertiles.add(ttt.neghbor4);}
                                else if(americanintegertiles.contains(ttt.neghbor2) && americanintegertiles.contains(ttt.neghbor3) && americanintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: green");americanintegertiles.add(ttt.neghbor1);}
                                else if(americanintegertiles.contains(ttt.neghbor1) && americanintegertiles.contains(ttt.neghbor3) && americanintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: green");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: green");americanintegertiles.add(ttt.neghbor2);}

                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor2) && worldwideintegertiles.contains(ttt.neghbor3)&& gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color: teal");worldwideintegertiles.add(ttt.neghbor4);}
                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor2) && worldwideintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color: teal");worldwideintegertiles.add(ttt.neghbor4);}
                                else if(worldwideintegertiles.contains(ttt.neghbor2) && worldwideintegertiles.contains(ttt.neghbor3) && worldwideintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color: teal");worldwideintegertiles.add(ttt.neghbor1);}
                                else if(worldwideintegertiles.contains(ttt.neghbor1) && worldwideintegertiles.contains(ttt.neghbor3) && worldwideintegertiles.contains(ttt.neghbor4)&& gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){gridPane.getChildren().get(s).setStyle("-fx-background-color: teal");gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color: teal");worldwideintegertiles.add(ttt.neghbor2);}


                            }

                        }
                        else {gridPane.getChildren().get(s).setStyle("-fx-background-color: gray");}
                    }
                }
            }

        }
    }














    public void search() {
        selectedItem = mComboBox.getSelectionModel().getSelectedItem();
        for (Corporation co : gb.lisrofCorp()) {
            if (selectedItem.equals(co.getName())) {
                color = co.getColor();
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
    public void changecolor(String tile) {
        for (int number : ttt.neighbors(tile)) {
            for(int num: gameBoard.integeroflistofwholetilesthatplayed){
                    if(num==number){
                        integerArrayList.add(number);
                    }
            }
        }
        System.out.println(integerArrayList+" this is the integer arraylist");

    }
    public void setneighbor(List<Integer> list){

        if(list.size()==4){
            ttt.neghbor1=list.get(0);
            ttt.neghbor2=list.get(1);
            ttt.neghbor3=list.get(2);
            ttt.neghbor4=list.get(3);
        }
        if(list.size()==3){
            ttt.neghbor1=list.get(0);
            ttt.neghbor2=list.get(1);
            ttt.neghbor3=list.get(2);
        }
        if(list.size()==2){
            ttt.neghbor1=list.get(0);
            ttt.neghbor2=list.get(1);
        }
        if(list.size()==1) {
            ttt.neghbor1 = list.get(0);
        }



    }
    public String checkothercolors(List<Integer> list){
        if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){
        }

        for(Integer elements: list){
            if(towerintegertiles.contains(elements)){return "red";}
            if(sacksonintegertiles.contains(elements)){return "red";}
            if(imperialintegertiles.contains(elements)){return "red";}
            if(worldwideintegertiles.contains(elements)){return "red";}
            if(festivalintegertiles.contains(elements)){return "red";}
            if(americanintegertiles.contains(elements)){return "red";}
            if(continentalintegertiles.contains(elements)){return "red";}
            else {}
        }

        return null;
    }


    public boolean checkingneighbor(List<Integer> list){
        for(Integer value: list){
            if(towerintegertiles.contains(value)){return true;}
            if(festivalintegertiles.contains(value)){return true;}
            if(worldwideintegertiles.contains(value)){return true;}
            if(imperialintegertiles.contains(value)){return true;}
            if(sacksonintegertiles.contains(value)){return true;}
            if(americanintegertiles.contains(value)){return true;}
            if(continentalintegertiles.contains(value)){return true;}
        }
        return false;

    }
    public Integer integercommonneighbor(List<Integer> list){
        forchangingtilescolor=new ArrayList<>();
        for(Integer value: list){
            for(Integer value1: towerintegertiles) {
                if(value.equals(value1)){return value1;}
                forchangingtilescolor.add(value);

            }
            for(Integer value1: festivalintegertiles) {
                if(value.equals(value1)){return value1;}
                forchangingtilescolor.add(value);

            }
            for(Integer value1: imperialintegertiles) {
                if(value.equals(value1)){return value1;}
                forchangingtilescolor.add(value);

            }
            for(Integer value1: continentalintegertiles) {
                if(value.equals(value1)){return value1;}
                forchangingtilescolor.add(value);

            }
            for(Integer value1: worldwideintegertiles) {
                if(value.equals(value1)){return value1;}
                forchangingtilescolor.add(value);

            }
            for(Integer value1: sacksonintegertiles) {
                if(value.equals(value1)){return value1;}
                forchangingtilescolor.add(value);

            }
            for(Integer value1: americanintegertiles) {
                if(value.equals(value1)){return value1;}
                forchangingtilescolor.add(value);
            }


        }
        return null;

    }




public void updateplayerhand(ObservableList<String> list, ArrayList<String> handslist,String tile){
    String randtile1=gameBoard.drawTile();
    handslist.remove(tile);
    handslist.add(randtile1);
    list.remove(tile);
    list.add(randtile1);
}
}
