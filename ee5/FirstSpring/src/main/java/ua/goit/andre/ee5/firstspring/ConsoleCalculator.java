package ua.goit.andre.ee5.firstspring;

import ua.goit.andre.ee5.OperationExecutor;

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
        System.out.print("Please enter operation in format 'Operation',Operand1,Operand2'. for Example '+,2,2':");
        String operation = kbdInput.next();
        System.out.println(executor.execute(operation));
    }
}
