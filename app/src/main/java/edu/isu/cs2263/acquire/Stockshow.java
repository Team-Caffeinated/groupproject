package edu.isu.cs2263.acquire;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.stage.Stage;

/**
 *
 * @web http://java-buddy.blogspot.com/
 */
public class Stockshow extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
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


        ObservableList<String> corps = FXCollections.observableArrayList("Tower", "Festival", "Continental", "Imperial","Sackson", "America", "Worldwide");

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
            System.out.println(nameofsell.getValue());
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
}