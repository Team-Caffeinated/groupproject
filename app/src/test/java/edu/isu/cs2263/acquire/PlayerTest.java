package edu.isu.cs2263.acquire;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    //Test for adding tile to player hand
    @Test
    public void testAddTile(){
        Player player1 = new Player("Player1", 5);
        player1.addTile("1A");
        assertEquals("1A", (player1.getHand()).get(0));
    }

    //Test for removing tiles from player hand
    @Test
    public void testRemoveTile(){
        Player player1 = new Player("Player1", 5);
        player1.addTile("1A");
        player1.removeTile("1A");
        assertTrue((player1.getHand()).isEmpty());
    }

    //Test for removing player's money
    @Test
    public void testRemoveMoney(){
        Player player1 = new Player("Player1", 5);
        player1.removeMoney(5);
        assertEquals(0, player1.getMoney());
    }

    //Test for adding money
    @Test
    public void addMoney(){
        Player player1 = new Player("Player1", 0);
        player1.addMoney(5);
        assertEquals(5, player1.getMoney());
    }
}
