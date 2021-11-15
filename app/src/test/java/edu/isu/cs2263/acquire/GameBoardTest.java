package edu.isu.cs2263.acquire;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static edu.isu.cs2263.acquire.Corporation.*;
import static edu.isu.cs2263.acquire.GameBoard.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameBoardTest {
    //Test drawing tiles
    @Test
    public void testDrawTiles(){
        GameBoard game = new GameBoard();
        String tile = game.drawTile();
        assertNotNull(tile);
    }
    //Test checking right adjacency
    @Test
    public void testCheckRight(){
        GameBoard game = new GameBoard();
        assertTrue(checkRight(2,3));
    }
    //Test checking left adjacency
    @Test
    public void testCheckLeft(){
        GameBoard game = new GameBoard();
        assertTrue(checkLeft(3,2));
    }
    //Test checking up adjacency
    @Test
    public void testCheckUp(){
        GameBoard game = new GameBoard();
        assertTrue(checkUp('A','B'));
    }
    //Test checking down adjacency
    @Test
    public void testCheckDown(){
        GameBoard game = new GameBoard();
        assertTrue(checkDown('B','A'));
    }
    //Test for obtaining character from a tile string
    @Test
    public void testSplitChar(){
        char cha = splitChar("2A");
        assertEquals('A', cha);



    }
    //Test for obtaining number from a tile string
    @Test
    public void testSplitNum(){
        int cha = splitNum("2A");
        assertEquals(2, cha);
    }

}
