package com.company;

public class Porsche implements Car{
    int speed = 450;

    public Porsche(){}

    @Override
    public void drive(){
        System.out.println("Porsche drive with " + speed);
    }
}
