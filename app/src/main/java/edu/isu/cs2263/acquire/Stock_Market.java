package edu.isu.cs2263.acquire;

public class Stock_Market {
    //Attributes
    private int stockValue;
    private int stockCount;
    private boolean stockAvailable;

    //Corporation stock availability
    private int towerStockAvail;
    private int saxonStockAvail;
    private int americanStockAvail;
    private int worldwideStockAvail;
    private int festivalStockAvail;
    private int imperialStockAvail;
    private int continentalStockAvail;

    //Constructor
    public Stock_Market(){
        towerStockAvail = 25;
        saxonStockAvail = 25;
        americanStockAvail = 25;
        worldwideStockAvail = 25;
        festivalStockAvail = 25;
        imperialStockAvail = 25;
        continentalStockAvail = 25;
    }

    public int getStockValue() {
        return stockValue;
    }

    public void setStockValue(int stockValue) {
        this.stockValue = stockValue;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public boolean isStockAvailable() {
        return stockAvailable;
    }

    public void setStockAvailable(boolean stockAvailable) {
        this.stockAvailable = stockAvailable;
    }

    public int getTowerStockAvail() {
        return towerStockAvail;
    }

    public void setTowerStockAvail(int towerStockAvail) {
        this.towerStockAvail = towerStockAvail;
    }

    public int getSaxonStockAvail() {
        return saxonStockAvail;
    }

    public void setSaxonStockAvail(int saxonStockAvail) {
        this.saxonStockAvail = saxonStockAvail;
    }

    public int getAmericanStockAvail() {
        return americanStockAvail;
    }

    public void setAmericanStockAvail(int americanStockAvail) {
        this.americanStockAvail = americanStockAvail;
    }

    public int getWorldwideStockAvail() {
        return worldwideStockAvail;
    }

    public void setWorldwideStockAvail(int worldwideStockAvail) {
        this.worldwideStockAvail = worldwideStockAvail;
    }

    public int getFestivalStockAvail() {
        return festivalStockAvail;
    }

    public void setFestivalStockAvail(int festivalStockAvail) {
        this.festivalStockAvail = festivalStockAvail;
    }

    public int getImperialStockAvail() {
        return imperialStockAvail;
    }

    public void setImperialStockAvail(int imperialStockAvail) {
        this.imperialStockAvail = imperialStockAvail;
    }

    public int getContinentalStockAvail() {
        return continentalStockAvail;
    }

    public void setContinentalStockAvail(int continentalStockAvail) {
        this.continentalStockAvail = continentalStockAvail;
    }

    //Methods
    public void buyStock(Player p, Corporation c){
        int corpStockSize;
        int val = checkValue(c);
        String corpName = c.getName();
        int totalVal = val * c.getSize();
        if(p.getMoney() >= totalVal){
            p.removeMoney(val);
            if(corpName == "Saxon"){
                if(saxonStockAvail > 0) {
                    corpStockSize = p.getSaxonStock() + 1;
                    p.setSaxonStock(corpStockSize);
                    saxonStockAvail--;
                }
                else{
                    System.out.println("There is no more Saxon stock available");
                }
            }
            else if(corpName == "Tower"){
                if(towerStockAvail > 0) {
                    corpStockSize = p.getTowerStock() + 1;
                    p.setTowerStock(corpStockSize);
                    towerStockAvail--;
                }
                else{
                    System.out.println("There is no more Tower stock available");
                }
            }
            else if(corpName == "American"){
                if(americanStockAvail > 0) {
                    corpStockSize = p.getAmericanStock() + 1;
                    p.setAmericanStock(corpStockSize);
                    americanStockAvail--;
                }
                else{
                    System.out.println("There is no more American stock available");
                }
            }
            else if(corpName == "Festival"){
                if(festivalStockAvail > 0) {
                    corpStockSize = p.getFestivalStock() + 1;
                    p.setFestivalStock(corpStockSize);
                    festivalStockAvail--;
                }
                else{
                    System.out.println("There is no more Festival stock available");
                }
            }
            else if (corpName == "Worldwide"){
                if(worldwideStockAvail > 0) {
                    corpStockSize = p.getWorldwideStock() + 1;
                    p.setWorldwideStock(corpStockSize);
                    worldwideStockAvail--;
                }
                else{
                    System.out.println("There is no more Worldwide stock available");
                }
            }
            else if(corpName == "Continental"){
                if(continentalStockAvail > 0) {
                    corpStockSize = p.getContinentalStock() + 1;
                    p.setWorldwideStock(corpStockSize);
                    continentalStockAvail--;
                }
                else{
                    System.out.println("There is no more Continental stock available");
                }
            }
            else if(corpName == "Imperial"){
                if(imperialStockAvail > 0) {
                    corpStockSize = p.getImperialStock() + 1;
                    p.setImperialStock(corpStockSize);
                    imperialStockAvail--;
                }
                else{
                    System.out.println("There is no more Imperial stock available");
                }
            }
        }
        else{
            System.out.println("Player does not have enough money to purchase that stock");
        }
    }

    public void sellStock(Player p, Corporation c){
        int corpStockSize;
        int val = checkValue(c);
        int size = c.getSize();
        int totalVal = val * size;
        if(c.getName() == "Tower") {
            if (p.getTowerStock() > 0) {
                corpStockSize = p.getTowerStock() - 1;
                p.setTowerStock(corpStockSize);
                towerStockAvail++;
                p.addMoney(val);
            } else {
                System.out.println("Player has no Tower stock to sell");
            }
        }
        else if(c.getName() == "Saxon"){
            if(p.getSaxonStock() > 0){
                corpStockSize = p.getSaxonStock() - 1;
                p.setSaxonStock(corpStockSize);
                saxonStockAvail++;
                p.addMoney(val);
            }
            else{
                System.out.println("Player has no Saxon stock to sell");
            }
        }
        else if(c.getName() == "American"){
            if(p.getAmericanStock() > 0){
                corpStockSize = p.getAmericanStock() - 1;
                p.setAmericanStock(corpStockSize);
                americanStockAvail++;
                p.addMoney(val);
            }
            else{
                System.out.println("PLayer has no American stock to sell");
            }
        }
        else if(c.getName() == "Festival"){
            if(p.getFestivalStock() > 0){
                corpStockSize = p.getFestivalStock() - 1;
                p.setFestivalStock(corpStockSize);
                festivalStockAvail++;
                p.addMoney(val);
            }
            else{
                System.out.println("Player has no Festival stock to sell");
            }
        }
        else if(c.getName() == "Worldwide"){
            if(p.getFestivalStock() > 0){
                corpStockSize = p.getWorldwideStock() - 1;
                p.setWorldwideStock(corpStockSize);
                worldwideStockAvail++;
                p.addMoney(val);
            }
            else{
                System.out.println("Player has no Worldwide stock to sell");
            }
        }
        else if(c.getName() == "Continental"){
            if(p.getContinentalStock() > 0){
                corpStockSize = p.getContinentalStock() - 1;
                p.setContinentalStock(corpStockSize);
                continentalStockAvail++;
                p.addMoney(val);
            }
            else{
                System.out.println("Player has no Continental stock to sell");
            }
        }
        else if(c.getName() == "Imperial"){
            if(p.getImperialStock() > 0){
                corpStockSize = p.getImperialStock() - 1;
                p.setImperialStock(corpStockSize);
                imperialStockAvail++;
                p.addMoney(val);
            }
            else{
                System.out.println("Player has no Imperial stock to sell");
            }
        }
    }

    public void tradeStock(Player p, Corporation defunct, Corporation corp, int numStocks){
        int newStock = numStocks/2;
        
    }

    public int checkValue(Corporation c) {
        int size = c.getSize();
        if (c.getName() == "Saxon" || c.getName() == "Tower") {
            if(size == 2) {
                return 200;
            }
            else if(size == 3) {
                return 300;
            }
            else if(size == 4) {
                return 400;
            }
            else if(size == 5){
                return 500;
            }
            else if(size >= 6 && size <= 10){
                return 600;
            }
            else if(size >= 11 && size <= 20){
                return 700;
            }
            else if(size >= 21 && size <= 30){
                return 800;
            }
            else if(size >= 31 && size <= 40){
                return 900;
            }
            else if(size >= 41){
                return 1000;
            }
        else if(c.getName() == "American" || c.getName() == "Festival" || c.getName() == "Worldwide"){
                if(size == 2){
                    return 300;
                }
                else if(size == 3){
                    return 400;
                }
                else if(size == 4){
                    return 500;
                }
                else if(size == 5){
                    return 600;
                }
                else if(size >=6 && size <= 10){
                    return 700;
                }
                else if(size >= 11 && size <= 20){
                    return 800;
                }
                else if(size >= 21 && size <= 30){
                    return 900;
                }
                else if(size >= 31 && size <= 40){
                    return 1000;
                }
                else if(size >= 41){
                    return 1100;
                }
            }
        else if(c.getName() == "Continental" || c.getName() == "Imperial"){
                if(size == 2){
                    return 400;
                }
                else if(size == 3){
                    return 500;
                }
                else if(size == 4){
                    return 600;
                }
                else if(size == 5){
                    return 700;
                }
                else if(size >= 6 && size <= 10){
                    return 800;
                }
                else if(size >= 11 && size <= 20){
                    return 900;
                }
                else if(size >= 21 && size <= 30){
                    return 1000;
                }
                else if(size >= 31 && size <= 40){
                    return 1100;
                }
                else if(size >= 41){
                    return 1200;
                }
            }
        }
        return 0;
    }
}
