package com.shalem.onlineshoppingapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class Customer {
    @Id
    private ObjectId _id;
    private String firstName;
    private String lastName;
    private String email;
    private String loginId;
    private String password;
    private Long mobile;

    private Set<String> role;

}
