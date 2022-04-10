package com.company;

public class Audi implements Car{
    int speed = 350;

    public Audi(){}

    @Override
    public void drive(){
        System.out.println("Audi drive with " + speed);
    }
}
