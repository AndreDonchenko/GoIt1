package ua.goit.andre.ee5;

/**
 * Created by Andre on 24.04.2016.
 */
public class OperationMultiply implements Operation {
    @Override
    public String getResult(String argsString) {
        String [] operands = argsString.trim().split(",");
        if (operands[0].equals("*") && operands.length == 3) {
            try {
                if (operands[1].contains(".") || operands[2].contains(".")) {
                    double a = Double.parseDouble(operands[1]);
                    double b = Double.parseDouble(operands[2]);
                    return a + "*" + b + "=" + (a * b);
                } else {
                    long a = Long.parseLong(operands[1]);
                    long b = Long.parseLong(operands[2]);
                    return a + "*" + b + "=" + (a * b);
                }
            } catch (NumberFormatException e) {
                return null;
            }
        } else return null;

    }
}
