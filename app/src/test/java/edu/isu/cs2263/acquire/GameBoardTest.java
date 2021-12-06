package edu.isu.cs2263.acquire;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static edu.isu.cs2263.acquire.Corporation.*;
import static edu.isu.cs2263.acquire.GameBoard.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Testing Functions in GameBoard Class
 */
public class GameBoardTest {
    //Test drawing tiles

    /**
     * Testing DrawTiles function
     */
    @Test
    public void testDrawTiles(){
        GameBoard game = new GameBoard();
        String tile = game.drawTile();
        assertNotNull(tile);
    }
    /**
     * Testing checkRight function
     */
    @Test
    public void testCheckRight(){
        GameBoard game = new GameBoard();
        assertTrue(checkRight(2,3));
    }
    /**
     * Testing checkLeft function
     */
    @Test
    public void testCheckLeft(){
        GameBoard game = new GameBoard();
        assertTrue(checkLeft(3,2));
    }
    /**
     * Testing checkUp function
     */
    @Test
    public void testCheckUp(){
        GameBoard game = new GameBoard();
        assertTrue(checkUp('A','B'));
    }
    /**
     * Testing checkDown function
     */
    @Test
    public void testCheckDown(){
        GameBoard game = new GameBoard();
        assertTrue(checkDown('B','A'));
    }
    /**
     * Testing SplitChar function
     */
    @Test
    public void testSplitChar(){
        char cha = splitChar("2A");
        assertEquals('A', cha);



    }
    /**
     * Testing SplitNum function
     */
    @Test
    public void testSplitNum(){
        int cha = splitNum("2A");
        assertEquals(2, cha);
    }

    /**
     * Testing startGame function
     */
    @Test
    public void testStartGame(){
        GameBoard game = new GameBoard();
        game.startGame();
        assertNotNull(game.getDeck());
    }
}
