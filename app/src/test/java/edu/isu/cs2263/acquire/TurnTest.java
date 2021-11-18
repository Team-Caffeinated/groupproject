package edu.isu.cs2263.acquire;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static edu.isu.cs2263.acquire.Turn.distanceTo1A;
import static org.junit.jupiter.api.Assertions.*;

public class TurnTest {

    //Test for checking distance from 1A
    @Test
    public void testDistanceTo1A(){
        Tile tiles = new Tile();
        assertEquals(1, distanceTo1A("1A"));
    }


}
