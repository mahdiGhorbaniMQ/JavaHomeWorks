package com.company;

import java.util.Scanner;

public class IO {

    private Scanner scanner = new Scanner(System.in);
    private IO(){}

    private static final IO instance = new IO();

    public static IO getInstance() {
        return instance;
    }

    public String getString(String message){
        System.out.println(message);
        return scanner.next();
    }
    public int getInteger(String message){
        System.out.println(message);
        return scanner.nextInt();
    }
    public float getFloat(String message){
        System.out.println(message);
        return scanner.nextFloat();
    }
}
