package com.shalem.onlineshoppingapp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> inCaseEmailAlreadyExists(EmailAlreadyExistsException e){
        ErrorResponse error=new ErrorResponse();
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoginIdAlreadyExists.class)
    public ResponseEntity<ErrorResponse> inCaseLoginIdAlreadyExists(LoginIdAlreadyExists e){
        ErrorResponse error=new ErrorResponse();
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<ErrorResponse> inCasePasswordMismatch(PasswordMismatchException e){
        ErrorResponse error=new ErrorResponse();
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ShoppingException.class)
    public ResponseEntity<ErrorResponse> inCaseShoppingException(ShoppingException e){
        ErrorResponse response=new ErrorResponse();
        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException e){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OutOfStockException.class)
    public ResponseEntity<ErrorResponse> handleOutOfStock(OutOfStockException e){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleOrderNotFoundException(OrderNotFoundException e){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }




}
