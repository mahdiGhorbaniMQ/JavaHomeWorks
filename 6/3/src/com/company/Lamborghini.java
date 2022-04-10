package com.company;

public class Lamborghini implements Car{
    int speed = 550;

    public Lamborghini(){}

    @Override
    public void drive(){
        System.out.println("Lamborghini drive with " + speed);
    }
}
