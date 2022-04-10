package com.company;

public class Ferrari implements Car{
    int speed = 500;

    public Ferrari(){}

    @Override
    public void drive(){
        System.out.println("Ferrari drive with " + speed);
    }
}
