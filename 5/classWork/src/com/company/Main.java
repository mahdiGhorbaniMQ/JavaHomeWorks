package com.company;

public class Main {

    public static void main(String[] args) {
        User user = new User(
                "mahdi",
                "ghorbani",
                18,
                "mahdi",
                "123456789"
        );

        System.out.println("name: " + user.getName());
        System.out.println("family: " + user.getFamily());
        System.out.println("age: " + user.getAge());
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
    }
}
