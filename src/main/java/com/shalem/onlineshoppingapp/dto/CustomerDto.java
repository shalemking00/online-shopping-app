package com.shalem.onlineshoppingapp.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    @NotBlank(message = "first name should not be empty")
    private String firstName;

    @NotBlank(message = "last name should not be empty")
    private String lastName;

   @Email
    @NotBlank(message = "email should not be empty")
    private String email;

    @NotBlank(message = "loginId should not be empty")
    @Size(min = 6,max = 10)
    private String loginId;

    @NotBlank(message = "password must not be empty")
    @Size(min = 6,max = 14)
    private String password;

    @NotBlank(message = "please renter the password")
    @Size(min = 6,max = 14)
    private String confirmPassword;
    @NotNull(message = "mobile should not be empty")
    private Long mobile;



}
