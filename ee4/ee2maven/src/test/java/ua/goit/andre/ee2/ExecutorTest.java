package ua.goit.andre.ee2;

import org.junit.Assert;
import org.junit.Test;

import ua.goit.andre.ee2.NumberTasks.LongTask;
import ua.goit.andre.ee2.NumberTasks.NumberValidator;
import ua.goit.andre.ee2.TaskExecutor.ExecutorImpl;
import ua.goit.andre.ee2.TaskExecutorInterface.Executor;
import ua.goit.andre.ee2.TaskExecutorInterface.Validator;

import java.util.List;

public class ExecutorTest {

    @Test
    public void testEmptyExecutor() throws Exception {
        Executor<Number> exec = new ExecutorImpl<>();
        exec.execute();
        List valid = exec.getValidResults();
        List inValid = exec.getInvalidResults();
    }

    @Test(expected = IllegalStateException.class)
    public void testValidResultsBeforeExecute() throws Exception {
        Executor<Number> exec = new ExecutorImpl<>();
        List valid = exec.getValidResults();
    }

    @Test(expected = IllegalStateException.class)
    public void testInValidResultsBeforeExecute() throws Exception {
        Executor<Number> exec = new ExecutorImpl<>();
        List invalid = exec.getInvalidResults();
    }

    @Test(expected = IllegalStateException.class)
    public void testAddTaskAfterExecute() throws Exception {
        Executor<Number> exec = new ExecutorImpl<>();
        exec.execute();
        exec.addTask(new LongTask(100L));
    }

    @Test(expected = IllegalStateException.class)
    public void testAddTaskValidatorAfterExecute() throws Exception {
        Executor<Number> exec = new ExecutorImpl<>();
        exec.execute();
        Validator validator = new NumberValidator();
        exec.addTask(new LongTask(100L),validator);
    }

    @Test
    public void testAddTask() throws Exception {
        Executor<Number> exec = new ExecutorImpl<>();
        exec.addTask(new LongTask(100L));
        exec.execute();
        List results = exec.getValidResults();
        Assert.assertEquals(10L,results.get(0));
    }

    @Test
    public void testAddTaskValidator() throws Exception {
        Executor<Number> exec = new ExecutorImpl<>();
        Validator numValidator = new NumberValidator();
        exec.addTask(new LongTask(100L),numValidator);
        exec.addTask(new LongTask(111L),numValidator);
        exec.execute();
        Assert.assertEquals(10L,exec.getValidResults().get(0));
        Assert.assertEquals(11L,exec.getInvalidResults().get(0));
    }
}
