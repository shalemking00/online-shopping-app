package com.shalem.onlineshoppingapp.controller;

import com.shalem.onlineshoppingapp.dto.CustomerDto;
import com.shalem.onlineshoppingapp.dto.LoginDto;
import com.shalem.onlineshoppingapp.entity.Customer;
import com.shalem.onlineshoppingapp.repository.AuthRepository;
import com.shalem.onlineshoppingapp.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Customer> register(@Valid @RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(authService.newCustomer(customerDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @CrossOrigin(origins="http://localhost:3000")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String token=authService.login(loginDto.getLoginId(),loginDto.getPassword());
        return new ResponseEntity<>(token,HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(authService.getAll(),HttpStatus.OK);
    }



}
