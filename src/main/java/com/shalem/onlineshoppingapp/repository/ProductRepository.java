package com.shalem.onlineshoppingapp.repository;

import com.shalem.onlineshoppingapp.entity.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, ObjectId> {
    Optional<Product> findByProductName(String name);
    Optional<Product> findBy_id(ObjectId id);
}
