package ua.goit.andre.lab4;


import org.junit.Assert;
import org.junit.Test;

public class TempConvertTest {

    @Test
    public void testgetTempC2F() throws Exception {
        Assert.assertEquals(32, TempConvert.getTempC2F(0),0);
        Assert.assertEquals(53.6, TempConvert.getTempC2F(12),0);
    }

    @Test
    public void testgetTempF2C() throws Exception {
        Assert.assertEquals(0, TempConvert.getTempF2C(32),0);
        Assert.assertEquals(12, TempConvert.getTempF2C(53.6),0);
    }
}