package edu.isu.cs2263.acquire;

import javafx.application.Platform;

public class Update {

    public static void run(Runnable treatment) {
        if(treatment == null) throw new IllegalArgumentException("The treatment to perform can not be null");

        if(Platform.isFxApplicationThread()) treatment.run();
        else Platform.runLater(treatment);
    }
}