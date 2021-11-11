package edu.isu.cs2263.acquire;

import java.util.List;

public class Player {
    //Attributes
    private String name;
    private int money;
    private int stockValue;
    private List<String> stock;
    private List<String> hand;
    private boolean turn;

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
    public List<String> getStock() {
        return stock;
    }

    public void setStock(List<String> stock) {
        this.stock = stock;
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
        this.hand.add(t);
    }

    //Remove a tile from the player's hand
    public void removeTile(String t){
        this.hand.remove(t);
    }

    //Add stock to the player's list of stocks
    public void addStock(String s){
        this.stock.add(s);
    }

    //Remove stock from the player's list of stocks
    public void removeStock(String s){
        this.stock.remove(s);

    }
}
