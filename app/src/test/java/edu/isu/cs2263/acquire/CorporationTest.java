package edu.isu.cs2263.acquire;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static edu.isu.cs2263.acquire.Corporation.*;
import static org.junit.jupiter.api.Assertions.*;

public class CorporationTest {


    //Test to Increase Size
    @Test
    @DisplayName("Increase Size Test")
    public void testIncreaseSize(){
        Corporation Corporation1 = new Corporation("Corporation1", 1, "Green");

        Corporation1.increaseSize(1, "1A");
        int size = Corporation1.getSize();
        assertEquals(2, size);

        List<String> String = new ArrayList<>();
        String = Corporation1.getTiles();
        assertEquals("1A", String.get(0), "Test Succeeded");
    }

    //Test for merging 2 corporations
    @Test
    public void testMerge(){
        Corporation Corporation1 = new Corporation("Corporation1", 4, "Green");
        Corporation Corporation2 = new Corporation("Corporation2", 3, "Green");
        List<String> List1 = new ArrayList<>();
        List1.add("1A");
        List1.add("2A");
        List1.add("3A");
        List1.add("4A");
        List<String> List3 = new ArrayList<>();
        List1.add("1C");
        List1.add("2C");
        List1.add("3C");
        merge(Corporation1, Corporation2, "2B");
        assertEquals(8, Corporation1.getSize());
        assertEquals(0, Corporation2.getSize());
    }
    //Test for merging 3 corporations
    @Test
    public void testMerge3(){
        Corporation Corporation1 = new Corporation("Corporation1", 2, "Green");
        Corporation Corporation2 = new Corporation("Corporation2", 1, "Green");
        Corporation Corporation3 = new Corporation("Corporation3", 1, "Green");
        List<String> List1 = new ArrayList<>();
        List1.add("1A");
        List1.add("2A");
        List<String> List2 = new ArrayList<>();
        List1.add("2C");
        List<String> List3 = new ArrayList<>();
        List1.add("3B");
        Corporation1.setTiles(List1);
        Corporation2.setTiles(List2);
        Corporation3.setTiles(List3);

        merge3(Corporation1, Corporation2, Corporation3, "2B");
        assertEquals(5, Corporation1.getSize());
        assertEquals(0, Corporation2.getSize());
        assertEquals(0, Corporation3.getSize());
    }
    //Test for merging 4 corporations
    @Test
    public void testMerge4(){
        Corporation Corporation1 = new Corporation("Corporation1", 2, "Green");
        Corporation Corporation2 = new Corporation("Corporation2", 1, "Green");
        Corporation Corporation3 = new Corporation("Corporation3", 1, "Green");
        Corporation Corporation4 = new Corporation("Corporation4", 1, "Green");
        List<String> List1 = new ArrayList<>();
        List1.add("1A");
        List1.add("2A");
        List<String> List2 = new ArrayList<>();
        List1.add("2C");
        List<String> List3 = new ArrayList<>();
        List1.add("3B");
        List<String> List4 = new ArrayList<>();
        List1.add("1B");
        Corporation1.setTiles(List1);
        Corporation2.setTiles(List2);
        Corporation3.setTiles(List3);
        Corporation4.setTiles(List4);

        merge4(Corporation1, Corporation2, Corporation3, Corporation4, "2B");
        assertEquals(6, Corporation1.getSize());
        assertEquals(0, Corporation2.getSize());
        assertEquals(0, Corporation3.getSize());
        assertEquals(0, Corporation4.getSize());
    }

    @Test
    public void testResetSize(){
        Corporation Corporation1 = new Corporation("Corporation1", 2, "Green");
        Corporation1.resetSize();
        assertEquals(0, Corporation1.getSize());
    }

    @Test
    public void testSearchList(){
        Corporation Corporation1 = new Corporation("Corporation1", 0, "Green");
        Corporation1.increaseSize(1, "1A");

        assertTrue(Corporation1.searchList("1A"));



    }




}
