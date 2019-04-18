package by.it.medvedeva.at13_calc;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Parser parser=new Parser();
        Printer printer=new Printer();
        Scanner scanner=new Scanner(System.in);
        for(;;){
            String expression=scanner.nextLine();
            if (expression.equals("end"))
                break;
            Var var = parser.calc(expression);
            printer.print(var);
        }
    }
}
