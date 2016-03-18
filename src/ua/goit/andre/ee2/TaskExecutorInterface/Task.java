package ua.goit.andre.ee2.TaskExecutorInterface;

/**
 * Created by Andre on 16.03.2016.
 */
public interface Task<T> {

    T getValue();

    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    T getResult();
}
