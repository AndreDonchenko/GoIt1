package ua.goit.andre.lab4;


import org.junit.Assert;
import org.junit.Test;

public class DotLengthTest {

    @Test
    public void testgetDotLen() throws Exception {
        double x1=1;
        double x2=5;
        double y1=1;
        double y2=5;

        double result = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1, 2));
        Assert.assertEquals(result,DotLength.getDotLen(x1,y1,x2,y2),0);
    }
}