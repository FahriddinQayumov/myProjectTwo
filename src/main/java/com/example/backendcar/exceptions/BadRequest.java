package com.example.backendcar.exceptions;

public class BadRequest extends RuntimeException{
    public BadRequest(String message){
        super(message);
    }
}
