package com.shalem.onlineshoppingapp.service;

import com.shalem.onlineshoppingapp.entity.Product;

import java.util.List;

public interface ProductService {

    Product addProducts(Product product);

    List<Product> getAll();
}
