package ua.goit.andre.lab5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;


public class IntArraysToolsTest {
    final int MIN_VALUE=-5;
    final int MAX_VALUE=-5;
    private final int[] arr={3,MAX_VALUE,MIN_VALUE,1};
    int [] sortedArray;

    @Before
    public void setUp() throws Exception {
        sortedArray=arr.clone();
        Arrays.sort(sortedArray);
    }

    @Test
    public void testGetMinArrayValue() throws Exception {
        Assert.assertEquals(-5,IntArraysTools.getMinArrayValue(arr));
    }

    @Test
    public void testGetMaxArrayValue() throws Exception {
        Assert.assertEquals(-5,IntArraysTools.getMinArrayValue(arr));
    }

    @Test
    public void testSortArray() throws Exception {
        int[] resultArray=IntArraysTools.sortArray(arr,true);
        Assert.assertTrue(Arrays.equals(sortedArray,resultArray));
    }

    @Test
    public void testSortArrayBubble() throws Exception {
        int[] resultArray=IntArraysTools.sortArray(arr,true);
        Assert.assertTrue(Arrays.equals(sortedArray,resultArray));
    }
}