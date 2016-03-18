package ua.goit.andre.ee2;

import java.util.List;

/**
 * Created by Andre on 17.03.2016.
 */
public class Runner {
    public void test(List<Task<Integer>> intTasks) {
        Executor<Number> numberExecutor = new ExecutorNumber<>();

        for (Task<Integer> intTask : intTasks) {
            numberExecutor.addTask(intTask);
        }
        numberExecutor.addTask(new LongTask(10L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }

}
