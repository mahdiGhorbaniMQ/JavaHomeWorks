package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = new String[3];

        System.out.print("Enter first num: ");
        input[0] = scanner.next();

        System.out.print("Enter the operator: ");
        input[1] = scanner.next();

        System.out.print("Enter second num: ");
        input[2] = scanner.next();

        Calculate calculate;
        if (input[1].equals("+")){
            calculate = CalcFactory.getCalc(Calculate.types.PLUS);
        }
        else if (input[1].equals("-")){
            calculate = CalcFactory.getCalc(Calculate.types.MINUS);
        }
        else {
            System.out.println("Bad operator!");
            return;
        }

        System.out.print("The result is: ");
        System.out.println(calculate.calc(
                Float.parseFloat(input[0]),
                Float.parseFloat(input[2])
        ));
    }
}
