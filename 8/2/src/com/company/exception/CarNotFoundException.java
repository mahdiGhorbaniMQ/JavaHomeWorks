package com.company.exception;

public class CarNotFoundException extends Exception{
    public CarNotFoundException(){
        super();
    }
    public CarNotFoundException(String message){
        super(message);
    }
}
