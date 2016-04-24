package ua.goit.andre.ee5;

/**
 * Created by Andre on 24.04.2016.
 */
public class OperationProviderExtender extends OperationProvider {

    public OperationProviderExtender() {
        super();
        addOperation(new OperationMultiply());
        addOperation(new OperationDivide());
    }
}
