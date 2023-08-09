package com.shalem.onlineshoppingapp.security;

import com.shalem.onlineshoppingapp.Exception.CustomerNotFoundException;
import com.shalem.onlineshoppingapp.entity.Customer;
import com.shalem.onlineshoppingapp.repository.AuthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AuthRepository authRepository;
    @Override
    public UserDetails loadUserByUsername(String loginIdOrEmail ) throws UsernameNotFoundException {
        Customer customer=authRepository.findByLoginIdOrEmail(loginIdOrEmail, loginIdOrEmail).orElseThrow(()-> new UsernameNotFoundException("loginId or email does not exists"));
        log.info(customer.toString());
        Set<GrantedAuthority> grantedAuthorities=customer.getRole().stream().map((role)->new SimpleGrantedAuthority(role)).collect(Collectors.toSet());
        return new User(customer.getLoginId(),customer.getPassword(),grantedAuthorities);
    }
}
