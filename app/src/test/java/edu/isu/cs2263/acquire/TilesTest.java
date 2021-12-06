package edu.isu.cs2263.acquire;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class TilesTest {
    @Test
    public void testTileList(){
        Tile tiles = new Tile();
        assertEquals("2B", (tiles.wholeTiles()).get(10));
    }
    /**
     * Testing neighbors function
     */
    @Test
    public void testNeighbor1(){
        Tile tile = new Tile();
        int test = tile.neighbor1("2B");
        System.out.println(test);
    }
}
