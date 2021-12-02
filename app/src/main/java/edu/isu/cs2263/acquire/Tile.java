package edu.isu.cs2263.acquire;
import java.util.ArrayList;

public class Tile {
    private int tileNumber;
    private String tileAlphabet;

    public Integer neghbor1;
    public Integer neghbor2;
    public Integer neghbor3;
    public Integer neghbor4;

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

    public static ArrayList<String> wholeTiles(){
        ArrayList<String> tileList=new ArrayList<>();
        String[] tileAlphabetList={"A","B","C","D","E","F","G","H","I"};
        for(int i=1;i<13;i++){
            for(int j=0;j<9;j++){
                tileList.add(i+tileAlphabetList[j]);
            }
        }
        return tileList;
    }

    public ArrayList<Integer> neighbors(String tile){
        ArrayList<Integer> neighbors=new ArrayList<>();
        for(int s=0;s<108;s++){
            if(wholeTiles().get(s).equals(tile)){
                if(s+1<=107){
                    if(s+1!=9 && s+1!=18 && s+1!=27 &&s+1!=36&&s+1!=45&&s+1!=54&&s+1!=63&&s+1!=72&&s+1!=81&&s+1!=90&&s+1!=99){
                        neighbors.add(s+1);}
                }
                if(s-1>=0){
                    if(s-1!=8 && s-1!=26 &&s-1!=35&&s-1!=44&&s-1!=53&&s-1!=62&&s-1!=71&&s-1!=80&&s-1!=89&&s-1!=98){
                    neighbors.add(s-1);}
                }
                if(s+9<108){
                    neighbors.add(s+9);
                }
                if(s-9>=0){
                    neighbors.add(s-9);
                }
            }

        }
        return neighbors;

    }

    public Integer neighbor1(String tile){
        neghbor1=neighbors(tile).get(0);
        return neghbor1;
    }
    public Integer neighbor2(String tile){
        neghbor2=neighbors(tile).get(1);
        return neghbor1;
    }
    public Integer neighbor3(String tile){
        if(neighbors(tile).size()>2){
            neghbor3=neighbors(tile).get(2);
        }
        return neghbor3;
    }
    public Integer neighbor4(String tile){
        if(neighbors(tile).size()>3){
            neghbor4=neighbors(tile).get(2);
        }
        return neghbor4;
    }




    public static void main(String[] args) {
       System.out.println(new Tile().neighbors("12A"));
    }

}

