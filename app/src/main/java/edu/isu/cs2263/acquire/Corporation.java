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
    public void increaseSize(Integer increase){
        Size = Size + increase;
    }
    public static void merge(Corporation one, Corporation two){
        Integer onesize = one.getSize();
        Integer twosize = two.getSize();
        if (onesize > twosize){
            two.resetSize();
            one.increaseSize(twosize);
        }
        else if (twosize > onesize){
            one.resetSize();
            two.increaseSize(onesize);
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
        increaseSize(1);
    }


    public static void generateCorpos() throws IOException {
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
    }
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
