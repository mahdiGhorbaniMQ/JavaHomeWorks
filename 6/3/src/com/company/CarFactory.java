package com.company;

public class CarFactory {
    public static Car getCar(Car.Brands brand){
        switch (brand){
            case BMW: return new BMV();
            case Audi: return new Audi();
            case Ferrari: return new Ferrari();
            case Benz: return new Benz();
            case Porsche: return new Porsche();
            case Lamborghini: return new Lamborghini();
            default: return null;
        }
    }
}
