package com.devsalmeida.techstore.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<String> productNotFound(ProductNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
    }

    @ExceptionHandler(EmptyStockException.class)
    private ResponseEntity<String> emptyStock(EmptyStockException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há produtos em estoque!");
    }

    @ExceptionHandler(ProductSaveException.class)
    private ResponseEntity<String> sameName(ProductSaveException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um produto cadastrado com este nome!");
    }

}
