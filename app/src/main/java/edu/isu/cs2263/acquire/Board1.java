package edu.isu.cs2263.acquire;

import java.util.ArrayList;
import java.util.Random;

public class Board1 {

    public static ArrayList<String> tiles=new Tile().wholeTiles();
    public static ArrayList<String> empty = new ArrayList<String>();
    public static Tile tile;


    public  String startGame() {
        String tilePick;
        Random rand = new Random();
        int upperbound = tiles.size()-1;
        int int_random = rand.nextInt(upperbound);
        tilePick = tiles.get(int_random);
        tiles.remove(tilePick);
        empty.add(tilePick);
        return tilePick;
    }


    //    Tile sina = new Tile();
    //    tiles = sina.wholeTiles();
    //    while (tiles.size() != 0) {
    //        System.out.println(tiles);
    //        String tilePick;
    //        Random rand = new Random();
    //        int upperbound = tiles.size();
    //        int int_random = rand.nextInt(upperbound);
    //        tilePick = tiles.get(int_random);
    //        //System.out.println("details:>>>"+int_random+" >>> "+tilePick+">>>"+tiles);
    //        tiles.remove(int_random);
            //System.out.println("details:>>>"+int_random+" >>> "+tilePick+">>>"+tiles);
    //        empty.add(tilePick);
    //        System.out.println(empty);
            //System.out.println(tiles.size());

     //   }
      //  System.out.println(tiles);
   // }
}
