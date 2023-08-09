package com.shalem.onlineshoppingapp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Utils {
    public static void main(String[] args) {

        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

        System.out.println(passwordEncoder.encode("shalem"));

    }
}
