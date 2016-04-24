package ua.goit.andre.ee5;

import java.util.Scanner;

/**
 * Created by Andre on 24.04.2016.
 */
public class ConsoleCalculator {
    private OperationExecutor executor;

    public ConsoleCalculator(OperationExecutor executor) {
        this.executor = executor;
    }

    public void execute() {
        Scanner kbdInput=new Scanner(System.in);
        System.out.print("Please enter operation:");
        String operation = kbdInput.next();
        System.out.println(executor.execute(operation));
    }
}
