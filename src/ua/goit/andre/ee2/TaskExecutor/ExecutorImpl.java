package ua.goit.andre.ee2.TaskExecutor;

import ua.goit.andre.ee2.TaskExecutorInterface.Executor;
import ua.goit.andre.ee2.TaskExecutorInterface.Task;
import ua.goit.andre.ee2.TaskExecutorInterface.Validator;

import java.util.ArrayList;
import java.util.List;

class TaskValidatorContainer<T> {
    public Task<T> task;
    public Validator<T> validator;

    public TaskValidatorContainer(Task<T> task, Validator<T> validator) {
        this.task = task;
        this.validator = validator;
    }
}

public class ExecutorImpl<T> implements Executor {
    private boolean isExecuted = false;
    private List<TaskValidatorContainer<T>> tasks = new ArrayList<>();
    private List<T> validResults;
    private List<T> invalidResults;

    @Override
    public void addTask(Task task) {
        tasks.add(new TaskValidatorContainer<T>(task, null));
    }

    @Override
    public void addTask(Task task, Validator validator) {
        tasks.add(new TaskValidatorContainer<T>(task, validator));
    }

    @Override
    public void execute() {
        if (isExecuted) return;
        isExecuted = true;
        validResults = new ArrayList<>();
        invalidResults = new ArrayList<>();
        for (TaskValidatorContainer<T> task: tasks) {
            if (null == task.validator) {
                task.task.execute();
                validResults.add(task.task.getResult());
            } else {
                task.task.execute();
                if (task.validator.isValid(task.task.getValue())) {
                    validResults.add(task.task.getResult());
                } else {
                    invalidResults.add(task.task.getResult());
                }
            }
        }
    }

    @Override
    public List<T> getValidResults() throws IllegalStateException {
        if (isExecuted) {
            return validResults;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public List<T> getInvalidResults() throws IllegalStateException {
            if (isExecuted) {
                return invalidResults;
            } else {
                throw new IllegalStateException();
            }
    }

}
