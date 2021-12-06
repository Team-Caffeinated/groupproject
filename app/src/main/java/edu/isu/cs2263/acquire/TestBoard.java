package edu.isu.cs2263.acquire;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
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
    Label corppick=new Label();
    Button optionforpickacorp1=new Button();
    Button optionforpickacorp2=new Button();
    Button optionforpickacorp3=new Button();
    Button optionforpickacorp4=new Button();

    Button endgame=new Button("Do you want to end this game?");

    Group group=new Group();


    String corpChoice=new String();




    //=================================================================================================================
    Tile ttt=new Tile();
    ArrayList<Integer> forchangingtilescolor=new ArrayList<>();
    ArrayList<Integer> integerArrayList=new ArrayList<>();
    //==================================================================================================================


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
    GridPane info=new GridPane();
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
    private Button buyselltrade=new Button("Buy / Sell / Trade");
    ArrayList<String> hand = new ArrayList<>();
    ArrayList<String> hand1 = new ArrayList<>();
    static Stage stage=new Stage();
    public static String color;
    ObservableList<String> corpsize=FXCollections.observableArrayList();



    Label towersize=new Label("");
    Label festivalsize=new Label("");
    Label imperialsize=new Label("");
    Label continentalsize=new Label("");
    Label americansize=new Label("");
    Label sacksonsize=new Label("");
    Label worldwidesize=new Label("");

    Label player1towersize=new Label("");
    Label player1festivalsize=new Label("");
    Label player1imperialsize=new Label("");
    Label player1continentalsize=new Label("");
    Label player1americansize=new Label("");
    Label player1sacksonsize=new Label("");
    Label player1worldwidesize=new Label("");

    Label player2towersize=new Label("");
    Label player2festivalsize=new Label("");
    Label player2imperialsize=new Label("");
    Label player2continentalsize=new Label("");
    Label player2americansize=new Label("");
    Label player2sacksonsize=new Label("");
    Label player2worldwidesize=new Label("");

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

/*
        hand.add(gameBoard.drawTile());
        hand.add(gameBoard.drawTile());
        hand.add(gameBoard.drawTile());
        hand.add(gameBoard.drawTile());
        hand.add(gameBoard.drawTile());
        hand.add(gameBoard.drawTile());

 */


        hand.add("1A");


        hand.add("1B");
        hand.add("2A");

        hand.add("1C");



        gameBoard.getPlayer1().setHand(hand);

/*
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());
        hand1.add(gameBoard.drawTile());

 */


        hand1.add("1D");
        hand1.add("1E");




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

        buyselltrade.setLayoutX(1100);
        buyselltrade.setLayoutY(700);
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
        ObservableList<String> player1 = FXCollections.observableArrayList( "Name :"+gameBoard.getPlayer1().getName(),"Cash : $"+gameBoard.getPlayer1().getMoney(),"Stocks :");
        ObservableList<String> player2 = FXCollections.observableArrayList( "Name :"+gameBoard.getPlayer2().getName(),"Cash : $"+gameBoard.getPlayer2().getMoney(),"Stocks :");
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
            buyselltrade.setOnAction(event1 -> {buyselltradestock1();});
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

            buyselltrade.setOnAction(event1 -> {buyselltradestock2();});




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
        Label tower=new Label("\ttower\t");
        Label imperial=new Label("\t imperial\t\t");
        Label continental=new Label("\tcontinental\t");
        Label festival=new Label("\t  festival\t\t");
        Label sackson=new Label("\tsackson\t\t");
        Label american=new Label("\tamerican\t\t");
        Label worldwide=new Label("\tworldwide\t");

        tower.setStyle("-fx-background-color: red;");
        imperial.setStyle("-fx-background-color: orange;");
        continental.setStyle("-fx-background-color: purple;");
        festival.setStyle("-fx-background-color: blue;");
        sackson.setStyle("-fx-background-color: yellow;");
        american.setStyle("-fx-background-color: green;");
        worldwide.setStyle("-fx-background-color: teal;");

        info.setHgap(10);
        info.setVgap(10);
        info.setTranslateY(600);
        info.setTranslateX(60);
        info.add(tower,1,0);
        info.add(festival,2,0);
        info.add(imperial,3,0);
        info.add(continental,4,0);
        info.add(american,5,0);
        info.add(sackson,6,0);
        info.add(worldwide,7,0);
        //==================================================================================================================
        //==================================================================================================================
        Label player1name=new Label(gb.getPlayer1().getName()+" Stock");
        Label player2name=new Label(gb.getPlayer2().getName()+" Stock");
        Label size=new Label("Size");
        player1name.setFont(Font.font(20));
        player2name.setFont(Font.font(20));
        size.setFont(Font.font(20));
        info.add(player1name,0,1);
        info.add(player2name,0,2);
        info.add(size,0,3);


        group.getChildren().addAll(gridPane,label,info, listViewPlayer1, listViewPlayer2, place, placebutton, place1, placebutton1,player1Tile,player2Tile,listView1,listView2,buyselltrade);

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
                                    System.out.println(color);
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
                                    if(gridPane.getChildren().get(newList.get(0)).getStyle().equals("-fx-background-color:red")){towerintegertiles.add(s);}
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
                                else{merge2(newList,s);}
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
                                else{merge2(newList,s);}

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

                                else{merge3(newList,s);}

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
                                else{merge4(newList,s);}

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

        gb.tower.setSize(sizetower);
        gb.imperial.setSize(sizeimperial);
        gb.sackson.setSize(sizesackson);
        gb.festival.setSize(sizefestival);
        gb.american.setSize(sizeamerican);
        gb.worldwide.setSize(sizeworldwide);
        gb.continental.setSize(sizecontinental);


        towersize.setText("");
        festivalsize.setText("");
        continentalsize.setText("");
        imperialsize.setText("");
        americansize.setText("");
        sacksonsize.setText("");
        worldwidesize.setText("");

        player1towersize.setText("");
        player1festivalsize.setText("");
        player1continentalsize.setText("");
        player1imperialsize.setText("");
        player1americansize.setText("");
        player1sacksonsize.setText("");
        player1worldwidesize.setText("");

        player2towersize.setText("");
        player2festivalsize.setText("");
        player2continentalsize.setText("");
        player2imperialsize.setText("");
        player2americansize.setText("");
        player2sacksonsize.setText("");
        player2worldwidesize.setText("");


        towersize=new Label("     "+gb.tower.getSize());
        festivalsize=new Label("\t"+gb.festival.getSize().toString());
        imperialsize=new Label("\t"+gb.imperial.getSize().toString());
        continentalsize=new Label("\t"+gb.continental.getSize().toString());
        americansize=new Label("\t"+gb.american.getSize().toString());
        sacksonsize=new Label("\t"+gb.sackson.getSize().toString());
        worldwidesize=new Label("\t"+gb.worldwide.getSize().toString());
        towersize.setFont(Font.font(20));
        festivalsize.setFont(Font.font(20));
        imperialsize.setFont(Font.font(20));
        continentalsize.setFont(Font.font(20));
        americansize.setFont(Font.font(20));
        sacksonsize.setFont(Font.font(20));
        worldwidesize.setFont(Font.font(20));

        player1towersize=new Label("     "+gb.getPlayer1().getTowerStock());
        player1festivalsize=new Label("\t"+gb.getPlayer1().getFestivalStock());
        player1imperialsize=new Label("\t"+gb.getPlayer1().getImperialStock());
        player1continentalsize=new Label("\t"+gb.getPlayer1().getContinentalStock());
        player1americansize=new Label("\t"+gb.getPlayer1().getAmericanStock());
        player1sacksonsize=new Label("\t"+gb.getPlayer1().getSaxonStock());
        player1worldwidesize=new Label("\t"+gb.getPlayer1().getWorldwideStock());
        player1towersize.setFont(Font.font(20));
        player1festivalsize.setFont(Font.font(20));
        player1imperialsize.setFont(Font.font(20));
        player1continentalsize.setFont(Font.font(20));
        player1americansize.setFont(Font.font(20));
        player1sacksonsize.setFont(Font.font(20));
        player1worldwidesize.setFont(Font.font(20));

        player2towersize=new Label("     "+gb.getPlayer2().getTowerStock());
        player2festivalsize=new Label("\t"+gb.getPlayer2().getFestivalStock());
        player2imperialsize=new Label("\t"+gb.getPlayer2().getImperialStock());
        player2continentalsize=new Label("\t"+gb.getPlayer2().getContinentalStock());
        player2americansize=new Label("\t"+gb.getPlayer2().getAmericanStock());
        player2sacksonsize=new Label("\t"+gb.getPlayer2().getSaxonStock());
        player2worldwidesize=new Label("\t"+gb.getPlayer2().getWorldwideStock());
        player2towersize.setFont(Font.font(20));
        player2festivalsize.setFont(Font.font(20));
        player2imperialsize.setFont(Font.font(20));
        player2continentalsize.setFont(Font.font(20));
        player2americansize.setFont(Font.font(20));
        player2sacksonsize.setFont(Font.font(20));
        player2worldwidesize.setFont(Font.font(20));



        info.add(towersize,1,3);
        info.add(festivalsize,2,3);
        info.add(imperialsize,3,3);
        info.add(continentalsize,4,3);
        info.add(americansize,5,3);
        info.add(sacksonsize,6,3);
        info.add(worldwidesize,7,3);

        info.add(player1towersize,1,1);
        info.add(player1festivalsize,2,1);
        info.add(player1imperialsize,3,1);
        info.add(player1continentalsize,4,1);
        info.add(player1americansize,5,1);
        info.add(player1sacksonsize,6,1);
        info.add(player1worldwidesize,7,1);

        info.add(player2towersize,1,2);
        info.add(player2festivalsize,2,2);
        info.add(player2imperialsize,3,2);
        info.add(player2continentalsize,4,2);
        info.add(player2americansize,5,2);
        info.add(player2sacksonsize,6,2);
        info.add(player2worldwidesize,7,2);

        if(sizetower>41){group.getChildren().add(endgame);}
        if(sizecontinental>41){group.getChildren().add(endgame);}
        if(sizeamerican>41){group.getChildren().add(endgame);}
        if(sizesackson>41){group.getChildren().add(endgame);}
        if(sizeimperial>41){group.getChildren().add(endgame);}
        if(sizefestival>41){group.getChildren().add(endgame);}
        if(sizeworldwide>41){group.getChildren().add(endgame);}

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





















    public List<Integer> checktilemembership(Integer tile){
        if(towerintegertiles.contains(tile)){return towerintegertiles;}
        if(festivalintegertiles.contains(tile)){return festivalintegertiles;}
        if(continentalintegertiles.contains(tile)){return continentalintegertiles;}
        if(imperialintegertiles.contains(tile)){return imperialintegertiles;}
        if(sacksonintegertiles.contains(tile)){return sacksonintegertiles;}
        if(americanintegertiles.contains(tile)){return americanintegertiles;}
        if(worldwideintegertiles.contains(tile)){return worldwideintegertiles;}
        return null;
    }

    public String returncorporationforbutton(Integer tile){
        if(towerintegertiles.contains(tile)){return gb.tower.getName();}
        if(festivalintegertiles.contains(tile)){return gb.festival.getName();}
        if(continentalintegertiles.contains(tile)){return gb.continental.getName();}
        if(imperialintegertiles.contains(tile)){return gb.imperial.getName();}
        if(sacksonintegertiles.contains(tile)){return gb.sackson.getName();}
        if(americanintegertiles.contains(tile)){return gb.american.getName();}
        if(worldwideintegertiles.contains(tile)){return gb.worldwide.getName();}
        return null;
    }

    public void merge2(List<Integer> list,Integer tilenumber){
        setneighbor(list);
        if(checktilemembership(ttt.neghbor1).size()>checktilemembership(ttt.neghbor2).size()){
            gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
            checktilemembership(ttt.neghbor1).addAll(checktilemembership(ttt.neghbor2));
            checktilemembership(ttt.neghbor1).add(tilenumber);
            for(Integer num:checktilemembership(ttt.neghbor2)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
            }
            if (checktilemembership(ttt.neghbor2).size() > 0) {
                checktilemembership(ttt.neghbor2).subList(0,checktilemembership(ttt.neghbor2).size()).clear();
            }


        }
        if(checktilemembership(ttt.neghbor1).size()<checktilemembership(ttt.neghbor2).size()){
            gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
            checktilemembership(ttt.neghbor2).addAll(checktilemembership(ttt.neghbor1));
            checktilemembership(ttt.neghbor2).add(tilenumber);
            for(Integer num:checktilemembership(ttt.neghbor1)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
            }
            if (checktilemembership(ttt.neghbor1).size() > 0) {
                checktilemembership(ttt.neghbor1).subList(0,checktilemembership(ttt.neghbor1).size()).clear();
            }


        }
        /*
        if(checktilemembership(ttt.neghbor1).size()==checktilemembership(ttt.neghbor2).size()){
            Stage equal_2_corp=new Stage();
            corppick=new Label("Which corporation do you want to pick?");
            TextField putithere=new TextField();
            putithere.setLayoutX(500);
            optionforpickacorp1=new Button(returncorporationforbutton(ttt.neghbor1));
            //optionforpickacorp2=new Button(returncorporationforbutton(ttt.neghbor2));
            optionforpickacorp1.setOnAction(event -> {
                if (putithere.getText().equals(returncorporationforbutton(ttt.neghbor1))){
                    gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                    checktilemembership(ttt.neghbor1).addAll(checktilemembership(ttt.neghbor2));
                    checktilemembership(ttt.neghbor1).add(tilenumber);
                    for(Integer num:checktilemembership(ttt.neghbor2)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                    }
                    if (checktilemembership(ttt.neghbor2).size() > 0) {
                        checktilemembership(ttt.neghbor2).subList(0,checktilemembership(ttt.neghbor2).size()).clear();
                    }
                }
                else if(putithere.getText().equals(returncorporationforbutton(ttt.neghbor2))){
                    System.out.println(gridPane.getChildren().get(ttt.neghbor1).getStyle());

                    gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                    checktilemembership(ttt.neghbor2).addAll(checktilemembership(ttt.neghbor1));
                    checktilemembership(ttt.neghbor2).add(tilenumber);
                    for(Integer num:checktilemembership(ttt.neghbor1)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                    }
                    if (checktilemembership(ttt.neghbor1).size() > 0) {
                        checktilemembership(ttt.neghbor1).subList(0,checktilemembership(ttt.neghbor1).size()).clear();
                    }

                }

                equal_2_corp.close();



            });
        /*
        optionforpickacorp2.setOnAction(event -> {
            corpChoice = optionforpickacorp2.getText();
            System.out.println(corpChoice);

        });


            Group group=new Group(corppick,optionforpickacorp1,putithere);
            Scene scene=new Scene(group);
            equal_2_corp.setScene(scene);
            equal_2_corp.show();



        }

         */



    }

    public void merge3(List<Integer> list,Integer tilenumber){
        setneighbor(list);
        if(checktilemembership(ttt.neghbor1).size()>checktilemembership(ttt.neghbor2).size() && checktilemembership(ttt.neghbor1).size()>checktilemembership(ttt.neghbor3).size() ){
            gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
            checktilemembership(ttt.neghbor1).addAll(checktilemembership(ttt.neghbor2));
            checktilemembership(ttt.neghbor1).addAll(checktilemembership(ttt.neghbor3));
            checktilemembership(ttt.neghbor1).add(tilenumber);
            for(Integer num:checktilemembership(ttt.neghbor2)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
            }
            for(Integer num:checktilemembership(ttt.neghbor3)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
            }
            if (checktilemembership(ttt.neghbor2).size() > 0) {
                checktilemembership(ttt.neghbor2).subList(0,checktilemembership(ttt.neghbor2).size()).clear();
            }
            if (checktilemembership(ttt.neghbor3).size() > 0) {
                checktilemembership(ttt.neghbor3).subList(0,checktilemembership(ttt.neghbor3).size()).clear();
            }

            //checktilemembership(ttt.neghbor2).clear();
            //checktilemembership(ttt.neghbor3).clear();
        }
        if(checktilemembership(ttt.neghbor2).size()>checktilemembership(ttt.neghbor1).size() && checktilemembership(ttt.neghbor2).size()>checktilemembership(ttt.neghbor3).size() ){
            gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
            checktilemembership(ttt.neghbor2).addAll(checktilemembership(ttt.neghbor1));
            checktilemembership(ttt.neghbor2).addAll(checktilemembership(ttt.neghbor3));
            checktilemembership(ttt.neghbor2).add(tilenumber);
            for(Integer num:checktilemembership(ttt.neghbor1)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
            }
            for(Integer num:checktilemembership(ttt.neghbor3)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
            }
            if (checktilemembership(ttt.neghbor1).size() > 0) {
                checktilemembership(ttt.neghbor1).subList(0,checktilemembership(ttt.neghbor1).size()).clear();
            }
            if (checktilemembership(ttt.neghbor3).size() > 0) {
                checktilemembership(ttt.neghbor3).subList(0,checktilemembership(ttt.neghbor3).size()).clear();
            }
            //checktilemembership(ttt.neghbor1).clear();
            //checktilemembership(ttt.neghbor3).clear();
        }
        if(checktilemembership(ttt.neghbor3).size()>checktilemembership(ttt.neghbor1).size() && checktilemembership(ttt.neghbor3).size()>checktilemembership(ttt.neghbor2).size() ){
            gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
            checktilemembership(ttt.neghbor3).addAll(checktilemembership(ttt.neghbor1));
            checktilemembership(ttt.neghbor3).addAll(checktilemembership(ttt.neghbor2));
            checktilemembership(ttt.neghbor3).add(tilenumber);
            for(Integer num:checktilemembership(ttt.neghbor1)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
            }
            for(Integer num:checktilemembership(ttt.neghbor2)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
            }
            if (checktilemembership(ttt.neghbor1).size() > 0) {
                checktilemembership(ttt.neghbor1).subList(0,checktilemembership(ttt.neghbor1).size()).clear();
            }
            if (checktilemembership(ttt.neghbor2).size() > 0) {
                checktilemembership(ttt.neghbor2).subList(0,checktilemembership(ttt.neghbor2).size()).clear();
            }
        }
        /*if(checktilemembership(ttt.neghbor1).size()==checktilemembership(ttt.neghbor2).size() && checktilemembership(ttt.neghbor1).size()==checktilemembership(ttt.neghbor3).size()){
            Stage equal_2_corp=new Stage();
            corppick=new Label("Which corporation do you want to pick?");
            TextField putithere=new TextField();
            putithere.setLayoutX(500);
            optionforpickacorp1=new Button(returncorporationforbutton(ttt.neghbor1));
            //optionforpickacorp2=new Button(returncorporationforbutton(ttt.neghbor2));
            optionforpickacorp1.setOnAction(event -> {
                if (putithere.getText().equals(returncorporationforbutton(ttt.neghbor1))){
                    gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                    checktilemembership(ttt.neghbor1).addAll(checktilemembership(ttt.neghbor2));
                    checktilemembership(ttt.neghbor1).addAll(checktilemembership(ttt.neghbor3));
                    checktilemembership(ttt.neghbor1).add(tilenumber);
                    for(Integer num:checktilemembership(ttt.neghbor2)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                    }
                    for(Integer num:checktilemembership(ttt.neghbor3)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                    }
                    if (checktilemembership(ttt.neghbor2).size() > 0) {
                        checktilemembership(ttt.neghbor2).subList(0,checktilemembership(ttt.neghbor2).size()).clear();
                    }
                    if (checktilemembership(ttt.neghbor3).size() > 0) {
                        checktilemembership(ttt.neghbor3).subList(0,checktilemembership(ttt.neghbor3).size()).clear();
                    }
                }
                else if(putithere.getText().equals(returncorporationforbutton(ttt.neghbor2))){
                    gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                    checktilemembership(ttt.neghbor2).addAll(checktilemembership(ttt.neghbor1));
                    checktilemembership(ttt.neghbor2).addAll(checktilemembership(ttt.neghbor3));
                    checktilemembership(ttt.neghbor2).add(tilenumber);
                    for(Integer num:checktilemembership(ttt.neghbor1)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                    }
                    for(Integer num:checktilemembership(ttt.neghbor3)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                    }
                    if (checktilemembership(ttt.neghbor1).size() > 0) {
                        checktilemembership(ttt.neghbor1).subList(0,checktilemembership(ttt.neghbor1).size()).clear();
                    }
                    if (checktilemembership(ttt.neghbor3).size() > 0) {
                        checktilemembership(ttt.neghbor3).subList(0,checktilemembership(ttt.neghbor3).size()).clear();
                    }

                }
                else if(putithere.getText().equals(returncorporationforbutton(ttt.neghbor3))){
                    gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                    checktilemembership(ttt.neghbor3).addAll(checktilemembership(ttt.neghbor1));
                    checktilemembership(ttt.neghbor3).addAll(checktilemembership(ttt.neghbor2));
                    checktilemembership(ttt.neghbor3).add(tilenumber);
                    for(Integer num:checktilemembership(ttt.neghbor1)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                    }
                    for(Integer num:checktilemembership(ttt.neghbor2)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                    }
                    if (checktilemembership(ttt.neghbor1).size() > 0) {
                        checktilemembership(ttt.neghbor1).subList(0,checktilemembership(ttt.neghbor1).size()).clear();
                    }
                    if (checktilemembership(ttt.neghbor2).size() > 0) {
                        checktilemembership(ttt.neghbor2).subList(0,checktilemembership(ttt.neghbor2).size()).clear();
                    }
                }

                equal_2_corp.close();



            });

        }

         */
    }
    public void merge4(List<Integer> list,Integer tilenumber){
        setneighbor(list);
        if(checktilemembership(ttt.neghbor1).size()>checktilemembership(ttt.neghbor2).size() && checktilemembership(ttt.neghbor1).size()>checktilemembership(ttt.neghbor3).size() && checktilemembership(ttt.neghbor1).size()>checktilemembership(ttt.neghbor4).size()){
            gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
            checktilemembership(ttt.neghbor1).addAll(checktilemembership(ttt.neghbor2));
            checktilemembership(ttt.neghbor1).addAll(checktilemembership(ttt.neghbor3));
            checktilemembership(ttt.neghbor1).addAll(checktilemembership(ttt.neghbor4));
            checktilemembership(ttt.neghbor1).add(tilenumber);
            for(Integer num:checktilemembership(ttt.neghbor2)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
            }
            for(Integer num:checktilemembership(ttt.neghbor3)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
            }
            for(Integer num:checktilemembership(ttt.neghbor4)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
            }

            if (checktilemembership(ttt.neghbor2).size() > 0) {
                checktilemembership(ttt.neghbor2).subList(0,checktilemembership(ttt.neghbor2).size()).clear();
            }
            if (checktilemembership(ttt.neghbor3).size() > 0) {
                checktilemembership(ttt.neghbor3).subList(0,checktilemembership(ttt.neghbor3).size()).clear();
            }
            if (checktilemembership(ttt.neghbor4).size() > 0) {
                checktilemembership(ttt.neghbor4).subList(0,checktilemembership(ttt.neghbor4).size()).clear();
            }
            //checktilemembership(ttt.neghbor2).clear();
            //checktilemembership(ttt.neghbor3).clear();
        }
        if(checktilemembership(ttt.neghbor2).size()>checktilemembership(ttt.neghbor1).size() && checktilemembership(ttt.neghbor2).size()>checktilemembership(ttt.neghbor3).size() &&checktilemembership(ttt.neghbor2).size()>checktilemembership(ttt.neghbor4).size() ){
            gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
            checktilemembership(ttt.neghbor2).addAll(checktilemembership(ttt.neghbor1));
            checktilemembership(ttt.neghbor2).addAll(checktilemembership(ttt.neghbor3));
            checktilemembership(ttt.neghbor2).addAll(checktilemembership(ttt.neghbor4));
            checktilemembership(ttt.neghbor2).add(tilenumber);
            for(Integer num:checktilemembership(ttt.neghbor1)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
            }
            for(Integer num:checktilemembership(ttt.neghbor3)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
            }
            for(Integer num:checktilemembership(ttt.neghbor4)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
            }

            if (checktilemembership(ttt.neghbor1).size() > 0) {
                checktilemembership(ttt.neghbor1).subList(0,checktilemembership(ttt.neghbor1).size()).clear();
            }
            if (checktilemembership(ttt.neghbor3).size() > 0) {
                checktilemembership(ttt.neghbor3).subList(0,checktilemembership(ttt.neghbor3).size()).clear();
            }
            if (checktilemembership(ttt.neghbor4).size() > 0) {
                checktilemembership(ttt.neghbor4).subList(0,checktilemembership(ttt.neghbor4).size()).clear();
            }
            //checktilemembership(ttt.neghbor1).clear();
            //checktilemembership(ttt.neghbor3).clear();
            //checktilemembership(ttt.neghbor4).clear();
        }
        if(checktilemembership(ttt.neghbor3).size()>checktilemembership(ttt.neghbor1).size() && checktilemembership(ttt.neghbor3).size()>checktilemembership(ttt.neghbor2).size() && checktilemembership(ttt.neghbor3).size()>checktilemembership(ttt.neghbor4).size() ){
            gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
            checktilemembership(ttt.neghbor3).addAll(checktilemembership(ttt.neghbor1));
            checktilemembership(ttt.neghbor3).addAll(checktilemembership(ttt.neghbor2));
            checktilemembership(ttt.neghbor3).addAll(checktilemembership(ttt.neghbor4));
            checktilemembership(ttt.neghbor3).add(tilenumber);
            for(Integer num:checktilemembership(ttt.neghbor1)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
            }
            for(Integer num:checktilemembership(ttt.neghbor2)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
            }
            for(Integer num:checktilemembership(ttt.neghbor4)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
            }

            if (checktilemembership(ttt.neghbor1).size() > 0) {
                checktilemembership(ttt.neghbor1).subList(0,checktilemembership(ttt.neghbor1).size()).clear();
            }
            if (checktilemembership(ttt.neghbor2).size() > 0) {
                checktilemembership(ttt.neghbor2).subList(0,checktilemembership(ttt.neghbor2).size()).clear();
            }
            if (checktilemembership(ttt.neghbor4).size() > 0) {
                checktilemembership(ttt.neghbor4).subList(0,checktilemembership(ttt.neghbor4).size()).clear();
            }
            //checktilemembership(ttt.neghbor1).clear();
            //checktilemembership(ttt.neghbor2).clear();
            //checktilemembership(ttt.neghbor4).clear();
        }
        if(checktilemembership(ttt.neghbor4).size()>checktilemembership(ttt.neghbor1).size() && checktilemembership(ttt.neghbor4).size()>checktilemembership(ttt.neghbor2).size() && checktilemembership(ttt.neghbor4).size()>checktilemembership(ttt.neghbor3).size() ){
            gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
            checktilemembership(ttt.neghbor4).addAll(checktilemembership(ttt.neghbor1));
            checktilemembership(ttt.neghbor4).addAll(checktilemembership(ttt.neghbor2));
            checktilemembership(ttt.neghbor4).addAll(checktilemembership(ttt.neghbor3));
            checktilemembership(ttt.neghbor4).add(tilenumber);
            for(Integer num:checktilemembership(ttt.neghbor1)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
            }
            for(Integer num:checktilemembership(ttt.neghbor2)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
            }
            for(Integer num:checktilemembership(ttt.neghbor3)){
                gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
            }

            if (checktilemembership(ttt.neghbor1).size() > 0) {
                checktilemembership(ttt.neghbor1).subList(0,checktilemembership(ttt.neghbor1).size()).clear();
            }
            if (checktilemembership(ttt.neghbor2).size() > 0) {
                checktilemembership(ttt.neghbor2).subList(0,checktilemembership(ttt.neghbor2).size()).clear();
            }
            if (checktilemembership(ttt.neghbor3).size() > 0) {
                checktilemembership(ttt.neghbor3).subList(0,checktilemembership(ttt.neghbor3).size()).clear();
            }

        }
        /*
        if(checktilemembership(ttt.neghbor4).size()==checktilemembership(ttt.neghbor1).size() && checktilemembership(ttt.neghbor4).size()==checktilemembership(ttt.neghbor2).size() && checktilemembership(ttt.neghbor4).size()==checktilemembership(ttt.neghbor3).size() ){
            Stage equal_2_corp=new Stage();
            corppick=new Label("Which corporation do you want to pick?");
            TextField putithere=new TextField();
            putithere.setLayoutX(500);
            optionforpickacorp1=new Button(returncorporationforbutton(ttt.neghbor1));
            //optionforpickacorp2=new Button(returncorporationforbutton(ttt.neghbor2));
            optionforpickacorp1.setOnAction(event -> {
                if (putithere.getText().equals(returncorporationforbutton(ttt.neghbor1))){
                    gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                    checktilemembership(ttt.neghbor1).addAll(checktilemembership(ttt.neghbor2));
                    checktilemembership(ttt.neghbor1).addAll(checktilemembership(ttt.neghbor3));
                    checktilemembership(ttt.neghbor1).addAll(checktilemembership(ttt.neghbor4));
                    checktilemembership(ttt.neghbor1).add(tilenumber);
                    for(Integer num:checktilemembership(ttt.neghbor2)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                    }
                    for(Integer num:checktilemembership(ttt.neghbor3)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                    }
                    for(Integer num:checktilemembership(ttt.neghbor4)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                    }

                    if (checktilemembership(ttt.neghbor2).size() > 0) {
                        checktilemembership(ttt.neghbor2).subList(0,checktilemembership(ttt.neghbor2).size()).clear();
                    }
                    if (checktilemembership(ttt.neghbor3).size() > 0) {
                        checktilemembership(ttt.neghbor3).subList(0,checktilemembership(ttt.neghbor3).size()).clear();
                    }
                    if (checktilemembership(ttt.neghbor4).size() > 0) {
                        checktilemembership(ttt.neghbor4).subList(0,checktilemembership(ttt.neghbor4).size()).clear();
                    }
                }
                else if(putithere.getText().equals(returncorporationforbutton(ttt.neghbor2))){
                    gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                    checktilemembership(ttt.neghbor2).addAll(checktilemembership(ttt.neghbor1));
                    checktilemembership(ttt.neghbor2).addAll(checktilemembership(ttt.neghbor3));
                    checktilemembership(ttt.neghbor2).addAll(checktilemembership(ttt.neghbor4));
                    checktilemembership(ttt.neghbor2).add(tilenumber);
                    for(Integer num:checktilemembership(ttt.neghbor1)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                    }
                    for(Integer num:checktilemembership(ttt.neghbor3)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                    }
                    for(Integer num:checktilemembership(ttt.neghbor4)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                    }

                    if (checktilemembership(ttt.neghbor1).size() > 0) {
                        checktilemembership(ttt.neghbor1).subList(0,checktilemembership(ttt.neghbor1).size()).clear();
                    }
                    if (checktilemembership(ttt.neghbor3).size() > 0) {
                        checktilemembership(ttt.neghbor3).subList(0,checktilemembership(ttt.neghbor3).size()).clear();
                    }
                    if (checktilemembership(ttt.neghbor4).size() > 0) {
                        checktilemembership(ttt.neghbor4).subList(0,checktilemembership(ttt.neghbor4).size()).clear();
                    }

                }
                else if(putithere.getText().equals(returncorporationforbutton(ttt.neghbor3))){
                    gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                    checktilemembership(ttt.neghbor3).addAll(checktilemembership(ttt.neghbor1));
                    checktilemembership(ttt.neghbor3).addAll(checktilemembership(ttt.neghbor2));
                    checktilemembership(ttt.neghbor3).addAll(checktilemembership(ttt.neghbor4));
                    checktilemembership(ttt.neghbor3).add(tilenumber);
                    for(Integer num:checktilemembership(ttt.neghbor1)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                    }
                    for(Integer num:checktilemembership(ttt.neghbor2)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                    }
                    for(Integer num:checktilemembership(ttt.neghbor4)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor3).getStyle());
                    }

                    if (checktilemembership(ttt.neghbor1).size() > 0) {
                        checktilemembership(ttt.neghbor1).subList(0,checktilemembership(ttt.neghbor1).size()).clear();
                    }
                    if (checktilemembership(ttt.neghbor2).size() > 0) {
                        checktilemembership(ttt.neghbor2).subList(0,checktilemembership(ttt.neghbor2).size()).clear();
                    }
                    if (checktilemembership(ttt.neghbor4).size() > 0) {
                        checktilemembership(ttt.neghbor4).subList(0,checktilemembership(ttt.neghbor4).size()).clear();
                    }
                }
                else if(putithere.getText().equals(returncorporationforbutton(ttt.neghbor2))){
                    gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
                    checktilemembership(ttt.neghbor4).addAll(checktilemembership(ttt.neghbor1));
                    checktilemembership(ttt.neghbor4).addAll(checktilemembership(ttt.neghbor2));
                    checktilemembership(ttt.neghbor4).addAll(checktilemembership(ttt.neghbor3));
                    checktilemembership(ttt.neghbor4).add(tilenumber);
                    for(Integer num:checktilemembership(ttt.neghbor1)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
                    }
                    for(Integer num:checktilemembership(ttt.neghbor2)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
                    }
                    for(Integer num:checktilemembership(ttt.neghbor3)){
                        gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor4).getStyle());
                    }

                    if (checktilemembership(ttt.neghbor1).size() > 0) {
                        checktilemembership(ttt.neghbor1).subList(0,checktilemembership(ttt.neghbor1).size()).clear();
                    }
                    if (checktilemembership(ttt.neghbor2).size() > 0) {
                        checktilemembership(ttt.neghbor2).subList(0,checktilemembership(ttt.neghbor2).size()).clear();
                    }
                    if (checktilemembership(ttt.neghbor3).size() > 0) {
                        checktilemembership(ttt.neghbor3).subList(0,checktilemembership(ttt.neghbor3).size()).clear();
                    }
                }

                equal_2_corp.close();



            });
        }

         */
    }
    public void updateplayerhand(ObservableList<String> list, ArrayList<String> handslist,String tile){
        String randtile1=gb.drawTile();
        handslist.remove(tile);
        handslist.add(randtile1);
        list.remove(tile);
        list.add(randtile1);
    }

    public void buyselltradestock1(){
        Stage primaryStage=new Stage();
        primaryStage.setTitle("http://java-buddy.blogspot.com/");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 300, Color.WHITE);

        TabPane tabPane = new TabPane();
        BorderPane mainPane = new BorderPane();

        //Create Tabs
        Tab tabA = new Tab();
        tabA.setText("Buy Stock");

        //Add something in Tab
        Button buy = new Button("Buy");
        Label stockname=new Label("Name of the Stock");
        Label stocknumber=new Label("Number of the Stock");
        ObservableList<String> corps = FXCollections.observableArrayList(gb.tower.getName(),gb.festival.getName(),gb.imperial.getName(),gb.sackson.getName(),gb.continental.getName(),gb.worldwide.getName(),gb.american.getName());

        Spinner<String> name=new Spinner<>();
        SpinnerValueFactory<String> valueFactory=new SpinnerValueFactory.ListSpinnerValueFactory<>(corps);
        name.setValueFactory(valueFactory);
        Spinner<Integer> number=new Spinner<>(0,10,0);
        VBox buyvbox=new VBox();
        buyvbox.getChildren().addAll(buy,stockname,name,stocknumber,number);
        buyvbox.getChildren().get(0).setTranslateY(200);
        buyvbox.getChildren().get(0).setTranslateX(20);
        buyvbox.getChildren().get(3).setTranslateY(30);
        buyvbox.getChildren().get(4).setTranslateY(30);
        tabPane.getTabs().add(tabA);
        tabA.setContent(buyvbox);


        buy.setOnAction(event -> {
            //new Stock_Market().buyStock(gb.getPlayer1(),name.getValue());
        });



        Tab tabB = new Tab();
        tabB.setText("Sell Stock");
        Button sell = new Button("Sell");
        Label stocknameforsell=new Label("Name of the Stock");
        Label stocknumberforsell=new Label("Number of the Stock");

        ObservableList<String> sellname = FXCollections.observableArrayList("Tower", "Festival", "Continental", "Imperial","Sackson", "America", "Worldwide");
        Spinner<String> nameofsell=new Spinner<>();
        SpinnerValueFactory<String> valueFactoryofsell=new SpinnerValueFactory.ListSpinnerValueFactory<>(sellname);
        nameofsell.setValueFactory(valueFactoryofsell);
        Spinner<Integer> numberofsell=new Spinner<>(0,10,0);

        VBox sellvbox=new VBox();
        sellvbox.getChildren().addAll(sell,stocknameforsell,nameofsell,stocknumberforsell,numberofsell);
        sellvbox.getChildren().get(0).setTranslateY(200);
        sellvbox.getChildren().get(0).setTranslateX(20);
        sellvbox.getChildren().get(3).setTranslateY(30);
        sellvbox.getChildren().get(4).setTranslateY(30);
        tabB.setContent(sellvbox);
        tabPane.getTabs().add(tabB);



        sell.setOnAction(event -> {
            //new Stock_Market().sellStock(gb.getPlayer1(),name.getValue());
        });





        Tab tabC = new Tab();
        tabC.setText("Trade Stock");
        Button trade=new Button("Trade");
        Label stocknameforstrade=new Label("Name of the Stock");
        Label stocknameforstrade1=new Label("Name of the Stock you want to trade");
        Label stocknumberfortrade=new Label("Number of the Stock");
        Label stocknumberfortrade1=new Label("Number of the Stock you want to trade");

        ObservableList<String> tradename = FXCollections.observableArrayList("Tower", "Festival", "Continental", "Imperial","Sackson", "America", "Worldwide");
        Spinner<String> nameoftrade=new Spinner<>();
        SpinnerValueFactory<String> valueFactoryoftrade=new SpinnerValueFactory.ListSpinnerValueFactory<>(tradename);
        nameoftrade.setValueFactory(valueFactoryoftrade);
        ObservableList<String> tradename1 = FXCollections.observableArrayList("Tower", "Festival", "Continental", "Imperial","Sackson", "America", "Worldwide");
        Spinner<String> nameoftrade1=new Spinner<>();
        SpinnerValueFactory<String> valueFactoryoftrade1=new SpinnerValueFactory.ListSpinnerValueFactory<>(tradename1);
        nameoftrade1.setValueFactory(valueFactoryoftrade1);
        Spinner<Integer> numberoftrade=new Spinner<>(0,10,0);
        Spinner<Integer> numberoftrade1=new Spinner<>(0,10,0);

        VBox tradevbox = new VBox();
        tradevbox.getChildren().addAll(trade,stocknameforstrade,nameoftrade,stocknameforstrade1,nameoftrade1,stocknumberfortrade,numberoftrade,stocknumberfortrade1,numberoftrade1);
        tabC.setContent(tradevbox);
        tabPane.getTabs().add(tabC);
        tradevbox.getChildren().get(0).setTranslateY(230);
        tradevbox.getChildren().get(0).setTranslateX(30);



        tradevbox.getChildren().get(3).setTranslateY(-42);
        tradevbox.getChildren().get(3).setTranslateX(230);
        tradevbox.getChildren().get(4).setTranslateY(-42);
        tradevbox.getChildren().get(4).setTranslateX(230);

        tradevbox.getChildren().get(7).setTranslateY(-42);
        tradevbox.getChildren().get(7).setTranslateX(230);
        tradevbox.getChildren().get(8).setTranslateY(-42);
        tradevbox.getChildren().get(8).setTranslateX(230);




        trade.setOnAction(event -> {
        //    new Stock_Market().tradeStock(gb.getPlayer1(),nameoftrade.getValue(),nameoftrade1.getValue());
        });





        tabA.setClosable(false);
        tabB.setClosable(false);
        tabC.setClosable(false);



        mainPane.setCenter(tabPane);

        mainPane.prefHeightProperty().bind(scene.heightProperty());
        mainPane.prefWidthProperty().bind(scene.widthProperty());

        root.getChildren().add(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void buyselltradestock2(){
        Stage primaryStage=new Stage();
        primaryStage.setTitle("http://java-buddy.blogspot.com/");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 300, Color.WHITE);

        TabPane tabPane = new TabPane();
        BorderPane mainPane = new BorderPane();

        //Create Tabs
        Tab tabA = new Tab();
        tabA.setText("Buy Stock");

        //Add something in Tab
        Button buy = new Button("Buy");
        Label stockname=new Label("Name of the Stock");
        Label stocknumber=new Label("Number of the Stock");
        ObservableList<String> corps = FXCollections.observableArrayList(gb.tower.getName(),gb.festival.getName(),gb.imperial.getName(),gb.sackson.getName(),gb.continental.getName(),gb.worldwide.getName(),gb.american.getName());

        Spinner<String> name=new Spinner<>();
        SpinnerValueFactory<String> valueFactory=new SpinnerValueFactory.ListSpinnerValueFactory<>(corps);
        name.setValueFactory(valueFactory);
        Spinner<Integer> number=new Spinner<>(0,10,0);
        VBox buyvbox=new VBox();
        buyvbox.getChildren().addAll(buy,stockname,name,stocknumber,number);
        buyvbox.getChildren().get(0).setTranslateY(200);
        buyvbox.getChildren().get(0).setTranslateX(20);
        buyvbox.getChildren().get(3).setTranslateY(30);
        buyvbox.getChildren().get(4).setTranslateY(30);
        tabPane.getTabs().add(tabA);
        tabA.setContent(buyvbox);


        buy.setOnAction(event -> {
            //new Stock_Market().buyStock(gb.getPlayer1(),name.getValue());
        });



        Tab tabB = new Tab();
        tabB.setText("Sell Stock");
        Button sell = new Button("Sell");
        Label stocknameforsell=new Label("Name of the Stock");
        Label stocknumberforsell=new Label("Number of the Stock");

        ObservableList<String> sellname = FXCollections.observableArrayList("Tower", "Festival", "Continental", "Imperial","Sackson", "America", "Worldwide");
        Spinner<String> nameofsell=new Spinner<>();
        SpinnerValueFactory<String> valueFactoryofsell=new SpinnerValueFactory.ListSpinnerValueFactory<>(sellname);
        nameofsell.setValueFactory(valueFactoryofsell);
        Spinner<Integer> numberofsell=new Spinner<>(0,10,0);

        VBox sellvbox=new VBox();
        sellvbox.getChildren().addAll(sell,stocknameforsell,nameofsell,stocknumberforsell,numberofsell);
        sellvbox.getChildren().get(0).setTranslateY(200);
        sellvbox.getChildren().get(0).setTranslateX(20);
        sellvbox.getChildren().get(3).setTranslateY(30);
        sellvbox.getChildren().get(4).setTranslateY(30);
        tabB.setContent(sellvbox);
        tabPane.getTabs().add(tabB);



        sell.setOnAction(event -> {
            //new Stock_Market().sellStock(gb.getPlayer1(),name.getValue());
        });





        Tab tabC = new Tab();
        tabC.setText("Trade Stock");
        Button trade=new Button("Trade");
        Label stocknameforstrade=new Label("Name of the Stock");
        Label stocknameforstrade1=new Label("Name of the Stock you want to trade");
        Label stocknumberfortrade=new Label("Number of the Stock");
        Label stocknumberfortrade1=new Label("Number of the Stock you want to trade");

        ObservableList<String> tradename = FXCollections.observableArrayList("Tower", "Festival", "Continental", "Imperial","Sackson", "America", "Worldwide");
        Spinner<String> nameoftrade=new Spinner<>();
        SpinnerValueFactory<String> valueFactoryoftrade=new SpinnerValueFactory.ListSpinnerValueFactory<>(tradename);
        nameoftrade.setValueFactory(valueFactoryoftrade);
        ObservableList<String> tradename1 = FXCollections.observableArrayList("Tower", "Festival", "Continental", "Imperial","Sackson", "America", "Worldwide");
        Spinner<String> nameoftrade1=new Spinner<>();
        SpinnerValueFactory<String> valueFactoryoftrade1=new SpinnerValueFactory.ListSpinnerValueFactory<>(tradename1);
        nameoftrade1.setValueFactory(valueFactoryoftrade1);
        Spinner<Integer> numberoftrade=new Spinner<>(0,10,0);
        Spinner<Integer> numberoftrade1=new Spinner<>(0,10,0);

        VBox tradevbox = new VBox();
        tradevbox.getChildren().addAll(trade,stocknameforstrade,nameoftrade,stocknameforstrade1,nameoftrade1,stocknumberfortrade,numberoftrade,stocknumberfortrade1,numberoftrade1);
        tabC.setContent(tradevbox);
        tabPane.getTabs().add(tabC);
        tradevbox.getChildren().get(0).setTranslateY(230);
        tradevbox.getChildren().get(0).setTranslateX(30);



        tradevbox.getChildren().get(3).setTranslateY(-42);
        tradevbox.getChildren().get(3).setTranslateX(230);
        tradevbox.getChildren().get(4).setTranslateY(-42);
        tradevbox.getChildren().get(4).setTranslateX(230);

        tradevbox.getChildren().get(7).setTranslateY(-42);
        tradevbox.getChildren().get(7).setTranslateX(230);
        tradevbox.getChildren().get(8).setTranslateY(-42);
        tradevbox.getChildren().get(8).setTranslateX(230);




        trade.setOnAction(event -> {
            //    new Stock_Market().tradeStock(gb.getPlayer1(),nameoftrade.getValue(),nameoftrade1.getValue());
        });





        tabA.setClosable(false);
        tabB.setClosable(false);
        tabC.setClosable(false);



        mainPane.setCenter(tabPane);

        mainPane.prefHeightProperty().bind(scene.heightProperty());
        mainPane.prefWidthProperty().bind(scene.widthProperty());

        root.getChildren().add(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }











    public void merg2equal(Integer tilenumber){
        Stage equal_2_corp=new Stage();
        corppick=new Label("Which corporation do you want to pick?");
        TextField putithere=new TextField();
        putithere.setLayoutX(500);
        optionforpickacorp1=new Button(returncorporationforbutton(ttt.neghbor1));
        //optionforpickacorp2=new Button(returncorporationforbutton(ttt.neghbor2));
        optionforpickacorp1.setOnAction(event -> {
            System.out.println(putithere.getText());
            System.out.println(returncorporationforbutton(ttt.neghbor1));
            if (putithere.getText() == returncorporationforbutton(ttt.neghbor1)){
                gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                checktilemembership(ttt.neghbor1).addAll(checktilemembership(ttt.neghbor2));
                checktilemembership(ttt.neghbor1).add(tilenumber);
                for(Integer num:checktilemembership(ttt.neghbor2)){
                    gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                }
                if (checktilemembership(ttt.neghbor2).size() > 0) {
                    checktilemembership(ttt.neghbor2).subList(0,checktilemembership(ttt.neghbor2).size()).clear();
                }
            }
            else if(putithere.getText() == returncorporationforbutton(ttt.neghbor2)){
                gridPane.getChildren().get(tilenumber).setStyle(gridPane.getChildren().get(ttt.neghbor1).getStyle());
                checktilemembership(ttt.neghbor2).addAll(checktilemembership(ttt.neghbor1));
                checktilemembership(ttt.neghbor2).add(tilenumber);
                for(Integer num:checktilemembership(ttt.neghbor1)){
                    gridPane.getChildren().get(num).setStyle(gridPane.getChildren().get(ttt.neghbor2).getStyle());
                }
                if (checktilemembership(ttt.neghbor1).size() > 0) {
                    checktilemembership(ttt.neghbor1).subList(0,checktilemembership(ttt.neghbor1).size()).clear();
                }

            }
            equal_2_corp.close();



        });
        /*
        optionforpickacorp2.setOnAction(event -> {
            corpChoice = optionforpickacorp2.getText();
            System.out.println(corpChoice);

        });

         */
        Group group=new Group(corppick,optionforpickacorp1,putithere);
        Scene scene=new Scene(group);
        equal_2_corp.setScene(scene);
        equal_2_corp.show();


    }


    public void merg3equal(){
        Stage equal_2_corp=new Stage();
        corppick=new Label("Which corporation do you want to pick?");
        optionforpickacorp1=new Button(returncorporationforbutton(ttt.neghbor1));
        optionforpickacorp2=new Button(returncorporationforbutton(ttt.neghbor2));
        optionforpickacorp3=new Button(returncorporationforbutton(ttt.neghbor3));
        optionforpickacorp1.setOnAction(event -> {
            optionforpickacorp1.getText();
        });
        optionforpickacorp2.setOnAction(event -> {
            optionforpickacorp2.getText();
        });
        optionforpickacorp3.setOnAction(event -> {
            optionforpickacorp2.getText();
        });
        Group group=new Group(corppick,optionforpickacorp1,optionforpickacorp2,optionforpickacorp3);
        Scene scene=new Scene(group);
        equal_2_corp.setScene(scene);
        equal_2_corp.show();


    }
    public void merg4equal(){
        Stage equal_2_corp=new Stage();
        corppick=new Label("Which corporation do you want to pick?");
        optionforpickacorp1=new Button(returncorporationforbutton(ttt.neghbor1));
        optionforpickacorp2=new Button(returncorporationforbutton(ttt.neghbor2));
        optionforpickacorp3=new Button(returncorporationforbutton(ttt.neghbor3));
        optionforpickacorp4=new Button(returncorporationforbutton(ttt.neghbor4));
        optionforpickacorp1.setOnAction(event -> {
            optionforpickacorp1.getText();
        });
        optionforpickacorp2.setOnAction(event -> {
            optionforpickacorp2.getText();
        });
        optionforpickacorp3.setOnAction(event -> {
            optionforpickacorp3.getText();
        });
        optionforpickacorp4.setOnAction(event -> {
            optionforpickacorp4.getText();
        });
        Group group=new Group(corppick,optionforpickacorp1,optionforpickacorp2,optionforpickacorp3,optionforpickacorp4);
        Scene scene=new Scene(group);
        equal_2_corp.setScene(scene);
        equal_2_corp.show();


    }
}


