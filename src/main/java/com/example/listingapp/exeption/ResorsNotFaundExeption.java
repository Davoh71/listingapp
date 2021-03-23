package com.example.listingapp.exeption;

public class ResorsNotFaundExeption extends RuntimeException{
    public ResorsNotFaundExeption() {
    }
    public ResorsNotFaundExeption(String message) {
        super(message);
    }
}
