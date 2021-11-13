import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class sample1 extends Application{
    private static final int numofpairs=8;
    private static final int numperrow=4;


    private Parent createContetn(){
        Pane root= new Pane();
        root.setPrefSize(600,600);
        char c='a';
        List<Tile> tiles=new ArrayList<>();
        for (int i=0;i<numofpairs;i++){

        }

        Tile tile=new Tile("A");
        root.getChildren().addAll(tile);

        return root;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContetn()));
        primaryStage.show();

    }


    private class Tile extends StackPane{
        public Tile(String value){
            javafx.scene.shape.Rectangle border=new javafx.scene.shape.Rectangle(50,50);
            Text text=new Text(value);
            border.setFill(null);
            border.setStroke(Color.BLACK);
            text.setFont(Font.font(30));
            setAlignment(Pos.CENTER);
            getChildren().addAll(border,text);
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}