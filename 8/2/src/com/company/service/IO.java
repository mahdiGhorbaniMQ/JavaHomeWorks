package com.company.service;

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

    public int getInt(String message){
        System.out.println(message);
        return scanner.nextInt();
    }
}
