package com.company.exception;

public class AuthException extends Exception{
    public AuthException(){
        super();
    }
    public AuthException(String message){
        super(message);
    }
}
