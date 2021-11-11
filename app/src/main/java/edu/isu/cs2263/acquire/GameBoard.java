package edu.isu.cs2263.acquire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static edu.isu.cs2263.acquire.SaveManager.loadCorpos;
import static edu.isu.cs2263.acquire.SaveManager.newGame;

public class GameBoard {

   private List<Corporation> Corpos;
    private List<String> deck;
    private List<String> playedTiles;
    public List<Corporation> getCorpos() {
        return Corpos;
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

    public static void main(String [] args) throws IOException {
    //Testing for Game start and loading corpos
    newGame();
    GameBoard Game = new GameBoard();
    Game.setCorpos(loadCorpos());
    System.out.println(Game.getCorpos());

    //Loads Tiles into deck
    Tile tiles = new Tile();
    Game.setDeck(tiles.wholeTiles());
    System.out.println(Game.getDeck());
    //Testing Draw Tile

        Game.addPlayedTile(Game.drawTile(Game.getDeck()));
        System.out.println(Game.getPlayedTiles());
        System.out.println(Game.getDeck());
        Game.addPlayedTile("1A");
        Game.detectAdjacency("2B", Game.getPlayedTiles());



    }
    public String drawTile(List<String> deck){
        Random rnd = new Random();
        int i = rnd.nextInt(deck.size());
        String x = deck.get(i);
        this.deck.remove(i);
        return x;
    }
    public void detectAdjacency(String tile, List<String> tiles){
        //Split the tile we are checking into number and character
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
        int x = Integer.valueOf(num);

        //For loop we use to check
        for (int i = 0; i < tiles.size(); i++){
            //Split each tile in placedTile array list
            String ts = tiles.get(i);
            int number;
            char c1;
            if((tile.length()) == 2){
                number = ((((tiles.get(i)).charAt(0)) - '0'));
                c1 = ts.charAt(1);
            }
            else{
                String spl2[] = {tile.substring(0, 1)};
                number = Integer.valueOf(spl2[0]);
                c1 = ts.charAt(2);
            }


            System.out.println(tiles.get(i));
            //Check if same character
            if (c1 == c){
                System.out.println("Check for number");
                if(number == (x + 1)){

                    System.out.println("Adjacent");
                }
                else if (number == (x - 1)){
                    System.out.println("Adjacent");
                }
                else{
                    System.out.println("Not Adjacent");
                }
            }
            //check if same number

            else if(number == x){

                if((c1) == (c + 1)){
                    System.out.println("Adjacent");
                }
                else if ((c1) == (c - 1)){
                    System.out.println("Adjacent");
                }
                else{
                    System.out.println("Not Adjacent");
                }
            }
            else{
                System.out.println("Not Adjacent");
            }
        }

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




}
