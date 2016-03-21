package ua.goit.andre.ee2.TaskExecutorInterface;

public interface Task<T> {

    T getValue();

    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    T getResult();
}
