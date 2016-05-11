package ua.goit.andre.ee2;

import ua.goit.andre.ee2.NumberTasks.IntTask;
import ua.goit.andre.ee2.NumberTasks.LongTask;
import ua.goit.andre.ee2.NumberTasks.NumberValidator;
import ua.goit.andre.ee2.StringTasks.StrTask;
import ua.goit.andre.ee2.StringTasks.StringValidator;
import ua.goit.andre.ee2.TaskExecutor.ExecutorImpl;
import ua.goit.andre.ee2.TaskExecutorInterface.Executor;
import ua.goit.andre.ee2.TaskExecutorInterface.Task;
import ua.goit.andre.ee2.TaskExecutorInterface.Validator;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void test(List<Task<Integer>> intTasks) {
        Executor testExecutor = new ExecutorImpl<>();

        Validator numValidator = new NumberValidator();
        Validator strValidator = new StringValidator();

        for (Task<Integer> intTask : intTasks) {
            testExecutor.addTask(intTask);
        }

        testExecutor.addTask(new LongTask(100L), numValidator);
        testExecutor.addTask(new LongTask(111L), numValidator);
        testExecutor.addTask(new LongTask(200L), numValidator);
        testExecutor.addTask(new LongTask(222L), numValidator);
        testExecutor.addTask(new LongTask(300L), numValidator);
        testExecutor.addTask(new LongTask(333L), numValidator);

        testExecutor.addTask(new StrTask("www-google-com"), strValidator);
        testExecutor.addTask(new StrTask("www-liga-net"), strValidator);
        testExecutor.addTask(new StrTask("ukr+net"), strValidator);

        //testExecutor.getInvalidResults(); //IllegalStateException check

        testExecutor.execute();

       // testExecutor.addTask(new StrTask("ukr+net"), strValidator); //IllegalStateException check

        System.out.println("Valid results:");
        for (Object o : testExecutor.getValidResults()) {
            System.out.println(o);
        }
        System.out.println("Invalid results:");
        for (Object o : testExecutor.getInvalidResults()) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        List<Task<Integer>> intTasks= new ArrayList<>();
        intTasks.add(new IntTask(511));
        intTasks.add(new IntTask(522));
        intTasks.add(new IntTask(533));
        test(intTasks);
    }
}
