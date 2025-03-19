package com.devsalmeida.techstore.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<String> productNotFound(ProductNotFoundException productNotFoundException){
        return new ResponseEntity<>(productNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyStockException.class)
    private ResponseEntity<String> emptyStock(EmptyStockException emptyStockException){
        return new ResponseEntity<>(emptyStockException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductSaveException.class)
    private ResponseEntity<String> sameName(ProductSaveException sameNameException){
        return new ResponseEntity<>(sameNameException.getMessage(), HttpStatus.CONFLICT);
    }

}
