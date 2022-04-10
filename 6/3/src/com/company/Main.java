package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chose the brand from (BMV, Audi, Lamborghini, Ferrari, Benz, Porsche):");
        String brand = scanner.nextLine();
        Car car = CarFactory.getCar(Car.Brands.valueOf(brand));
        assert car != null;
        car.drive();
    }
}
