package ua.goit.andre.ee5;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Andre on 17.04.2016.
 */
public class OperationExecutorTest {

    @org.junit.Test
    public void testExecute() throws Exception {
        OperationExecutor operationExecutor = new OperationExecutor();
        operationExecutor.addOperation(new OperationAdd());
        operationExecutor.addOperation(new OperationSub());
        Assert.assertEquals("2+3=5", operationExecutor.execute("+,2,3"));
        Assert.assertEquals("2.2+3.3=5.5", operationExecutor.execute("+,2.2,3.3"));
        Assert.assertEquals("3-2=1", operationExecutor.execute("-,3,2"));
        Assert.assertEquals("5.5-2.2=3.3", operationExecutor.execute("-,5.5,2.2"));
    }
}