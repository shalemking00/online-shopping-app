package com.shalem.onlineshoppingapp.Exception;

public class LoginIdAlreadyExists extends RuntimeException{
    public LoginIdAlreadyExists(String message) {
        super(message);
    }
}
