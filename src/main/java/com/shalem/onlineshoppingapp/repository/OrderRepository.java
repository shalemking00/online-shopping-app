package com.shalem.onlineshoppingapp.repository;

import com.shalem.onlineshoppingapp.entity.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, ObjectId> {
    Optional<Order> findBy_id(ObjectId id);
}
