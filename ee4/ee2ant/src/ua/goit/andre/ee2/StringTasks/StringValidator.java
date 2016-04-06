package ua.goit.andre.ee2.StringTasks;

import ua.goit.andre.ee2.TaskExecutorInterface.Validator;

public class StringValidator implements Validator <String>{

    @Override
    public boolean isValid(String result) {
        return result.contains("-");
    }
}
