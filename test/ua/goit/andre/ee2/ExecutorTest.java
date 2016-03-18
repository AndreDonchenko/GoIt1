package ua.goit.andre.ee2;

import org.junit.Assert;
import org.junit.Test;

import ua.goit.andre.ee2.NumberTasks.NumberValidator;
import ua.goit.andre.ee2.TaskExecutor.ExecutorImpl;
import ua.goit.andre.ee2.TaskExecutorInterface.Executor;
import ua.goit.andre.ee2.TaskExecutorInterface.Validator;

import java.util.List;



public class ExecutorTest {
    ua.goit.andre.ee2.TaskExecutorInterface.Executor<Number> testExecutor = new ExecutorImpl<>();

    Validator numValidator = new NumberValidator();


}
