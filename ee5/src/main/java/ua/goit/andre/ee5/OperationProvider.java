package ua.goit.andre.ee5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 24.04.2016.
 */
public class OperationProvider {
    private List<Operation> operations;

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    public OperationProvider () {
        operations = new ArrayList<>();
        addOperation(new OperationAdd());
        addOperation(new OperationSub());
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
