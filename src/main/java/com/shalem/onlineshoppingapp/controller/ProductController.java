package com.shalem.onlineshoppingapp.controller;

import com.shalem.onlineshoppingapp.entity.Product;
import com.shalem.onlineshoppingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<>( productService.addProducts(product), HttpStatus.CREATED);

    }

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
    }


}
