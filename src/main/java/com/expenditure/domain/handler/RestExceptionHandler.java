package com.expenditure.domain.handler;

import com.expenditure.domain.exception.ResourceNotFoundException;
import com.expenditure.domain.exception.ResourceNotFoundExceptionDetails;
import com.expenditure.domain.exception.ResourceNotFoundExceptionDetailsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResouceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        ResourceNotFoundExceptionDetails details = ResourceNotFoundExceptionDetailsBuilder
                .aResourceNotFoundExceptionDetails()
                .title("Resource not found")
                .detail(resourceNotFoundException.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(new Date().getTime())
                .developerMessage(resourceNotFoundException.getClass().getName())
                .build();
            return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
    }
}
