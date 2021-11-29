package edu.isu.cs2263.acquire;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Window1 extends Application {
    static String color;
    private final ComboBox mComboBox=new ComboBox();

    String selectedItem;

    static GameBoard gb=new GameBoard();
    public static final Label valueLabel = new Label();
    static ObservableList<String> jvmChoices = FXCollections.observableArrayList(gb.lisrofCorp().remove(0).getName(),gb.lisrofCorp().remove(0).getName(),gb.lisrofCorp().remove(0).getName(),gb.lisrofCorp().remove(0).getName(), gb.lisrofCorp().remove(0).getName(),gb.lisrofCorp().remove(0).getName(), gb.lisrofCorp().remove(0).getName());
    Button button=new Button("Select Your Corporation");
    //static VBox contentVBox = new VBox();
    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        button.setLayoutX(100);
        button.setLayoutY(100);

        populatedata();
        handleSelection();


        Group group=new Group(button,mComboBox);
        Scene scene=new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
/*
    static void showJvmLangsChoiceBox() {
        contentVBox.getChildren().clear();
        var jvmLangsChoiceBox = new ChoiceBox<String>(jvmChoices);
        valueLabel.textProperty().bind(jvmLangsChoiceBox.valueProperty());
        contentVBox.getChildren().add(new HBox(10, new Label("ChoiceBox<String> JVM Languages"), jvmLangsChoiceBox, valueLabel));
    }

    public void getchoice(){
        for(Corporation s: gb.lisrofCorp())
        if(valueLabel.getText().equals(s.getName())){
            color=s.getColor();
            button.setStyle("-fx-background-color: "+color);

        }

    }

 */


    public void populatedata(){
        List<String> nebulas = Arrays.asList(gb.lisrofCorp().remove(0).getName(),gb.lisrofCorp().remove(0).getName(),gb.lisrofCorp().remove(0).getName(),gb.lisrofCorp().remove(0).getName(), gb.lisrofCorp().remove(0).getName(),gb.lisrofCorp().remove(0).getName(), gb.lisrofCorp().remove(0).getName());
        for (String nebular : nebulas)
        {
            mComboBox.getItems().add(nebular);
        }
        mComboBox.setValue("Select Item From ComboBox");
    }
    private void handleSelection() {
        mComboBox.setOnAction(event -> {
            selectedItem = mComboBox.getSelectionModel().getSelectedItem().toString();
            for(Corporation co:gb.lisrofCorp()){
                if(selectedItem.equals(co.getName())){
            System.out.println(mComboBox.getSelectionModel().getSelectedItem());}}
        });

    }
}
