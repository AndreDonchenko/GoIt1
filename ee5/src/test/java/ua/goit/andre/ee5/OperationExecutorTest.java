package ua.goit.andre.ee5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Andre on 17.04.2016.
 */
public class OperationExecutorTest {
    private OperationExecutor operationExecutor;

    @Before
    public void setUp() {
        operationExecutor = new OperationExecutor(new OperationProvider());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNull() {
        Assert.assertEquals("", operationExecutor.execute(null));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEmptyArguments() {
        Assert.assertEquals("", operationExecutor.execute(""));
    }

    @Test (expected = IllegalArgumentException.class)
    public void unsupportedOperation() {
        Assert.assertEquals("5.5-2.2=3.3", operationExecutor.execute("-,a,b"));
    }


    @Test
    public void testExecute() throws Exception {
        Assert.assertEquals("2+3=5", operationExecutor.execute("+,2,3"));
        Assert.assertEquals("2.2+3.3=5.5", operationExecutor.execute("+,2.2,3.3"));
        Assert.assertEquals("3-2=1", operationExecutor.execute("-,3,2"));
        Assert.assertEquals("5.5-2.2=3.3", operationExecutor.execute("-,5.5,2.2"));
        //Assert.assertEquals("5.5-2.2=3.3", operationExecutor.execute("-,a,b"));
    }
}