package ua.goit.andre.ee5.firstspring;

import ua.goit.andre.ee5.OperationProvider;
import ua.goit.andre.ee5.firstspring.OperationDivide;
import ua.goit.andre.ee5.firstspring.OperationMultiply;

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
