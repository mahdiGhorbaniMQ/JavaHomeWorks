package com.company;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);
    private static Input input;
    public static Input getInstance() {
        if (input == null) input = new Input();
        return input;
    }
    public String getString(String message){
        System.out.print(message);
        return scanner.nextLine();
    }
    public int getInteger(String message){
        System.out.print(message);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
    private Input(){}
}
