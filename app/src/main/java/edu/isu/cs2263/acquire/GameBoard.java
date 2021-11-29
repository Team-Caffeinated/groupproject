package edu.isu.cs2263.acquire;

import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static edu.isu.cs2263.acquire.Corporation.*;
import static edu.isu.cs2263.acquire.SaveManager.loadCorpos;
//import static edu.isu.cs2263.acquire.SaveManager.newGame;

public class GameBoard {

    private static Corporation Tower = new Corporation("Tower", 0, "red");
    private static Corporation Continental = new Corporation("Continental", 0, "purple");
    private static Corporation Sackson = new Corporation("Sackson", 0, "yellow");
    private static Corporation American = new Corporation("American", 0, "green");
    private static Corporation Festival = new Corporation("Festival", 0, "blue");
    private static Corporation Imperial = new Corporation("Imperial", 0, "orange");
    private static Corporation Worldwide = new Corporation("Worldwide", 0, "teal");


    private static Player player1 = new Player("player1", 5000);
    private static Player player2 = new Player("player2", 5000);
    private static List<Corporation> Corpos;
    private static List<String> deck;
    private static List<String> playedTiles;
    //==============================================================================================================

    public String helpval;
    public String helpval1;
    public String helpval2;
    public String helpval3;


    public   Corporation tower = new Corporation("Tower", 0, "red");
    public   Corporation continental = new Corporation("Continental", 0, "purple");
    public   Corporation sackson = new Corporation("Sackson", 0, "yellow");
    public   Corporation american = new Corporation("American", 0, "green");
    public   Corporation festival = new Corporation("Festival", 0, "blue");
    public   Corporation imperial = new Corporation("Imperial", 0, "orange");
    public   Corporation worldwide = new Corporation("Worldwide", 0, "teal");
    public static ArrayList<Corporation> corplist=new ArrayList<>();
    public static ArrayList<String> corplistname=new ArrayList<>();


    public List<Corporation> getCorpos() {
        return Corpos;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public List<String> getDeck() {
        return deck;
    }

    public void setDeck(List<String> deck) {
        this.deck = deck;
    }

    public List<String> getPlayedTiles() {
        return playedTiles;
    }


    public void setPlayedTiles(List<String> playedTiles) {
        this.playedTiles = playedTiles;
    }


    public void setCorpos(List<Corporation> corpos) {
        Corpos = corpos;
    }

    public void startGame() {
        Tile tiles = new Tile();
        setDeck(tiles.wholeTiles());


    }

    public static String startGame(GameBoard game) {
        String tile;
        tile = game.drawTile();
        game.addPlayedTile(tile);
        //System.out.println(tile);
        return tile;
    }

    public String drawTile() {
        Random rnd = new Random();
        int i = rnd.nextInt(this.deck.size());
        String x = this.deck.get(i);
        this.deck.remove(i);
        return x;
    }

    public void detectAdjacency(String tile, List<String> tiles) {
        Corporation adjacentCorp1 = null;
        Corporation adjacentCorp2 = null;
        Corporation adjacentCorp3 = null;
        Corporation adjacentCorp4 = null;
        int adjacentCount = 0;
        //Split the tile we are checking into number and character
        char c = splitChar(tile);
        ;
        int x = splitNum(tile);

        //For loop we use to check
        for (int i = 0; i < tiles.size(); i++) {
            //Split each tile in placedTile array list
            String ts = tiles.get(i);
            int number = splitNum(ts);
            char c1 = splitChar(ts);

            //Int counts adjacencies


            System.out.println(tiles.get(i));
            if (c == c1) {
                //Check Right first
                if (checkRight(x, number)) {
                    System.out.println("Right adjacent");
                    adjacentCount++;
                    adjacentCorp1 = searchCorporations(ts);
                }
                //Check Left First
                else if (checkLeft(x, number)) {
                    System.out.println("Left adjacent");
                    adjacentCount++;
                    adjacentCorp2 = searchCorporations(ts);
                }
            } else if (x == number) {
                //Check Up First
                if (checkUp(c, c1)) {
                    System.out.println("Up adjacent");
                    adjacentCount++;
                    adjacentCorp3 = searchCorporations(ts);
                }

                //Check Down First
                else if (checkDown(c, c1)) {
                    System.out.println("Down adjacent");
                    adjacentCount++;
                    adjacentCorp4 = searchCorporations(ts);

                }
            }

        }
        if (adjacentCorp1 != null && adjacentCorp2 != null && adjacentCorp3 != null && adjacentCorp4 != null) {
            merge4(adjacentCorp1, adjacentCorp2, adjacentCorp3, adjacentCorp4, tile);
        } else if (adjacentCorp1 != null && adjacentCorp2 != null && adjacentCorp3 != null && adjacentCorp4 == null) {
            merge3(adjacentCorp1, adjacentCorp2, adjacentCorp3, tile);
        } else if (adjacentCorp1 != null && adjacentCorp2 != null && adjacentCorp3 == null && adjacentCorp4 != null) {
            merge3(adjacentCorp1, adjacentCorp2, adjacentCorp4, tile);
        } else if (adjacentCorp1 != null && adjacentCorp2 == null && adjacentCorp3 != null && adjacentCorp4 != null) {
            merge3(adjacentCorp1, adjacentCorp3, adjacentCorp4, tile);
        } else if (adjacentCorp1 == null && adjacentCorp2 != null && adjacentCorp3 != null && adjacentCorp4 != null) {
            merge3(adjacentCorp2, adjacentCorp3, adjacentCorp4, tile);
        } else if (adjacentCorp1 == null && adjacentCorp2 == null && adjacentCorp3 != null && adjacentCorp4 != null) {
            merge(adjacentCorp3, adjacentCorp4, tile);
        } else if (adjacentCorp1 != null && adjacentCorp2 == null && adjacentCorp3 == null && adjacentCorp4 != null) {
            merge(adjacentCorp1, adjacentCorp4, tile);
        } else if (adjacentCorp1 != null && adjacentCorp2 == null && adjacentCorp3 != null && adjacentCorp4 == null) {
            merge(adjacentCorp1, adjacentCorp3, tile);
        } else if (adjacentCorp1 == null && adjacentCorp2 != null && adjacentCorp3 == null && adjacentCorp4 != null) {
            merge(adjacentCorp2, adjacentCorp4, tile);
        } else if (adjacentCorp1 == null && adjacentCorp2 != null && adjacentCorp3 != null && adjacentCorp4 == null) {
            merge(adjacentCorp2, adjacentCorp3, tile);
        } else if (adjacentCorp1 != null && adjacentCorp2 != null && adjacentCorp3 == null && adjacentCorp4 == null) {
            merge(adjacentCorp1, adjacentCorp2, tile);
        } else if (adjacentCorp1 == null && adjacentCorp2 == null && adjacentCorp3 == null && adjacentCorp4 != null) {
            adjacentCorp4.increaseSize(1, tile);
        } else if (adjacentCorp1 == null && adjacentCorp2 == null && adjacentCorp3 != null && adjacentCorp4 == null) {
            adjacentCorp3.increaseSize(1, tile);
        } else if (adjacentCorp1 == null && adjacentCorp2 != null && adjacentCorp3 == null && adjacentCorp4 == null) {
            adjacentCorp2.increaseSize(1, tile);
        } else if (adjacentCorp1 != null && adjacentCorp2 == null && adjacentCorp3 == null && adjacentCorp4 == null) {
            adjacentCorp1.increaseSize(1, tile);
        }
        // Start corp
        else {

        }
    }

    public static boolean checkRight(int tileNum, int checkedTileNum) {
        if (checkedTileNum == (tileNum + 1)) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean checkLeft(int tileNum, int checkedTileNum) {
        if (checkedTileNum == (tileNum - 1)) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean checkUp(char tileChar, char checkedTileChar) {
        if (checkedTileChar == (tileChar + 1)) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean checkDown(char tileChar, char checkedTileChar) {
        if (checkedTileChar == (tileChar - 1)) {
            return true;
        } else {
            return false;
        }

    }

    //======================================================================================================================
    public ArrayList<String> listofwholetilesthatplayed = new ArrayList<>();




    public boolean check(ArrayList<String> list, String tile){
        for(String value: list){
            if(value.charAt(0) == tile.charAt(0)){
                if (value.charAt(1) == tile.charAt(1) - 1) {

                    return true;}
                if (value.charAt(1) == tile.charAt(1) + 1) {

                    return true;
                }
            }
            if (value.charAt(1) == tile.charAt(1)) {
                if (value.charAt(0) == tile.charAt(0) - 1) {

                    return true;
                }
                if (value.charAt(0) == tile.charAt(0) + 1) {

                    return true;
                }
            }
        }
        return false;
    }



    public void checkleft(ArrayList<String> list, String tile) {
        for (String value : list) {
            if (value.charAt(0) == tile.charAt(0)) {
                if (value.charAt(1) == tile.charAt(1) - 1) {
                    helpval = value;
                }
            }
        }
    }
    public void checkright(ArrayList<String> list, String tile){
        for (String value : list) {
            if (value.charAt(0) == tile.charAt(0)) {
                if (value.charAt(1) == tile.charAt(1) + 1) {
                    helpval1 = value;
                }
            }
        }
    }
    public void checkup(ArrayList<String> list, String tile){
        for (String value : list) {
            if (value.charAt(1) == tile.charAt(1)) {
                if (value.charAt(0) == tile.charAt(0) - 1) {
                    helpval2 = value;
                }
            }
        }
    }
    public void checkdown(ArrayList<String> list, String tile){
        for (String value : list) {
            if (value.charAt(1) == tile.charAt(1)) {
                if (value.charAt(0) == tile.charAt(0) + 1) {
                    helpval3 = value;
                }
            }
        }
    }



    public boolean left(ArrayList<String> list, String tile) {
        for (String value : list) {
            if (value.charAt(0) == tile.charAt(0)) {
                if (value.charAt(1) == tile.charAt(1) - 1) {
                    helpval = value;
                    return true;
                }
            }


        }
        return false;
    }

    public boolean right(ArrayList<String> list, String tile){
        for (String value : list) {
            if (value.charAt(0) == tile.charAt(0)) {
                if (value.charAt(1) == tile.charAt(1) + 1) {
                    helpval1 = value;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean up(ArrayList<String> list, String tile){
        for (String value : list) {
            if (value.charAt(1) == tile.charAt(1)) {
                if (value.charAt(0) == tile.charAt(0) - 1) {
                    helpval2 = value;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean down(ArrayList<String> list, String tile){
        for (String value : list) {
            if (value.charAt(1) == tile.charAt(1)) {
                if (value.charAt(0) == tile.charAt(0) + 1) {
                    helpval3 = value;
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<String> lisrofCorpsname(){
        Corporation tower = new Corporation("Tower", 0, "red");
        Corporation continental = new Corporation("Continental", 0, "purple");
        Corporation sackson = new Corporation("Sackson", 0, "yellow");
        Corporation american = new Corporation("American", 0, "green");
        Corporation festival = new Corporation("Festival", 0, "blue");
        Corporation imperial = new Corporation("Imperial", 0, "orange");
        Corporation worldwide = new Corporation("Worldwide", 0, "teal");
        corplistname.add(tower.getName());
        corplistname.add(continental.getName());
        corplistname.add(sackson.getName());
        corplistname.add(american.getName());
        corplistname.add(festival.getName());
        corplistname.add(imperial.getName());
        corplistname.add(worldwide.getName());
        return corplistname;

    }

    public ArrayList<Corporation> lisrofCorp(){
        Corporation tower = new Corporation("Tower", 0, "red");
        Corporation continental = new Corporation("Continental", 0, "purple");
        Corporation sackson = new Corporation("Sackson", 0, "yellow");
        Corporation american = new Corporation("American", 0, "green");
        Corporation festival = new Corporation("Festival", 0, "blue");
        Corporation imperial = new Corporation("Imperial", 0, "orange");
        Corporation worldwide = new Corporation("Worldwide", 0, "teal");
        corplist.add(tower);
        corplist.add(continental);
        corplist.add(sackson);
        corplist.add(american);
        corplist.add(festival);
        corplist.add(imperial);
        corplist.add(worldwide);
        return corplist;
    }



    /*public boolean check(ArrayList<String> list, String tile) {
        for (String value : list) {
            if (value.charAt(0) == tile.charAt(0)) {
                if (value.charAt(1) == tile.charAt(1) - 1 ) {
                    helpval = value;
                    return true;
                }
            }
            if (value.charAt(0) == tile.charAt(0)) {
                if (value.charAt(1) == tile.charAt(1) + 1) {
                    helpval = value;
                    return true;
                }
            }
            if (value.charAt(1) == tile.charAt(1)) {
                if ( value.charAt(0) == tile.charAt(0) - 1) {
                    helpval1 = value;
                    return true;
                }
            }
            if (value.charAt(1) == tile.charAt(1)) {
                if (value.charAt(0) == tile.charAt(0) + 1) {
                    helpval = value;
                    return true;
                }

            }
        }
        return false;

    }

     */


    public ArrayList<String> listpfplayedtiles(String placedtilesontheboard) {
        listofwholetilesthatplayed.add(placedtilesontheboard);
        return listofwholetilesthatplayed;
    }


//======================================================================================================================
    public static char splitChar(String tile){
        String cha;
        String num;
        if(tile.length()==2){
            int mid = tile.length() / 2;
            String split[] = {tile.substring(0, mid),tile.substring(mid)};
            cha = split[1];
            num = split[0];
        }
        else{
            String spl[] = {tile.substring(0, 1), tile.substring(2)};
            cha = spl[1];
            num = spl[0];
        }
        char c = cha.charAt(0);
        return c;
    }
    public static int splitNum(String tile){
        String cha;
        String num;
        if(tile.length()==2){
            int mid = tile.length() / 2;
            String split[] = {tile.substring(0, mid),tile.substring(mid)};
            cha = split[1];
            num = split[0];
        }
        else{
            String spl[] = {tile.substring(0, 2), tile.substring(2)};
            cha = spl[1];
            num = spl[0];

        }
        char c = cha.charAt(0);
        int x = Integer.valueOf(num);
        return x;
    }
    public void addPlayedTile(String tile){
        if(this.playedTiles == null){
            List<String> temp = new ArrayList<>();
            temp.add(tile);
            this.setPlayedTiles(temp);


        }
        else{
            this.playedTiles.add(tile);
        }

    }

    public static Corporation searchCorporations(String adjacentTile){
        if(Tower.searchList(adjacentTile)){
            return Tower;
        }
        else if (Continental.searchList(adjacentTile)){
            return Continental;
        }
        else if (Sackson.searchList(adjacentTile)){
            return Sackson;
        }
        else if (American.searchList(adjacentTile)){
            return American;
        }
        else if (Festival.searchList(adjacentTile)){
            return Festival;
        }
        else if (Imperial.searchList(adjacentTile)){
            return Imperial;
        }
        else if (Worldwide.searchList(adjacentTile)){
            return Worldwide;
        }
        return null;
    }


    public static void main(String[] args) {

        GameBoard gb=new GameBoard();
       // System.out.println(gb.lisrofCorpsname().contains());


    }






}