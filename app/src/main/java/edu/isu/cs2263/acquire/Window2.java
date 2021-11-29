package edu.isu.cs2263.acquire;

import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Window2 extends Application {
    String selectedItem;
    Button button=new Button("oh yeah click me");

    private final ComboBox mComboBox=new ComboBox();
    GameBoard gb=new GameBoard();
    /*
    The main entry point for all JavaFX applications. We pass the applications primary Stage
     */
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("JavaFX ComboBox - Fill From List");
        stage.setWidth(550);
        stage.setHeight(550);

        Label titleLabel = new Label("List of Nebulas");
        titleLabel.setFont(new Font("Lucida", 20));

        populateData();
        handleSelection();

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(titleLabel, mComboBox,button);
        vbox.setAlignment(Pos.CENTER);

        Group group=((Group) scene.getRoot());
        group.getChildren().addAll(vbox);
        group.setLayoutX(100);

        stage.setScene(scene);
        stage.show();
    }

    private void populateData()
    {
        List<String> nebulas = Arrays.asList(gb.american.getName(),gb.festival.getName());
        //Pass our source to fromIterable() method. Then subscribe thae consumer to the source.
        for (String nebular : nebulas)
        {
            mComboBox.getItems().add(nebular);
        }
        mComboBox.setValue("Select Item From ComboBox");
    }
    /*
     Handle ComboBox Selection
     */
    private void handleSelection()
    {
        mComboBox.setOnAction(event -> {
            selectedItem = mComboBox.getSelectionModel().getSelectedItem().toString();
            changebuttoncolor();
        });

    }

    public void changebuttoncolor(){
        button.setText(selectedItem);

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}



