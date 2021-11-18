package edu.isu.cs2263.acquire;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static edu.isu.cs2263.acquire.GameBoard.splitNum;

public class Turn {
    public static int distanceTo1A(String tile){
        return splitNum(tile)-1;
    }
    public static Integer checkAlphabet(Tile tile){
        int ascii=tile.getTileAlphabet().charAt(0);
        return ascii;
    }

    /*public static List<Object>playerSort(Player player1,Player player2){
        List<Object> playerSort=new ArrayList<>();
        Pair<String,Integer> playerPair1=new Pair<String, Integer>(player1.getName(),player1.getTileNumber());
        Pair<String,Integer> playerPair2=new Pair<String, Integer>(player2.getName(),player2.getTileNumber());
        if(checkAlphabet(player1.tile)<checkAlphabet(player2.tile)){
            System.out.println("Player1 is first");
            playerSort.add(playerPair1);
            playerSort.add(playerPair2);}
        if(checkAlphabet(player1.tile)>checkAlphabet(player2.tile)){
            System.out.println("Player2 is first");
            playerSort.add(playerPair2);
            playerSort.add(playerPair1);}
        if(checkAlphabet(player1.tile)==checkAlphabet(player2.tile)) {
            if (distanceTo1A(player1.tile) < distanceTo1A(player2.tile)) {
                System.out.println("Player1 is first");
                playerSort.add(playerPair1);
                playerSort.add(playerPair2);
            }
            if (distanceTo1A(player1.tile) > distanceTo1A(player2.tile)) {
                System.out.println("Player2 is first");
                playerSort.add(playerPair2);
                playerSort.add(playerPair1);
            }
        }

        return playerSort;


}*/
}
