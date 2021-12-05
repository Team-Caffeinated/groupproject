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
    public Stock_Market() {
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
    public void buyStock(Player p, String corpName, int corpSize) {
        int corpStockSize;
        int val = checkValue(corpName, corpSize);
        int totalVal = val * corpSize;
        if (p.getMoney() >= totalVal) {
            p.removeMoney(val);
            if (corpName == "Saxon") {
                if (saxonStockAvail > 0) {
                    corpStockSize = p.getSaxonStock() + 1;
                    p.setSaxonStock(corpStockSize);
                    saxonStockAvail--;
                } else {
                    System.out.println("There is no more Saxon stock available");
                }
            } else if (corpName == "Tower") {
                if (towerStockAvail > 0) {
                    corpStockSize = p.getTowerStock() + 1;
                    p.setTowerStock(corpStockSize);
                    towerStockAvail--;
                } else {
                    System.out.println("There is no more Tower stock available");
                }
            } else if (corpName == "American") {
                if (americanStockAvail > 0) {
                    corpStockSize = p.getAmericanStock() + 1;
                    p.setAmericanStock(corpStockSize);
                    americanStockAvail--;
                } else {
                    System.out.println("There is no more American stock available");
                }
            } else if (corpName == "Festival") {
                if (festivalStockAvail > 0) {
                    corpStockSize = p.getFestivalStock() + 1;
                    p.setFestivalStock(corpStockSize);
                    festivalStockAvail--;
                } else {
                    System.out.println("There is no more Festival stock available");
                }
            } else if (corpName == "Worldwide") {
                if (worldwideStockAvail > 0) {
                    corpStockSize = p.getWorldwideStock() + 1;
                    p.setWorldwideStock(corpStockSize);
                    worldwideStockAvail--;
                } else {
                    System.out.println("There is no more Worldwide stock available");
                }
            } else if (corpName == "Continental") {
                if (continentalStockAvail > 0) {
                    corpStockSize = p.getContinentalStock() + 1;
                    p.setWorldwideStock(corpStockSize);
                    continentalStockAvail--;
                } else {
                    System.out.println("There is no more Continental stock available");
                }
            } else if (corpName == "Imperial") {
                if (imperialStockAvail > 0) {
                    corpStockSize = p.getImperialStock() + 1;
                    p.setImperialStock(corpStockSize);
                    imperialStockAvail--;
                } else {
                    System.out.println("There is no more Imperial stock available");
                }
            }
        } else {
            System.out.println("Player does not have enough money to purchase that stock");
        }
    }

    public void sellStock(Player p, String corpName, int size) {
        int corpStockSize;
        int val = checkValue(corpName, size);
        int totalVal = val * size;
        if (c == "Tower") {
            if (p.getTowerStock() > 0) {
                corpStockSize = p.getTowerStock() - 1;
                p.setTowerStock(corpStockSize);
                towerStockAvail++;
                p.addMoney(val);
            } else {
                System.out.println("Player has no Tower stock to sell");
            }
        } else if (c == "Saxon") {
            if (p.getSaxonStock() > 0) {
                corpStockSize = p.getSaxonStock() - 1;
                p.setSaxonStock(corpStockSize);
                saxonStockAvail++;
                p.addMoney(val);
            } else {
                System.out.println("Player has no Saxon stock to sell");
            }
        } else if (c == "American") {
            if (p.getAmericanStock() > 0) {
                corpStockSize = p.getAmericanStock() - 1;
                p.setAmericanStock(corpStockSize);
                americanStockAvail++;
                p.addMoney(val);
            } else {
                System.out.println("PLayer has no American stock to sell");
            }
        } else if (c == "Festival") {
            if (p.getFestivalStock() > 0) {
                corpStockSize = p.getFestivalStock() - 1;
                p.setFestivalStock(corpStockSize);
                festivalStockAvail++;
                p.addMoney(val);
            } else {
                System.out.println("Player has no Festival stock to sell");
            }
        } else if (c == "Worldwide") {
            if (p.getFestivalStock() > 0) {
                corpStockSize = p.getWorldwideStock() - 1;
                p.setWorldwideStock(corpStockSize);
                worldwideStockAvail++;
                p.addMoney(val);
            } else {
                System.out.println("Player has no Worldwide stock to sell");
            }
        } else if (c == "Continental") {
            if (p.getContinentalStock() > 0) {
                corpStockSize = p.getContinentalStock() - 1;
                p.setContinentalStock(corpStockSize);
                continentalStockAvail++;
                p.addMoney(val);
            } else {
                System.out.println("Player has no Continental stock to sell");
            }
        } else if (c == "Imperial") {
            if (p.getImperialStock() > 0) {
                corpStockSize = p.getImperialStock() - 1;
                p.setImperialStock(corpStockSize);
                imperialStockAvail++;
                p.addMoney(val);
            } else {
                System.out.println("Player has no Imperial stock to sell");
            }
        }
    }

    public void tradeStock(Player p, Corporation defunct, Corporation corp, int numStocks) {
        int newStock = numStocks / 2;
        String defunctName = defunct.getName();
        String corpName = corp.getName();

        //If statements to check available stock and add if available
        if (corpName == "Saxon") {
            if (newStock <= saxonStockAvail) {
                int current = p.getSaxonStock();
                current += newStock;
                p.setSaxonStock(current);
            } else {
                System.out.println("There is not enough Saxon stock to perform this trade");
                return;
            }
        } else if (corpName == "Tower") {
            if (newStock <= towerStockAvail) {
                int current = p.getTowerStock();
                current += newStock;
                p.setTowerStock(current);
            } else {
                System.out.println("There is not enough Tower stock to perform this trade");
                return;
            }
        } else if (corpName == "American") {
            if (newStock <= americanStockAvail) {
                int current = p.getAmericanStock();
                current += newStock;
                p.setAmericanStock(current);
            } else {
                System.out.println("There is not enough American stock to perform this trade");
                return;
            }
        } else if (corpName == "Festival") {
            if (newStock <= festivalStockAvail) {
                int current = p.getFestivalStock();
                current += newStock;
                p.setFestivalStock(current);
            } else {
                System.out.println("There is not enough Festival stock to perform this trade");
                return;
            }
        } else if (corpName == "Worldwide") {
            if (newStock <= worldwideStockAvail) {
                int current = p.getWorldwideStock();
                current += newStock;
                p.setWorldwideStock(current);
            } else {
                System.out.println("There is not enough Worldwide stock to perform this trade");
                return;
            }
        } else if (corpName == "Continental") {
            if (newStock <= continentalStockAvail) {
                int current = p.getContinentalStock();
                current += newStock;
                p.setContinentalStock(current);
            } else {
                System.out.println("There is not enough Continental stock to perform this trade");
                return;
            }
        } else if (corpName == "Imperial") {
            if (newStock <= imperialStockAvail) {
                int current = p.getImperialStock();
                current += newStock;
                p.setImperialStock(current);
            } else {
                System.out.println("There is not enough Imperial stock to perform this trade");
                return;
            }
        }

        //If statements to remove defunct stock
        if (defunctName == "Saxon") {
            int current = p.getSaxonStock();
            current -= numStocks;
            p.setSaxonStock(current);
            saxonStockAvail += numStocks;
        } else if (defunctName == "Tower") {
            int current = p.getTowerStock();
            current -= numStocks;
            p.setTowerStock(current);
            towerStockAvail += numStocks;
        } else if (defunctName == "American") {
            int current = p.getAmericanStock();
            current -= numStocks;
            p.setAmericanStock(current);
            americanStockAvail += numStocks;
        } else if (defunctName == "Festival") {
            int current = p.getFestivalStock();
            current -= numStocks;
            p.setFestivalStock(current);
            festivalStockAvail += numStocks;
        } else if (defunctName == "Worldwide") {
            int current = p.getWorldwideStock();
            current -= numStocks;
            p.setWorldwideStock(current);
            worldwideStockAvail += numStocks;
        } else if (defunctName == "Continental") {
            int current = p.getContinentalStock();
            current -= numStocks;
            p.setContinentalStock(current);
            continentalStockAvail += numStocks;
        } else if (defunctName == "Imperial") {
            int current = p.getImperialStock();
            current -= numStocks;
            p.setImperialStock(current);
            imperialStockAvail += numStocks;
        }
    }

    public int checkValue(String c, int size) {
        if (c == "Saxon" || c == "Tower") {
            if (size == 2) {
                return 200;
            } else if (size == 3) {
                return 300;
            } else if (size == 4) {
                return 400;
            } else if (size == 5) {
                return 500;
            } else if (size >= 6 && size <= 10) {
                return 600;
            } else if (size >= 11 && size <= 20) {
                return 700;
            } else if (size >= 21 && size <= 30) {
                return 800;
            } else if (size >= 31 && size <= 40) {
                return 900;
            } else if (size >= 41) {
                return 1000;
            } else if (c == "American" || c == "Festival" || c == "Worldwide") {
                if (size == 2) {
                    return 300;
                } else if (size == 3) {
                    return 400;
                } else if (size == 4) {
                    return 500;
                } else if (size == 5) {
                    return 600;
                } else if (size >= 6 && size <= 10) {
                    return 700;
                } else if (size >= 11 && size <= 20) {
                    return 800;
                } else if (size >= 21 && size <= 30) {
                    return 900;
                } else if (size >= 31 && size <= 40) {
                    return 1000;
                } else if (size >= 41) {
                    return 1100;
                }
            } else if (c == "Continental" || c == "Imperial") {
                if (size == 2) {
                    return 400;
                } else if (size == 3) {
                    return 500;
                } else if (size == 4) {
                    return 600;
                } else if (size == 5) {
                    return 700;
                } else if (size >= 6 && size <= 10) {
                    return 800;
                } else if (size >= 11 && size <= 20) {
                    return 900;
                } else if (size >= 21 && size <= 30) {
                    return 1000;
                } else if (size >= 31 && size <= 40) {
                    return 1100;
                } else if (size >= 41) {
                    return 1200;
                }
            }
        }
        return 0;
    }

    public void bonusValue(String corpName, int corpSize, Player p1, Player p2) {
        if (corpName == "Saxon") {
            int majorValSaxon = checkValue(corpName, corpSize) * 10;
            int minorValSaxon = majorValSaxon / 2;
            if (p1.getSaxonStock() > p2.getSaxonStock()) {
                if (p1.getSaxonStock() > 0) {
                    p1.addMoney(majorValSaxon);
                }
                if (p2.getSaxonStock() > 0) {
                    p2.addMoney(minorValSaxon);
                }
            } else {
                if (p2.getSaxonStock() > 0) {
                    p2.addMoney(majorValSaxon);
                }
                if (p1.getSaxonStock() > 0) {
                    p1.addMoney(minorValSaxon);
                }
            }
        } else if (corpName == "Tower") {
            int majorValTower = checkValue(corpName, corpSize) * 10;
            int minorValTower = majorValTower / 2;
            if (p1.getTowerStock() > p2.getTowerStock()) {
                if (p1.getTowerStock() > 0) {
                    p1.addMoney(majorValTower);
                }
                if (p2.getTowerStock() > 0) {
                    p2.addMoney(minorValTower);
                }
            } else {
                if (p2.getTowerStock() > 0) {
                    p2.addMoney(majorValTower);
                }
                if (p1.getTowerStock() > 0) {
                    p1.addMoney(minorValTower);
                }
            }
        } else if (corpName == "American") {
            int majorValAmerican = checkValue(corpName, corpSize) * 10;
            int minorValAmerican = majorValAmerican / 2;
            if (p1.getAmericanStock() > p2.getAmericanStock()) {
                if (p1.getAmericanStock() > 0) {
                    p1.addMoney(majorValAmerican);
                }
                if (p2.getAmericanStock() > 0) {
                    p2.addMoney(minorValAmerican);
                }
            } else {
                if (p2.getAmericanStock() > 0) {
                    p2.addMoney(majorValAmerican);
                }
                if (p1.getAmericanStock() > 0) {
                    p1.addMoney(minorValAmerican);
                }
            }
        } else if (corpName == "Festival") {
            int majorValFestival = checkValue(corpName, corpSize) * 10;
            int minorValFestival = majorValFestival / 2;
            if (p1.getFestivalStock() > p2.getFestivalStock()) {
                if (p1.getFestivalStock() > 0) {
                    p1.addMoney(majorValFestival);
                }
                if (p2.getFestivalStock() > 0) {
                    p2.addMoney(minorValFestival);
                }
            } else {
                if (p2.getFestivalStock() > 0) {
                    p2.addMoney(majorValFestival);
                }
                if (p1.getFestivalStock() > 0) {
                    p1.addMoney(minorValFestival);
                }
            }
        } else if (corpName == "Worldwide") {
            int majorValWorldwide = checkValue(corpName, corpSize) * 10;
            int minorValWorldwide = majorValWorldwide / 2;
            if (p1.getWorldwideStock() > p2.getWorldwideStock()) {
                if (p1.getWorldwideStock() > 0) {
                    p1.addMoney(majorValWorldwide);
                }
                if (p2.getWorldwideStock() > 0) {
                    p2.addMoney(minorValWorldwide);
                }
            } else {
                if (p2.getWorldwideStock() > 0) {
                    p2.addMoney(majorValWorldwide);
                }
                if (p1.getWorldwideStock() > 0) {
                    p1.addMoney(minorValWorldwide);
                }
            }
        } else if (corpName == "Continental") {
            int majorValContinental = checkValue(corpName, corpSize) * 10;
            int minorValContinental = majorValContinental / 2;
            if (p1.getContinentalStock() > p2.getContinentalStock()) {
                if (p1.getContinentalStock() > 0) {
                    p1.addMoney(majorValContinental);
                }
                if (p2.getContinentalStock() > 0) {
                    p2.addMoney(minorValContinental);
                }
            } else {
                if (p2.getContinentalStock() > 0) {
                    p2.addMoney(majorValContinental);
                }
                if (p1.getContinentalStock() > 0) {
                    p1.addMoney(minorValContinental);
                }
            }
        } else if (corpName == "Imperial") {
            int majorValImperial = checkValue(corpName, corpSize) * 10;
            int minorValImperial = majorValImperial / 2;
            if (p1.getImperialStock() > p2.getImperialStock()) {
                if (p1.getImperialStock() > 0) {
                    p1.addMoney(majorValImperial);
                }
                if (p2.getImperialStock() > 0) {
                    p2.addMoney(minorValImperial);
                }
            } else {
                if (p2.getImperialStock() > 0) {
                    p2.addMoney(majorValImperial);
                }
                if (p1.getImperialStock() > 0) {
                    p1.addMoney(minorValImperial);
                }
            }
        }
    }
}

