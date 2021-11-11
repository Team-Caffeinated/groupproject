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

public class SaveManager {

    public static List<Corporation> loadCorpos() throws FileNotFoundException {
        Gson gson = new Gson();
        List<Corporation> corpoList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Brad\\Desktop\\Acquire\\groupproject\\CorporationSave.json"));
        corpoList = Arrays.asList(gson.fromJson(br, Corporation[].class));
        return corpoList;
    }
    public static void newGame() throws IOException {
        generateCorpos();
    }



}
