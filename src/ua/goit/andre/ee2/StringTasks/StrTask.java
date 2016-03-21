package ua.goit.andre.ee2.StringTasks;

import ua.goit.andre.ee2.TaskExecutorInterface.Task;

public class StrTask implements Task<String> {
    String value;
    StringBuilder result;

    public StrTask(String value) {
        this.value = value;
        result = new StringBuilder(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void execute() {
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i)==' ') {
                result.setCharAt(i,'.');
            }
        }
    }

    @Override
    public String getResult() {
        return result.toString();
    }
}
