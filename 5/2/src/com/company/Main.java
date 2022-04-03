package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        User user = new User();

        System.out.print("Enter your name: ");
        user.setName(scanner.next());

        System.out.print("Enter your username: ");
        user.setUsername(scanner.next());

        System.out.print("Enter your password: ");
        user.setPassword(scanner.next());

        users.add(user);
        try {
            users.add(user);

            users.add(
                    (User) user.clone()
            );
            users.add(
                    (User) user.clone()
            );
            users.add(
                    (User) user.clone()
            );
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        users.forEach(u -> {
            System.out.println("Name: " + u.getName());
            System.out.println("Username: " + u.getUsername());
            System.out.println("Password: " + u.getPassword());
            System.out.println("HashCode: " + u.hashCode());
            System.out.println("------------------------------------");
        });
    }
}
