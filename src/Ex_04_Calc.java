//4*. К калькулятору из предыдущего дз добавить логирование.

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Ex_04_Calc {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = reader.nextDouble();
        System.out.print("Enter second number: ");
        double b = reader.nextDouble();
        System.out.print("Enter an operator (+ - * /): ");
        String oper = reader.next();
        double res = calc(a, oper, b);
        log_result(a, b, oper, res);
        System.out.printf("Result: " + a + " " + oper + " " + b + " = " + res);
    }
        static double calc(double a, String oper, double b) {
            double res;
            switch(oper) {
                case "+": res = a + b;
                break;
                case "-": res = a - b;
                break;
                case "*": res = a * b;
                break;
                case "/":
                    if (b == 0) {
                        System.out.print("На 0 делить нельзя!!!");
                    }
                    res = a / b;
                    break;
                default: throw new IllegalArgumentException("Error! Enter correct operator");
            }
            return res;
        }
    static void log_result(double a, double b, String oper, double res) throws IOException {
        Logger logger = Logger.getLogger(Ex_04_Calc.class.getName());
        FileHandler fh = new FileHandler("logCalc.txt", true);
        logger.addHandler(fh);
        logger.setUseParentHandlers(false);

        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);

        StringBuilder sb = new StringBuilder("");
        sb.append(a).append(" ").append(oper).append(" ").append(b)
                .append(" = ").append(res).append("\n");
        String result = sb.toString();
        logger.log(Level.INFO, result);
    }
}
