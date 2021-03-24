package vop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RecursiveBinarySearchTest {
    private static final int[] FIBOS = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

    @Before
    public void setUp() throws Exception {


    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void shouldFindIndexOfNumber() {

        int test = RecursiveBinarySearch.recursiveFind(FIBOS, 5);

        assertEquals(4,test);


    }
    @Test
    public void shouldReturnNegativeInsertionPointWhenNotFound() {

        int test = RecursiveBinarySearch.recursiveFind(FIBOS, 4);

        assertTrue(test < 0 );


    }
}