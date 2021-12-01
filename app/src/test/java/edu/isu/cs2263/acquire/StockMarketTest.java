package edu.isu.cs2263.acquire;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static edu.isu.cs2263.acquire.Corporation.*;
import static org.junit.jupiter.api.Assertions.*;
public class StockMarketTest {
    //Test for buying stock
    @Test
    public void testBuyStock(){
        Corporation Tower = new Corporation("Tower", 6, "Red");
        Player player1 = new Player("player1", 5000);
        Stock_Market stonks = new Stock_Market();
        stonks.buyStock(player1, Tower);

        assertEquals(1, player1.getTowerStock());
        assertEquals(4400, player1.getMoney());
        assertEquals(24, stonks.getTowerStockAvail() );
    }

    //Test for selling stock
    @Test
    public void testSellStock(){
        Corporation Tower = new Corporation("Tower", 6, "Red");
        Player player1 = new Player("player1", 5000);
        Stock_Market stonks = new Stock_Market();

        stonks.buyStock(player1, Tower);

        stonks.sellStock(player1, Tower);

        assertEquals(0, player1.getTowerStock());
        assertEquals(5000, player1.getMoney());
        assertEquals(25, stonks.getTowerStockAvail() );

    }
    //Test for checking value of a corporation
    @Test
    public void testCheckValue(){
        Corporation Tower = new Corporation("Tower", 6, "Red");
        Stock_Market stonks = new Stock_Market();

        int x = stonks.checkValue(Tower);

        assertEquals(600, x);
    }



}
