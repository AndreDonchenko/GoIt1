package ua.goit.andre.ee2.TaskExecutor;

import ua.goit.andre.ee2.TaskExecutorInterface.*;

import java.util.ArrayList;
import java.util.List;

class TaskValidatorContainer<T> {
    private Task<T> task;
    private Validator<T> validator;

    public Task<T> getTask() {
        return task;
    }

    public Validator<T> getValidator() {
        return validator;
    }

    public TaskValidatorContainer(Task<T> task, Validator<T> validator) {
        this.task = task;
        this.validator = validator;
    }
}

public class ExecutorImpl<T> implements Executor<T> {
    private boolean isExecuted = false;
    private List<TaskValidatorContainer<T>> tasks = new ArrayList<>();
    private List<T> validResults;
    private List<T> invalidResults;

    @Override
    public void addTask(Task <? extends T> task) {
        if (isExecuted) {
            throw new IllegalStateException();
        }
        tasks.add(new TaskValidatorContainer(task, null));
    }

    @Override
    public void addTask(Task <? extends T> task, Validator <? super T>validator) {
        if (isExecuted) throw new IllegalStateException();
        tasks.add(new TaskValidatorContainer(task, validator));
    }

    @Override
    public void execute() {
        if (isExecuted) return;
        isExecuted = true;
        validResults = new ArrayList<>();
        invalidResults = new ArrayList<>();
        for (TaskValidatorContainer<T> task: tasks) {
            if (null == task.getValidator ()) {
                task.getTask ().execute();
                validResults.add(task.getTask ().getResult());
            } else {
                task.getTask ().execute();
                if (task.getValidator ().isValid(task.getTask ().getValue())) {
                    validResults.add(task.getTask ().getResult());
                } else {
                    invalidResults.add(task.getTask ().getResult());
                }
            }
        }
    }

    private List<T> getResults(boolean isValid) throws IllegalStateException {
        if (!isExecuted) throw new IllegalStateException();
        if (isValid) {
            return validResults;
        } else {
            return invalidResults;
        }
    }

    @Override
    public List<T> getValidResults() {
        return getResults(true);
    }

    @Override
    public List<T> getInvalidResults() {
        return getResults(false);
    }

}
