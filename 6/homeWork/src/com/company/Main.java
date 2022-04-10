package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = new String[4];

        System.out.print("Enter name: ");
        input[0] = scanner.nextLine();

        System.out.print("Enter username: ");
        input[1] = scanner.nextLine();

        System.out.print("Enter password: ");
        input[2] = scanner.nextLine();

        System.out.print("Enter age: ");
        input[3] = scanner.nextLine();

        User user = new User();

        user
                .setName(FormatController.getInstance()
                        .checkName(input[0])
                        ?input[0]
                        :null
                )
                .setUsername(FormatController.getInstance()
                        .checkUsername(input[1])
                        ?input[1]
                        :null
                )
                .setPassword(FormatController.getInstance()
                        .checkPassword(input[2])
                        ?input[2]
                        :null
                )
                .setAge(FormatController.getInstance()
                        .checkAge(Integer.parseInt(input[3]))
                        ?Integer.parseInt(input[3])
                        :-1
                );

        System.out.println("________________________________");
        System.out.println(user.toString());
    }
}
