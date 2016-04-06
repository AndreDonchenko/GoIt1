package ua.goit.andre.ee2.NumberTasks;

import ua.goit.andre.ee2.TaskExecutorInterface.Task;


public class LongTask implements Task<Long> {
    private long a;
    private Long result;

    public LongTask(long a) {
        this.a = a;
    }

    @Override
    public Long getValue() {
        return a;
    }

    @Override
    public void execute() {
        result = a / 10;
    }

    @Override
    public Long getResult() {
        return result;
    }
}
