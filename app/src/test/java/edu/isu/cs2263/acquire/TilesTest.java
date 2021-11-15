package edu.isu.cs2263.acquire;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class TilesTest {
    @Test
    public void testTileList(){
        Tile tiles = new Tile();
        assertEquals("2B", (tiles.wholeTiles()).get(10));
    }

}
