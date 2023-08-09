package com.shalem.onlineshoppingapp.Exception;

public class OutOfStockException extends RuntimeException{

    public OutOfStockException(String message) {
        super(message);
    }
}
