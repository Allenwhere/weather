package com.example.search.configuration;

import com.example.search.exception.MaximumTryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SearchControllerAdvisor {
    @ExceptionHandler(MaximumTryException.class)
    public ResponseEntity<?> resourceNotFoundHandler() {
        return new ResponseEntity<>("Too many try failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
