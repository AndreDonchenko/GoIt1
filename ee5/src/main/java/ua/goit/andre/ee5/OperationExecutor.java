package ua.goit.andre.ee5;

import java.util.ArrayList;
import java.util.List;

public class OperationExecutor {
    private List <Operation> operations;

    public OperationExecutor (OperationProvider operationProvider) {
        this.operations = operationProvider.getOperations();
    }

    public String execute(String argsString) {
        if ((argsString==null) || (argsString.length()==0)) {
            throw (new IllegalArgumentException("Empty operation string detected"));
        }
        for (Operation operation : operations) {
            String result = operation.getResult(argsString);
            if (result != null) {
                return result;
            }
        }
        throw (new IllegalArgumentException("Operation not supported"));
    }
}
