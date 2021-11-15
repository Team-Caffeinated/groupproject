package edu.isu.cs2263.acquire;
import java.util.ArrayList;

public class Tile {
    private int tileNumber;
    private String tileAlphabet;

    public int getTileNumber() {
        return tileNumber;
    }

    public void setTileNumber(int tileNumber) {
        this.tileNumber = tileNumber;
    }

    public String getTileAlphabet() {
        return tileAlphabet;
    }

    public void setTileAlphabet(String tileAlphabet) {
        this.tileAlphabet = tileAlphabet;
    }

    public ArrayList<String> wholeTiles(){
        ArrayList<String> tileList=new ArrayList<>();
        String[] tileAlphabetList={"A","B","C","D","E","F","G","H","I"};
        for(int i=1;i<13;i++){
            for(int j=0;j<9;j++){
                tileList.add(i+tileAlphabetList[j]);
            }
        }
        return tileList;
    }



}

