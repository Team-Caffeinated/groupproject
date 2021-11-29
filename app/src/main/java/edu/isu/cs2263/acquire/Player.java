package edu.isu.cs2263.acquire;

import java.util.ArrayList;
import java.util.List;

public class Player {
    //Attributes
    private String name;
    private int money;
    private int stockValue;
    private int towerStock;
    private int saxonStock;
    private int americanStock;
    private int festivalStock;
    private int worldwideStock;
    private int continentalStock;
    private int imperialStock;
    private List<String> hand;
    private boolean turn;


    public int getTowerStock() {
        return towerStock;
    }

    public void setTowerStock(int towerStock) {
        this.towerStock = towerStock;
    }

    public int getSaxonStock() {
        return saxonStock;
    }

    public void setSaxonStock(int luxorStock) {
        this.saxonStock = luxorStock;
    }

    public int getAmericanStock() {
        return americanStock;
    }

    public void setAmericanStock(int americanStock) {
        this.americanStock = americanStock;
    }

    public int getFestivalStock() {
        return festivalStock;
    }

    public void setFestivalStock(int festivalStock) {
        this.festivalStock = festivalStock;
    }

    public int getWorldwideStock() {
        return worldwideStock;
    }

    public void setWorldwideStock(int worldwideStock) {
        this.worldwideStock = worldwideStock;
    }

    public int getContinentalStock() {
        return continentalStock;
    }

    public void setContinentalStock(int continentalStock) {
        this.continentalStock = continentalStock;
    }

    public int getImperialStock() {
        return imperialStock;
    }

    public void setImperialStock(int imperialStock) {
        this.imperialStock = imperialStock;}

    public Player(String name, int money) {
        this.name = name;
        this.money = money;

    }

    //Getters and Setters
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStockValue() {
        return stockValue;
    }

    public void setStockValue(int stockValue) {
        this.stockValue = stockValue;
    }

    public List<String> getHand() {
        return hand;
    }

    public void setHand(List<String> hand) {
        this.hand = hand;
    }

    public boolean checkTurn() {return turn;}

    //Add a tile to the player's hand
    public void addTile(String t){
        if(this.hand == null){
            List<String> temp = new ArrayList<>();
            temp.add(t);
            this.setHand(temp);


        }
        else{
            this.hand.add(t);
        }

    }

    //Remove a tile from the player's hand
    public void removeTile(String t){
        this.hand.remove(t);
    }

    //Remove money from a player's account
    public void removeMoney(int v){
        int m = getMoney();
        money = m - v;
    }

    //Add money to a player's account
    public void addMoney(int v){
        money += v;
    }
}