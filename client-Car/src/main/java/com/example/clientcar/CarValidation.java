package com.example.clientcar;


public class CarValidation extends RuntimeException{

    public CarValidation(String message) {
        super(message);
    }
}