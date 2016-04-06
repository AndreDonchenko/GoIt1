package ua.goit.andre.ee2.TaskExecutorInterface;


public interface Validator<T> {

    // Валидирует переданое значение
    boolean isValid(T result);

}
