package com.shalem.onlineshoppingapp.Exception;

import org.springframework.http.HttpStatus;

public class ShoppingException extends RuntimeException{

    public ShoppingException(String message) {
        super(message);

    }
}
