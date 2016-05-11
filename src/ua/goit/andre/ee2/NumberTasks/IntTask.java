package ua.goit.andre.ee2.NumberTasks;

import ua.goit.andre.ee2.TaskExecutorInterface.Task;


public class IntTask implements Task<Integer> {
    private int a;
    private Integer result;

    public IntTask(int a) {
        this.a = a;
    }

    @Override
    public Integer getValue() {
        return a;
    }

    @Override
    public void execute() {
        result = a / 10;
    }

    @Override
    public Integer getResult() {
        return result;
    }
}
