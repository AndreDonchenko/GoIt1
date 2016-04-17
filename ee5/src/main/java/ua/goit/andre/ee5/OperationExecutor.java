package ua.goit.andre.ee5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 15.04.2016.
 */
public class OperationExecutor {
    private List <Operation> operations = new ArrayList<>();

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    public String execute(String argsString) {
        for (Operation operation : operations) {
            String result = operation.getResult(argsString);
            if (result != null) {
                return result;
            }
        }
        return "Operation not supported";
    }
}
