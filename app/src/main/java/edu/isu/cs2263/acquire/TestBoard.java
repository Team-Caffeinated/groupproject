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
import javafx.scene.control.cell.PropertyValueFactory;
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


public class TestBoard extends Application {
    Tile ttt=new Tile();
    ArrayList<Integer> forchangingtilescolor=new ArrayList<>();
    ArrayList<Integer> integerArrayList=new ArrayList<>();
    //==================================================================================================================
    //==================================================================================================================
    Integer sizetower=0;
    Integer sizeamerican=0;
    Integer sizefestival=0;
    Integer sizecontinental=0;
    Integer sizesackson=0;
    Integer sizeworldwide=0;
    Integer sizeimperial=0;
    //==================================================================================================================
    //==================================================================================================================
    ArrayList<Integer> towerintegertiles =new ArrayList<>();
    ArrayList<Integer> americanintegertiles =new ArrayList<>();
    ArrayList<Integer> festivalintegertiles =new ArrayList<>();
    ArrayList<Integer> continentalintegertiles =new ArrayList<>();
    ArrayList<Integer> sacksonintegertiles =new ArrayList<>();
    ArrayList<Integer> worldwideintegertiles =new ArrayList<>();
    ArrayList<Integer> imperialintegertiles =new ArrayList<>();
    //==================================================================================================================
    //==================================================================================================================
    GridPane gridPane = new GridPane();
    static GameBoard gameBoard = new GameBoard();
    List<Corporation> nebulas=Arrays.asList(gameBoard.tower,gameBoard.american,gameBoard.festival,gameBoard.continental,gameBoard.sackson,gameBoard.worldwide,gameBoard.imperial);
    //==================================================================================================================
    //==================================================================================================================
    GameBoard gb=new GameBoard();
    private final ComboBox<String> mComboBox=new ComboBox<>();
    String selectedItem;
    static VBox contentVBox = new VBox();
    private final TextField place = new TextField();
    private final Button placebutton = new Button("PLACE");
    private final TextField place1 = new TextField();
    private final Button placebutton1 = new Button("PLACE");
    private static final Button selectyourcorporation=new Button("Select Your Corporation");
    ArrayList<String> hand = new ArrayList<>();
    ArrayList<String> hand1 = new ArrayList<>();
    Tile whhhholetiles = new Tile();
    static Stage stage=new Stage();
    public static String color;

    ObservableList<String> corpsize=FXCollections.observableArrayList();

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
        hand.add("7I");
        hand.add("11I");










        gameBoard.getPlayer1().setHand(hand);


/*
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());

 */


        hand1.add("12A");
        hand1.add("4A");
        hand1.add("3A");



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
        place.setPromptText("Type Your Tile Here (Lower or Upper case)");
        place.setLayoutX(850);
        place.setLayoutY(320);
        placebutton.setLayoutX(900);
        placebutton.setLayoutY(350);

        place1.setPromptText("Type Your Tile Here (Lower or Upper case)");
        place1.setLayoutX(1110);
        place1.setLayoutY(320);
        placebutton1.setLayoutX(1160);
        placebutton1.setLayoutY(350);
        place1.setVisible(false);
        placebutton1.setVisible(false);
        //==================================================================================================================
        //=================================================================================================================
        Label player1Tile=new Label("Player 1 Tiles");
        Label player2Tile=new Label("Player 2 Tiles");
        player1Tile.setTranslateY(100);
        player1Tile.setTranslateX(780);
        player2Tile.setTranslateY(100);
        player2Tile.setTranslateX(1040);
        player1Tile.setFont(Font.font(20));
        player2Tile.setFont(Font.font(20));
        player2Tile.setVisible(false);
        //==================================================================================================================
        //==================================================================================================================
        selectyourcorporation.setLayoutY(500);
        selectyourcorporation.setLayoutX(500);
        contentVBox.setLayoutX(300);
        contentVBox.setLayoutY(300);
        //=============================================================================================================
        //=============================================================================================================
        ObservableList<String> player1 = FXCollections.observableArrayList( "Name :"+gameBoard.getPlayer1().getName(),"Cash : $"+gameBoard.getPlayer1().getMoney(),"Stocks :"+gameBoard.getPlayer1().getHand());
        ObservableList<String> player2 = FXCollections.observableArrayList( "Name :"+gameBoard.getPlayer2().getName(),"Cash : $"+gameBoard.getPlayer2().getMoney(),"Stocks :"+gameBoard.getPlayer2().getHand());
        ObservableList<String> names = FXCollections.observableArrayList(gameBoard.getPlayer1().getHand());
        ObservableList<String> names1 = FXCollections.observableArrayList(gameBoard.getPlayer2().getHand());
        //==================================================================================================================
        //==================================================================================================================
        ListView listView1=new ListView(player1);
        ListView listView2=new ListView(player2);
        listView1.setTranslateY(400);
        listView1.setTranslateX(800);
        listView1.setMaxSize(500,150);
        listView2.setTranslateY(400);
        listView2.setTranslateX(1050);
        listView2.setMaxSize(500,150);
        listView1.setStyle("-fx-control-inner-background: green;-fx-background-insets: 0 ");
        listView2.setStyle("-fx-control-inner-background: black;-fx-background-insets: 0 ");
        //==================================================================================================================
        //==================================================================================================================
        ListView<String> listViewPlayer1 = new ListView<String>(names);
        ListView<String> listViewPlayer2 = new ListView<String>(names1);
        ListView<String> listViewcorporationsize=new ListView<>(corpsize);
        listViewcorporationsize.setTranslateY(585);
        listViewcorporationsize.setMaxSize(1000,200);
        listViewcorporationsize.setStyle("-fx-control-inner-background: dimgray;-fx-background-insets: 0 ");
        listViewPlayer2.setVisible(false);
        //==================================================================================================================
        //==================================================================================================================
        corpsize.addAll("Tower :\t\t\t\t\t\t"+sizetower,"Imperial :\t\t\t\t\t\t"+sizeimperial,"Festival :\t\t\t\t\t\t"+sizefestival,"Worldwide :\t\t\t\t\t"+sizeworldwide,"Sackson :\t\t\t\t\t\t"+sizesackson,"American :\t\t\t\t\t"+sizeamerican,"Continental :\t\t\t\t\t"+sizecontinental);
        //==================================================================================================================
        //==================================================================================================================
        placebutton.setOnAction(event -> {
            listView1.setStyle("-fx-control-inner-background: black;-fx-background-insets: 0 ");
            listView2.setStyle("-fx-control-inner-background: green;-fx-background-insets: 0 ");
            corpsize.removeAll("Tower :\t\t\t\t\t\t"+sizetower,"Imperial :\t\t\t\t\t\t"+sizeimperial,"Festival :\t\t\t\t\t\t"+sizefestival,"Worldwide :\t\t\t\t\t"+sizeworldwide,"Sackson :\t\t\t\t\t\t"+sizesackson,"American :\t\t\t\t\t"+sizeamerican,"Continental :\t\t\t\t\t"+sizecontinental);
            update();
            updateplayerhand(names,gameBoard.getPlayer1().getHand(),place.getText());
            listViewPlayer1.setVisible(false);
            place.setVisible(false);
            placebutton.setVisible(false);
            player1Tile.setVisible(false);
            place.clear();
            place1.setVisible(true);
            placebutton1.setVisible(true);
            listViewPlayer2.setVisible(true);
            player2Tile.setVisible(true);


            corpsize.addAll("Tower :\t\t\t\t\t\t"+sizetower,"Imperial :\t\t\t\t\t\t"+sizeimperial,"Festival :\t\t\t\t\t\t"+sizefestival,"Worldwide :\t\t\t\t\t"+sizeworldwide,"Sackson :\t\t\t\t\t\t"+sizesackson,"American :\t\t\t\t\t"+sizeamerican,"Continental :\t\t\t\t\t"+sizecontinental);
        });
        placebutton1.setOnAction(event -> {
            listView1.setStyle("-fx-control-inner-background: green;-fx-background-insets: 0 ");
            listView2.setStyle("-fx-control-inner-background: black;-fx-background-insets: 0 ");
            corpsize.removeAll("Tower :\t\t\t\t\t\t"+sizetower,"Imperial :\t\t\t\t\t\t"+sizeimperial,"Festival :\t\t\t\t\t\t"+sizefestival,"Worldwide :\t\t\t\t\t"+sizeworldwide,"Sackson :\t\t\t\t\t\t"+sizesackson,"American :\t\t\t\t\t"+sizeamerican,"Continental :\t\t\t\t\t"+sizecontinental);
            update();
            updateplayerhand(names1,gameBoard.getPlayer2().getHand(),place1.getText());
            listViewPlayer2.setVisible(false);
            place1.setVisible(false);
            placebutton1.setVisible(false);
            player2Tile.setVisible(false);
            place1.clear();
            player1Tile.setVisible(true);
            place.setVisible(true);
            placebutton.setVisible(true);
            listViewPlayer1.setVisible(true);


            corpsize.addAll("Tower :\t\t\t\t\t\t"+sizetower,"Imperial :\t\t\t\t\t\t"+sizeimperial,"Festival :\t\t\t\t\t\t"+sizefestival,"Worldwide :\t\t\t\t\t"+sizeworldwide,"Sackson :\t\t\t\t\t\t"+sizesackson,"American :\t\t\t\t\t"+sizeamerican,"Continental :\t\t\t\t\t"+sizecontinental);







        });
        //=============================================================================================================
        //=============================================================================================================
        listViewPlayer1.setMaxSize(50, 200);
        listViewPlayer1.setTranslateX(900);
        listViewPlayer1.setTranslateY(100);
        listViewPlayer1.setStyle("-fx-control-inner-background: green;-fx-background-insets: 0 ");

        listViewPlayer2.setMaxSize(50, 200);
        listViewPlayer2.setTranslateX(1160);
        listViewPlayer2.setTranslateY(100);
        listViewPlayer2.setStyle("-fx-control-inner-background: green;-fx-background-insets: 0 ");
        //=============================================================================================================
        //==================================================================================================================
        Label tower=new Label("tower\t\t");
        tower.setStyle("-fx-background-color: red;");
        tower.setTranslateY(590);
        tower.setTranslateX(80);
        tower.setTextFill(Color.RED);
        Label imperial=new Label("imperial\t\t");
        imperial.setStyle("-fx-background-color: orange;");
        imperial.setTranslateY(612);
        imperial.setTranslateX(80);
        imperial.setTextFill(Color.ORANGE);
        Label continental=new Label("continental\t");
        continental.setStyle("-fx-background-color: purple;");
        continental.setTranslateY(728);
        continental.setTranslateX(80);
        continental.setTextFill(Color.PURPLE);
        Label festival=new Label("festival\t\t");
        festival.setStyle("-fx-background-color: blue;");
        festival.setTranslateY(635);
        festival.setTranslateX(80);
        festival.setTextFill(Color.BLUE);
        Label sackson=new Label("sackson\t\t");
        sackson.setStyle("-fx-background-color: yellow;");
        sackson.setTranslateY(682);
        sackson.setTranslateX(80);
        sackson.setTextFill(Color.YELLOW);
        Label american=new Label("american\t\t");
        american.setStyle("-fx-background-color: green;");
        american.setTranslateY(705);
        american.setTranslateX(80);
        american.setTextFill(Color.GREEN);
        Label worldwide=new Label("worldwide\t");
        worldwide.setStyle("-fx-background-color: teal;");
        worldwide.setTranslateY(657);
        worldwide.setTranslateX(80);
        worldwide.setTextFill(Color.TEAL);
        //==================================================================================================================
        //==================================================================================================================
        Group group = new Group(gridPane,listViewcorporationsize,label, listViewPlayer1, listViewPlayer2, place, placebutton, place1, placebutton1,tower,festival,american,imperial,worldwide,continental,sackson,player1Tile,player2Tile,listView1,listView2);
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

                            if(newList.size()==1) {
                                if (gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")) {
                                    demo();
                                    if (color.equals("red")){sizetower=sizetower+2; towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);}
                                    if (color.equals("purple")){sizecontinental=sizecontinental+2;continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);}
                                    if (color.equals("yellow")){sizesackson=sizesackson+2;sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);}
                                    if (color.equals("green")){sizeamerican=sizeamerican+2;americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);}
                                    if (color.equals("blue")){sizefestival=sizefestival+2;festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);}
                                    if (color.equals("orange")){sizeimperial=sizeimperial+2;imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);}
                                    if (color.equals("teal")){sizeworldwide=sizeworldwide+2;worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);}


                                    gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color:" + color);
                                    gridPane.getChildren().get(s).setStyle("-fx-background-color:" + color);
                                    integerArrayList.clear();

                                } else if (!gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("")) {

                                    if (color.equals("red")){sizetower=sizetower+1;towerintegertiles.add(s);}
                                    if (color.equals("purple")){sizecontinental=sizecontinental+1;continentalintegertiles.add(s);}
                                    if (color.equals("yellow")){sizesackson=sizesackson+1;sacksonintegertiles.add(s);}
                                    if (color.equals("green")){sizeamerican=sizeamerican+1;americanintegertiles.add(s);}
                                    if (color.equals("blue")){sizefestival=sizefestival+1;festivalintegertiles.add(s);}
                                    if (color.equals("orange")){sizeimperial=sizeimperial+1;imperialintegertiles.add(s);}
                                    if (color.equals("teal")){sizeworldwide=sizeworldwide+1;worldwideintegertiles.add(s);}

                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                }
                            }
                            if(newList.size()==2){
                                if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")){
                                    demo();
                                    if(color.equals("red")){
                                        towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);
                                        if(sizetower==0){
                                            sizetower=sizetower+3;}
                                        else {sizetower=sizetower+2;}}
                                    if(color.equals("purple")){
                                        continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);
                                        if(sizecontinental==0){
                                            sizecontinental=sizecontinental+3;}
                                        else {sizecontinental=sizecontinental+2;}}
                                    if(color.equals("yellow")){
                                        sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);
                                        if(sizesackson==0){
                                            sizesackson=sizesackson+3;}
                                        else {sizesackson=sizesackson+2;}}
                                    if(color.equals("green")){
                                        americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);
                                        if(sizeamerican==0){
                                            sizeamerican=sizeamerican+3;}
                                        else {sizeamerican=sizeamerican+2;}}
                                    if(color.equals("blue")){
                                        festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);
                                        if(sizefestival==0){
                                            sizefestival=sizefestival+3;}
                                        else {sizefestival=sizefestival+2;}}
                                    if(color.equals("orange")){
                                        imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);
                                        if(sizeimperial==0){
                                            sizeimperial=sizeimperial+3;}
                                        else {sizeimperial=sizeimperial+2;}}
                                    if(color.equals("teal")){
                                        worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);
                                        if(sizeworldwide==0){
                                            sizeworldwide=sizeworldwide+3;}
                                        else {sizeworldwide=sizeworldwide+2;}}

                                    gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(s).setStyle("-fx-background-color:"+color);
                                    integerArrayList.clear();}
                                if(checkingneighbor(newList)){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(integercommonneighbor(newList)).getStyle());
                                    for(Integer change: forchangingtilescolor){
                                        gridPane.getChildren().get(change).setStyle(gridPane.getChildren().get(integercommonneighbor(newList)).getStyle());
                                    }


                                }

                            }
                            if(newList.size()==3){
                                if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){
                                    demo();
                                    if(color.equals("red")){
                                        towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor3);
                                        if(sizetower==0){
                                            sizetower=sizetower+4;}
                                        else {sizetower=sizetower+3;}}
                                    if(color.equals("purple")){
                                        continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor3);
                                        if(sizecontinental==0){
                                            sizecontinental=sizecontinental+4;}
                                        else {sizecontinental=sizecontinental+3;}}
                                    if(color.equals("yellow")){
                                        sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor3);
                                        if(sizesackson==0){
                                            sizesackson=sizesackson+4;}
                                        else {sizesackson=sizesackson+3;}}
                                    if(color.equals("green")){
                                        americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor3);
                                        if(sizeamerican==0){
                                            sizeamerican=sizeamerican+4;}
                                        else {sizeamerican=sizeamerican+3;}}
                                    if(color.equals("blue")){
                                        festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor3);
                                        if(sizefestival==0){
                                            sizefestival=sizefestival+4;}
                                        else {sizefestival=sizefestival+3;}}
                                    if(color.equals("orange")){
                                        imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor3);
                                        if(sizeimperial==0){
                                            sizeimperial=sizeimperial+4;}
                                        else {sizeimperial=sizeimperial+3;}}
                                    if(color.equals("teal")){
                                        worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor3);
                                        if(sizeworldwide==0){
                                            sizeworldwide=sizeworldwide+4;}
                                        else {sizeworldwide=sizeworldwide+3;}}

                                    gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(s).setStyle("-fx-background-color:"+color);
                                    integerArrayList.clear();}
                            }
                            if(newList.size()==4){
                                if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") &&gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){
                                    demo();
                                    if(color.equals("red")){
                                        towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor3);towerintegertiles.add(ttt.neghbor4);
                                        if(sizetower==0){
                                            sizetower=sizetower+5;}
                                        else {sizetower=sizetower+4;}}

                                    if(color.equals("purple")){
                                        continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor3);continentalintegertiles.add(ttt.neghbor4);
                                        if(sizecontinental==0){
                                            sizecontinental=sizecontinental+5;}
                                        else {sizecontinental=sizecontinental+4;}}

                                    if(color.equals("yellow")){
                                        sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor3);sacksonintegertiles.add(ttt.neghbor4);
                                        if(sizesackson==0){
                                            sizesackson=sizesackson+5;}
                                        else {sizesackson=sizesackson+4;}}

                                    if(color.equals("green")){
                                        americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor3);americanintegertiles.add(ttt.neghbor4);
                                        if(sizeamerican==0){
                                            sizeamerican=sizeamerican+5;}
                                        else {sizeamerican=sizeamerican+4;}}

                                    if(color.equals("blue")){
                                        festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor3);festivalintegertiles.add(ttt.neghbor4);
                                        if(sizefestival==0){
                                            sizefestival=sizefestival+5;}
                                        else {sizefestival=sizefestival+4;}}

                                    if(color.equals("orange")){
                                        imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor3);imperialintegertiles.add(ttt.neghbor4);
                                        if(sizeimperial==0){
                                            sizeimperial=sizeimperial+5;}
                                        else {sizeimperial=sizeimperial+4;}}

                                    if(color.equals("teal")){
                                        worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor3);worldwideintegertiles.add(ttt.neghbor4);
                                        if(sizeworldwide==0){
                                            sizeworldwide=sizeworldwide+5;}
                                        else {sizeworldwide=sizeworldwide+4;}}

                                    gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(s).setStyle("-fx-background-color:"+color);
                                    integerArrayList.clear();
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
                        gameBoard.integeroflistofwholetilesthatplayed.add(s);

                        if (gameBoard.check(gameBoard.listofwholetilesthatplayed, place1.getText())) {
                            integerArrayList=new ArrayList<>();
                            changecolor(place1.getText());
                            setneighbor(integerArrayList);
                            List<Integer> newList = integerArrayList.stream()
                                    .distinct()
                                    .collect(Collectors.toList());
                            if(integerArrayList.size()==1){
                                if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray")){
                                    demo();
                                    if (color.equals("red")){sizetower=sizetower+2; towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);}
                                    if (color.equals("purple")){sizecontinental=sizecontinental+2;continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);}
                                    if (color.equals("yellow")){sizesackson=sizesackson+2;sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);}
                                    if (color.equals("green")){sizeamerican=sizeamerican+2;americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);}
                                    if (color.equals("blue")){sizefestival=sizefestival+2;festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);}
                                    if (color.equals("orange")){sizeimperial=sizeimperial+2;imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);}
                                    if (color.equals("teal")){sizeworldwide=sizeworldwide+2;worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);}


                                    gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(s).setStyle("-fx-background-color:"+color);
                                    integerArrayList.clear();
                                }else if(!gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && !gridPane.getChildren().get(ttt.neghbor1).getStyle().equals(""))
                                {
                                    if (color.equals("red")){sizetower=sizetower+1;towerintegertiles.add(s);}
                                    if (color.equals("purple")){sizecontinental=sizecontinental+1;continentalintegertiles.add(s);}
                                    if (color.equals("yellow")){sizesackson=sizesackson+1;sacksonintegertiles.add(s);}
                                    if (color.equals("green")){sizeamerican=sizeamerican+1;americanintegertiles.add(s);}
                                    if (color.equals("blue")){sizefestival=sizefestival+1;festivalintegertiles.add(s);}
                                    if (color.equals("orange")){sizeimperial=sizeimperial+1;imperialintegertiles.add(s);}
                                    if (color.equals("teal")){sizeworldwide=sizeworldwide+1;worldwideintegertiles.add(s);}

                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                                }
                            }

                            if(integerArrayList.size()==2){
                                if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray")) {
                                    demo();
                                    if (color.equals("red")) {
                                        towerintegertiles.add(s);
                                        towerintegertiles.add(ttt.neghbor1);
                                        towerintegertiles.add(ttt.neghbor2);
                                        if (sizetower == 0) {
                                            sizetower = sizetower + 3;
                                        } else {
                                            sizetower = sizetower + 2;
                                        }
                                    }

                                    if (color.equals("purple")) {
                                        continentalintegertiles.add(s);
                                        continentalintegertiles.add(ttt.neghbor1);
                                        continentalintegertiles.add(ttt.neghbor2);
                                        if (sizecontinental == 0) {
                                            sizecontinental = sizecontinental + 3;
                                        } else {
                                            sizecontinental = sizecontinental + 2;
                                        }
                                    }

                                    if (color.equals("yellow")) {
                                        sacksonintegertiles.add(s);
                                        sacksonintegertiles.add(ttt.neghbor1);
                                        sacksonintegertiles.add(ttt.neghbor2);
                                        if (sizesackson == 0) {
                                            sizesackson = sizesackson + 3;
                                        } else {
                                            sizesackson = sizesackson + 2;
                                        }
                                    }

                                    if (color.equals("green")) {
                                        americanintegertiles.add(s);
                                        americanintegertiles.add(ttt.neghbor1);
                                        americanintegertiles.add(ttt.neghbor2);
                                        if (sizeamerican == 0) {
                                            sizeamerican = sizeamerican + 3;
                                        } else {
                                            sizeamerican = sizeamerican + 2;
                                        }
                                    }

                                    if (color.equals("blue")) {
                                        festivalintegertiles.add(s);
                                        festivalintegertiles.add(ttt.neghbor1);
                                        festivalintegertiles.add(ttt.neghbor2);
                                        if (sizefestival == 0) {
                                            sizefestival = sizefestival + 3;
                                        } else {
                                            sizefestival = sizefestival + 2;
                                        }
                                    }

                                    if (color.equals("orange")) {
                                        imperialintegertiles.add(s);
                                        imperialintegertiles.add(ttt.neghbor1);
                                        imperialintegertiles.add(ttt.neghbor2);
                                        if (sizeimperial == 0) {
                                            sizeimperial = sizeimperial + 3;
                                        } else {
                                            sizeimperial = sizeimperial + 2;
                                        }
                                    }

                                    if (color.equals("teal")) {
                                        worldwideintegertiles.add(s);
                                        worldwideintegertiles.add(ttt.neghbor1);
                                        worldwideintegertiles.add(ttt.neghbor2);
                                        if (sizeworldwide == 0) {
                                            sizeworldwide = sizeworldwide + 3;
                                        } else {
                                            sizeworldwide = sizeworldwide + 2;
                                        }
                                    }

                                    gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color:" + color);
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color:" + color);
                                    gridPane.getChildren().get(s).setStyle("-fx-background-color:" + color);
                                    integerArrayList.clear();
                                }
                                if(checkingneighbor(newList)){
                                    gridPane.getChildren().get(s).setStyle(gridPane.getChildren().get(integercommonneighbor(newList)).getStyle());
                                    for(Integer change: forchangingtilescolor){
                                        gridPane.getChildren().get(change).setStyle(gridPane.getChildren().get(integercommonneighbor(newList)).getStyle());
                                    }


                                }
                            }

                            if(integerArrayList.size()==3){
                                if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") &&gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray")){
                                    demo();
                                    if(color.equals("red")){
                                        towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor3);
                                        if(sizetower==0){
                                            sizetower=sizetower+4;}
                                        else {sizetower=sizetower+3;}}

                                    if(color.equals("purple")){
                                        continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor3);
                                        if(sizecontinental==0){
                                            sizecontinental=sizecontinental+4;}
                                        else {sizecontinental=sizecontinental+3;}}

                                    if(color.equals("yellow")){
                                        sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor3);
                                        if(sizesackson==0){
                                            sizesackson=sizesackson+4;}
                                        else {sizesackson=sizesackson+3;}}

                                    if(color.equals("green")){
                                        americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor3);
                                        if(sizeamerican==0){
                                            sizeamerican=sizeamerican+4;}
                                        else {sizeamerican=sizeamerican+3;}}

                                    if(color.equals("blue")){
                                        festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor3);
                                        if(sizefestival==0){
                                            sizefestival=sizefestival+4;}
                                        else {sizefestival=sizefestival+3;}}

                                    if(color.equals("orange")){
                                        imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor3);
                                        if(sizeimperial==0){
                                            sizeimperial=sizeimperial+4;}
                                        else {sizeimperial=sizeimperial+3;}}

                                    if(color.equals("teal")){
                                        worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor3);
                                        if(sizeworldwide==0){
                                            sizeworldwide=sizeworldwide+4;}
                                        else {sizeworldwide=sizeworldwide+3;}}

                                    gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(s).setStyle("-fx-background-color:"+color);
                                    integerArrayList.clear();}
                            }

                            if(integerArrayList.size()==4){
                                if(gridPane.getChildren().get(ttt.neghbor1).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor2).getStyle().equals("-fx-background-color: gray") &&gridPane.getChildren().get(ttt.neghbor3).getStyle().equals("-fx-background-color: gray") && gridPane.getChildren().get(ttt.neghbor4).getStyle().equals("-fx-background-color: gray")){
                                    demo();
                                    if(color.equals("red")){
                                        towerintegertiles.add(s);towerintegertiles.add(ttt.neghbor1);towerintegertiles.add(ttt.neghbor2);towerintegertiles.add(ttt.neghbor3);towerintegertiles.add(ttt.neghbor4);
                                        if(sizetower==0){
                                            sizetower=sizetower+5;}
                                        else {sizetower=sizetower+4;}}

                                    if(color.equals("purple")){
                                        continentalintegertiles.add(s);continentalintegertiles.add(ttt.neghbor1);continentalintegertiles.add(ttt.neghbor2);continentalintegertiles.add(ttt.neghbor3);continentalintegertiles.add(ttt.neghbor4);
                                        if(sizecontinental==0){
                                            sizecontinental=sizecontinental+5;}
                                        else {sizecontinental=sizecontinental+4;}}

                                    if(color.equals("yellow")){
                                        sacksonintegertiles.add(s);sacksonintegertiles.add(ttt.neghbor1);sacksonintegertiles.add(ttt.neghbor2);sacksonintegertiles.add(ttt.neghbor3);sacksonintegertiles.add(ttt.neghbor4);
                                        if(sizesackson==0){
                                            sizesackson=sizesackson+5;}
                                        else {sizesackson=sizesackson+4;}}

                                    if(color.equals("green")){
                                        americanintegertiles.add(s);americanintegertiles.add(ttt.neghbor1);americanintegertiles.add(ttt.neghbor2);americanintegertiles.add(ttt.neghbor3);americanintegertiles.add(ttt.neghbor4);
                                        if(sizeamerican==0){
                                            sizeamerican=sizeamerican+5;}
                                        else {sizeamerican=sizeamerican+4;}}

                                    if(color.equals("blue")){
                                        festivalintegertiles.add(s);festivalintegertiles.add(ttt.neghbor1);festivalintegertiles.add(ttt.neghbor2);festivalintegertiles.add(ttt.neghbor3);festivalintegertiles.add(ttt.neghbor4);
                                        if(sizefestival==0){
                                            sizefestival=sizefestival+5;}
                                        else {sizefestival=sizefestival+4;}}

                                    if(color.equals("orange")){
                                        imperialintegertiles.add(s);imperialintegertiles.add(ttt.neghbor1);imperialintegertiles.add(ttt.neghbor2);imperialintegertiles.add(ttt.neghbor3);imperialintegertiles.add(ttt.neghbor4);
                                        if(sizeimperial==0){
                                            sizeimperial=sizeimperial+5;}
                                        else {sizeimperial=sizeimperial+4;}}

                                    if(color.equals("teal")){
                                        worldwideintegertiles.add(s);worldwideintegertiles.add(ttt.neghbor1);worldwideintegertiles.add(ttt.neghbor2);worldwideintegertiles.add(ttt.neghbor3);worldwideintegertiles.add(ttt.neghbor4);
                                        if(sizeworldwide==0){
                                            sizeworldwide=sizeworldwide+5;}
                                        else {sizeworldwide=sizeworldwide+4;}}

                                    gridPane.getChildren().get(ttt.neghbor1).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor2).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor3).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(ttt.neghbor4).setStyle("-fx-background-color:"+color);
                                    gridPane.getChildren().get(s).setStyle("-fx-background-color:"+color);
                                    integerArrayList.clear();}
                            }
                        }
                        else {gridPane.getChildren().get(s).setStyle("-fx-background-color: gray");}
                    }
                }
            }

        }

        sizetower=towerintegertiles.size();
        sizecontinental=continentalintegertiles.size();
        sizeamerican=americanintegertiles.size();
        sizeworldwide=worldwideintegertiles.size();
        sizesackson=sacksonintegertiles.size();
        sizefestival=festivalintegertiles.size();
        sizeimperial=imperialintegertiles.size();







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
    public void setneighbor(ArrayList<Integer> list){

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
    public void corporationtilesinteeger(){
        for(int s=0;s<108;s++){
            if(gridPane.getChildren().get(s).getStyle().equals("red")){
                towerintegertiles.add(s); }
            if(gridPane.getChildren().get(s).getStyle().equals("purple")){
                continentalintegertiles.add(s);
            }if(gridPane.getChildren().get(s).getStyle().equals("yellow")){
                sacksonintegertiles.add(s);
            }if(gridPane.getChildren().get(s).getStyle().equals("green")){
                americanintegertiles.add(s);
            }if(gridPane.getChildren().get(s).getStyle().equals("blue")){
                festivalintegertiles.add(s);
            }if(gridPane.getChildren().get(s).getStyle().equals("orange")){
                imperialintegertiles.add(s);
            }if(gridPane.getChildren().get(s).getStyle().equals("teal")){
                worldwideintegertiles.add(s);
            }
        }
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
