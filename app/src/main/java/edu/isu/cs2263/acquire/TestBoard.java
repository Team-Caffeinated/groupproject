package edu.isu.cs2263.acquire;

import javafx.animation.FadeTransition;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    List<Corporation> corpsname=Arrays.asList(gameBoard.tower,gameBoard.american,gameBoard.festival,gameBoard.continental,gameBoard.sackson,gameBoard.worldwide,gameBoard.imperial);
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
    static Stage stage=new Stage();
    public static String color;
    ObservableList<String> corpsize=FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {
        for (Corporation corp : corpsname)
        {
            mComboBox.getItems().add(corp.getName());
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
        hand.add(gameBoard.drawTile());
        gameBoard.getPlayer1().setHand(hand);


        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
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
             if(!gb.getPlayer1().getHand().contains(place.getText().toUpperCase()))
            {
                place.setStyle("-fx-border-color: red;");
                place.clear();
                place.setPromptText("Try again");
                place.setText(place.getText());

            }
             else {


                 listView1.setStyle("-fx-control-inner-background: black;-fx-background-insets: 0 ");
                 listView2.setStyle("-fx-control-inner-background: green;-fx-background-insets: 0 ");
                 corpsize.removeAll("Tower :\t\t\t\t\t\t" + sizetower, "Imperial :\t\t\t\t\t\t" + sizeimperial, "Festival :\t\t\t\t\t\t" + sizefestival, "Worldwide :\t\t\t\t\t" + sizeworldwide, "Sackson :\t\t\t\t\t\t" + sizesackson, "American :\t\t\t\t\t" + sizeamerican, "Continental :\t\t\t\t\t" + sizecontinental);
                 update();
                 updateplayerhand(names, gameBoard.getPlayer1().getHand(), place.getText());
                 listViewPlayer1.setVisible(false);
                 place.setVisible(false);
                 placebutton.setVisible(false);
                 player1Tile.setVisible(false);
                 place.clear();
                 place1.setVisible(true);
                 placebutton1.setVisible(true);
                 listViewPlayer2.setVisible(true);
                 player2Tile.setVisible(true);
                 corpsize.addAll("Tower :\t\t\t\t\t\t" + sizetower, "Imperial :\t\t\t\t\t\t" + sizeimperial, "Festival :\t\t\t\t\t\t" + sizefestival, "Worldwide :\t\t\t\t\t" + sizeworldwide, "Sackson :\t\t\t\t\t\t" + sizesackson, "American :\t\t\t\t\t" + sizeamerican, "Continental :\t\t\t\t\t" + sizecontinental);
             }
            });
        placebutton1.setOnAction(event -> {
            if(!gb.getPlayer2().getHand().contains(place1.getText().toUpperCase()))
            {
                place1.setStyle("-fx-border-color: red;");
                place1.clear();
                place1.setPromptText("Try again");
                place1.setText(place1.getText());

            }
            else {
                listView1.setStyle("-fx-control-inner-background: green;-fx-background-insets: 0 ");
                listView2.setStyle("-fx-control-inner-background: black;-fx-background-insets: 0 ");
                corpsize.removeAll("Tower :\t\t\t\t\t\t" + sizetower, "Imperial :\t\t\t\t\t\t" + sizeimperial, "Festival :\t\t\t\t\t\t" + sizefestival, "Worldwide :\t\t\t\t\t" + sizeworldwide, "Sackson :\t\t\t\t\t\t" + sizesackson, "American :\t\t\t\t\t" + sizeamerican, "Continental :\t\t\t\t\t" + sizecontinental);
                update();
                updateplayerhand(names1, gameBoard.getPlayer2().getHand(), place1.getText());
                listViewPlayer2.setVisible(false);
                place1.setVisible(false);
                placebutton1.setVisible(false);
                player2Tile.setVisible(false);
                place1.clear();
                player1Tile.setVisible(true);
                place.setVisible(true);
                placebutton.setVisible(true);
                listViewPlayer1.setVisible(true);


                corpsize.addAll("Tower :\t\t\t\t\t\t" + sizetower, "Imperial :\t\t\t\t\t\t" + sizeimperial, "Festival :\t\t\t\t\t\t" + sizefestival, "Worldwide :\t\t\t\t\t" + sizeworldwide, "Sackson :\t\t\t\t\t\t" + sizesackson, "American :\t\t\t\t\t" + sizeamerican, "Continental :\t\t\t\t\t" + sizecontinental);


            }




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
        String randtile1=gb.drawTile();
        handslist.remove(tile);
        handslist.add(randtile1);
        list.remove(tile);
        list.add(randtile1);
    }


}
