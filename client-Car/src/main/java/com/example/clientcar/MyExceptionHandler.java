package com.example.clientcar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends  Exception{
    @ExceptionHandler({CarNotFoundException.class})
    public ResponseEntity<String> CarNotFound(RuntimeException ex)
    {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.valueOf(404));
    }

}