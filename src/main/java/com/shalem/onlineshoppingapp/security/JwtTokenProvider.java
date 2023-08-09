package com.shalem.onlineshoppingapp.security;

import com.shalem.onlineshoppingapp.Exception.ShoppingException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private long jwtExpiration;

    public String generateToken(Authentication authentication){
        String username=authentication.getName();

        Date currentDate=new Date();

        Date expire=new Date(currentDate.getTime() + jwtExpiration);

        String token= Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expire)
                .signWith(key())
                .compact();

        return token;
    }

    // get username from JWT token

    public String getUsernameFromtoken(String token){
        Claims claims=Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();
        String username= claims.getSubject();
        return username;
    }

    private Key key(){
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSecret)
        );
    }

    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parse(token);
            return true;
        }catch (MalformedJwtException ex){
            throw new ShoppingException("Invalid JWT token");
        }catch (ExpiredJwtException ex){
            throw new ShoppingException("Expired JWT token");

        }catch(UnsupportedJwtException ex){
            throw new ShoppingException("Unsupported JWT token");
        }catch (IllegalArgumentException ex){
            throw new ShoppingException("Jwt claims string is empty");
        }

    }
}
