package com.company;

public class BMV implements Car{
    int speed = 400;

    public BMV(){}

    @Override
    public void drive(){
        System.out.println("BMV drive with " + speed);
    }
}
