package edu.isu.cs2263.acquire;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Corporation {
    private String name;
    private Integer Size;
    private String color;
    private List<String> tiles;

    public List<String> getTiles() {
        return tiles;
    }

    public void setTiles(List<String> tiles) {
        this.tiles = tiles;
    }

    public Corporation(String name, Integer size, String Color) {
        this.name = name;
        Size = size;
        color = Color;
        tiles = new ArrayList<String>();
    }
    public Corporation(){

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSize() {
        return Size;
    }

    public void setSize(Integer size) {
        Size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void increaseSize(Integer increase, String tile){
        Size = Size + increase;
        this.addTile(tile);

    }
    public static void merge(Corporation one, Corporation two, String tile){
        Integer onesize = one.getSize();
        Integer twosize = two.getSize();
        if (onesize > twosize){
            two.resetSize();
            one.increaseSize(twosize + 1, tile);
            List<String> newTiles = new ArrayList<>();
            newTiles.addAll(one.getTiles());
            newTiles.addAll(two.getTiles());
            one.setTiles(newTiles);
            two.setTiles(null);
        }
        else if (twosize > onesize){
            one.resetSize();
            two.increaseSize(onesize + 1, tile);
            List<String> newTiles = new ArrayList<>();
            newTiles.addAll(one.getTiles());
            newTiles.addAll(two.getTiles());
            two.setTiles(newTiles);
            one.setTiles(null);
        }
    }
    public static void merge3(Corporation one, Corporation two, Corporation three, String tile){
        Integer onesize = one.getSize();
        Integer twosize = two.getSize();
        Integer threesize = three.getSize();
        if (onesize > twosize && onesize > threesize){
            two.resetSize();
            three.resetSize();
            one.increaseSize(twosize + threesize + 1, tile);
            List<String> newTiles = new ArrayList<>();
            newTiles.addAll(one.getTiles());
            newTiles.addAll(two.getTiles());
            newTiles.addAll(three.getTiles());
            one.setTiles(newTiles);
            two.setTiles(null);
            three.setTiles(null);
        }
        else if (twosize > onesize && twosize > threesize){
            one.resetSize();
            three.resetSize();
            two.increaseSize(onesize + threesize + 1 , tile);
            List<String> newTiles = new ArrayList<>();
            newTiles.addAll(one.getTiles());
            newTiles.addAll(two.getTiles());
            newTiles.addAll(three.getTiles());
            two.setTiles(newTiles);
            one.setTiles(null);
            three.setTiles(null);
        }
        else if (threesize > onesize && threesize > twosize){
            one.resetSize();
            two.resetSize();
            three.increaseSize(onesize + twosize + 1, tile );
            List<String> newTiles = new ArrayList<>();
            newTiles.addAll(one.getTiles());
            newTiles.addAll(two.getTiles());
            newTiles.addAll(three.getTiles());
            three.setTiles(newTiles);
            two.setTiles(null);
            one.setTiles(null);
        }
    }
    public static void merge4(Corporation one, Corporation two, Corporation three, Corporation four, String tile){
        Integer onesize = one.getSize();
        Integer twosize = two.getSize();
        Integer threesize = three.getSize();
        Integer foursize = four.getSize();
        if (onesize > twosize && onesize > threesize
        && onesize > foursize){
            two.resetSize();
            three.resetSize();
            four.resetSize();
            one.increaseSize(twosize + threesize + foursize + 1, tile);
            List<String> newTiles = new ArrayList<>();
            newTiles.addAll(one.getTiles());
            newTiles.addAll(two.getTiles());
            newTiles.addAll(three.getTiles());
            newTiles.addAll(four.getTiles());
            one.setTiles(newTiles);
            two.setTiles(null);
            three.setTiles(null);
            four.setTiles(null);
        }
        else if (twosize > onesize && twosize > threesize
                && twosize > foursize){
            one.resetSize();
            three.resetSize();
            four.resetSize();
            two.increaseSize(onesize + threesize + foursize + 1 , tile);
            List<String> newTiles = new ArrayList<>();
            newTiles.addAll(one.getTiles());
            newTiles.addAll(two.getTiles());
            newTiles.addAll(three.getTiles());
            newTiles.addAll(four.getTiles());
            two.setTiles(newTiles);
            one.setTiles(null);
            three.setTiles(null);
            four.setTiles(null);
        }
        else if (threesize > twosize && threesize > onesize
                && threesize > foursize){
            two.resetSize();
            one.resetSize();
            four.resetSize();
            three.increaseSize(twosize + onesize + foursize + 1, tile);
            List<String> newTiles = new ArrayList<>();
            newTiles.addAll(one.getTiles());
            newTiles.addAll(two.getTiles());
            newTiles.addAll(three.getTiles());
            newTiles.addAll(four.getTiles());
            three.setTiles(newTiles);
            two.setTiles(null);
            one.setTiles(null);
            four.setTiles(null);
        }
        else if (foursize > twosize && foursize > onesize
                && foursize > threesize){
            two.resetSize();
            one.resetSize();
            three.resetSize();
            four.increaseSize(twosize + onesize + threesize + 1, tile);
            List<String> newTiles = new ArrayList<>();
            newTiles.addAll(one.getTiles());
            newTiles.addAll(two.getTiles());
            newTiles.addAll(three.getTiles());
            newTiles.addAll(four.getTiles());
            four.setTiles(newTiles);
            two.setTiles(null);
            one.setTiles(null);
            three.setTiles(null);
        }
    }
    public void resetSize(){
        Size = 0;
    }

    @Override
    public String toString() {
        return "Corporation{" +
                "name='" + name + '\'' +
                ", Size=" + Size +
                ", color='" + color + '\'' +
                '}';
    }
    public void addTile(String tile){

        tiles.add(tile);

    }
    public boolean searchList(String adjacentTile){
        for (int i = 0; i < this.getSize(); i++){
            if ((this.getTiles()).get(i) == adjacentTile){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }



    /*public static void generateCorpos() throws IOException {
        Corporation Tower = new Corporation("Tower", 0,"Red");
        Corporation Continental = new Corporation("Continental", 0,"Purple");
        Corporation Sackson = new Corporation("Sackson", 0,"Yellow");
        Corporation American = new Corporation("American", 0,"Green");
        Corporation Festival = new Corporation("Festival", 0,"Blue");
        Corporation Imperial = new Corporation("Imperial", 0,"Orange");
        Corporation Worldwide = new Corporation("Worldwide", 0,"Teal");
        List<Corporation> corpos = new ArrayList<>();
        corpos.add(Tower);
        corpos.add(Continental);
        corpos.add(Sackson);
        corpos.add(American);
        corpos.add(Festival);
        corpos.add(Imperial);
        corpos.add(Worldwide);
        Gson gson = new Gson();
        FileWriter fileWriter = new FileWriter("CorporationSave.json");
        gson.toJson(corpos, fileWriter);
        fileWriter.close();
        System.out.println("JSON wrote to file");
    }*/
/*

public static void main(String[] args) {
        Corporation Tower = new Corporation("Tower", 3,"Red");
        System.out.println(Tower.tiles);
        Tile tile=new Tile();
        Tower.addTile(tile.wholeTiles().get(0));
        System.out.println(Tower.tiles);
        System.out.println(Tower.getSize());
    }
 */
}
