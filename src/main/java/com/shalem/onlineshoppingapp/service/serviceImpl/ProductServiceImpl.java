package com.shalem.onlineshoppingapp.service.serviceImpl;

import com.shalem.onlineshoppingapp.entity.Product;
import com.shalem.onlineshoppingapp.repository.ProductRepository;
import com.shalem.onlineshoppingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProducts(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }


}
