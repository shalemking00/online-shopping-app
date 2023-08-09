package com.shalem.onlineshoppingapp.service;

import com.shalem.onlineshoppingapp.dto.CustomerDto;
import com.shalem.onlineshoppingapp.entity.Customer;

import java.util.List;

public interface AuthService {

    public Customer newCustomer(CustomerDto customerDto);

    List<Customer> getAll();

    String login(String loginId, String password);
}
