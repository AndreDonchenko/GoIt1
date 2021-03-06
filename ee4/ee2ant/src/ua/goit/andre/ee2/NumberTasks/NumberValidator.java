package ua.goit.andre.ee2.NumberTasks;

import ua.goit.andre.ee2.TaskExecutorInterface.Validator;


public class NumberValidator implements Validator<Number> {
    @Override
    public boolean isValid(Number result) {
        return (result.longValue() % 10 == 0);
    }
}
