package com.company;

public class Benz implements Car{
    int speed = 450;

    public Benz(){}

    @Override
    public void drive(){
        System.out.println("Benz drive with " + speed);
    }
}
