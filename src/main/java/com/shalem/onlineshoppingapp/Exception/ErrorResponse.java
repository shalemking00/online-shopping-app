package com.shalem.onlineshoppingapp.Exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {
    private String message;
    private HttpStatus status;
}
