package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        User user = new User();

        user.setName(Input.getInstance().getString("Enter your full name: "))
                .setAge(Input.getInstance().getInteger("Enter your age: "))
                .setUsername(Input.getInstance().getString("Enter your username: "))
                .setPassword(Input.getInstance().getString("Enter your password: "))
                .setAddress(Input.getInstance().getString("Enter your address: "))
                .setPhone(Input.getInstance().getString("Enter your phone number: "))
                .setEducation(Input.getInstance().getString("Enter your Education: "));


        System.out.println("___________________________________________");
        System.out.println(user.toString());
    }
}
