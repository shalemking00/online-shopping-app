package com.shalem.onlineshoppingapp.service.serviceImpl;

import com.shalem.onlineshoppingapp.Exception.EmailAlreadyExistsException;
import com.shalem.onlineshoppingapp.Exception.LoginIdAlreadyExists;
import com.shalem.onlineshoppingapp.Exception.PasswordMismatchException;
import com.shalem.onlineshoppingapp.dto.CustomerDto;
import com.shalem.onlineshoppingapp.entity.Customer;
import com.shalem.onlineshoppingapp.repository.AuthRepository;
import com.shalem.onlineshoppingapp.security.JwtTokenProvider;
import com.shalem.onlineshoppingapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Customer newCustomer(CustomerDto customerDto) {
        if(authRepository.existsByLoginId(customerDto.getLoginId())){
            throw new LoginIdAlreadyExists("Login Id already Taken!");
        }
        if(authRepository.existsByEmail(customerDto.getEmail())){
            throw new EmailAlreadyExistsException("Email already Exists");
        }
        Customer customer=new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setLoginId(customerDto.getLoginId());
        customer.setPassword(passwordEncoder.encode(passwordCheck(customerDto.getPassword(), customerDto.getConfirmPassword())));
        customer.setMobile(customerDto.getMobile());
        Set<String>roles=new HashSet<>();
        roles.add("USER");
        customer.setRole(roles);
        return authRepository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return authRepository.findAll();
    }

    @Override
    public String login(String loginId, String password) {

        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginId,password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token= jwtTokenProvider.generateToken(authentication);
        return token;
    }

    public String passwordCheck(String password,String confirmPassWord){
        if(password.equals(confirmPassWord)){
            return password;
        }
        else{
            throw new PasswordMismatchException("password and confirm password are not equal");
        }
    }



}
