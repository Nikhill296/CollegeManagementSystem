package com.college.Advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.college.Eeceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException e) {
    
    	ApiError apiError = ApiError.builder()
    							.status(HttpStatus.NOT_FOUND)
    							.message(e.getMessage())
    							.build();
    	
    return buildErrorResponseEntity(apiError);
    
    }
    
    private ResponseEntity<ApiResponce<?>> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponce<>(apiError), apiError.getStatus());
    }
    
}
