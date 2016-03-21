package ua.goit.andre.ee2.NumberTasks;

import ua.goit.andre.ee2.TaskExecutorInterface.Task;


public class IntTask implements Task {
    private int a;
    private Integer result;

    public IntTask(int a) {
        this.a = a;
    }

    @Override
    public Object getValue() {
        return a;
    }

    @Override
    public void execute() {
        result = a / 10;
    }

    @Override
    public Object getResult() {
        return result;
    }
}
