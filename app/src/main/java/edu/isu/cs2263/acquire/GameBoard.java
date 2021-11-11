package edu.isu.cs2263.acquire;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static edu.isu.cs2263.acquire.Corporation.generateCorpos;

public class GameBoard {
   private List<Corporation> Corpos;

    public List<Corporation> getCorpos() {
        return Corpos;
    }

    public void setCorpos(List<Corporation> corpos) {
        Corpos = corpos;
    }

    public static void main(String [] args) throws IOException {



    }



}
