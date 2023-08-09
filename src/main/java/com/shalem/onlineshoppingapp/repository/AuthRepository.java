package com.shalem.onlineshoppingapp.repository;

import com.shalem.onlineshoppingapp.entity.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthRepository extends MongoRepository<Customer, ObjectId> {

    Boolean existsByEmail(String email);
    Boolean existsByLoginId(String loginId);

    Optional<Customer> findByLoginIdOrEmail(String loginId,String email);

}
