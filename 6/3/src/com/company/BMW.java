package com.company;

public class BMW implements Car{
    int speed = 400;

    public BMW(){}

    @Override
    public void drive(){
        System.out.println("BMW drive with " + speed);
    }
}
