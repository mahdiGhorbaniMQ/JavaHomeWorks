package com.example.test;

public class AuthException extends Exception{
    public AuthException(){
        super();
    }
    public AuthException(String message){
        super(message);
    }
}
