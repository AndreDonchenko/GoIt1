package ua.goit.andre.lab9;

import org.junit.Assert;
import org.junit.Test;

public class CaesarTest {
    final String TEST_STRING="012345abcdef";
    final int SHIFT=12;

    @Test
    public void testEncodeDecode() throws Exception {
        String resultStr=Caesar.encodeDecode(TEST_STRING,SHIFT);
        Assert.assertTrue(!resultStr.equals(TEST_STRING));
        Assert.assertTrue(TEST_STRING.equals(Caesar.encodeDecode(resultStr,-SHIFT)));
    }

}