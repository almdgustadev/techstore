package com.devsalmeida.techstore.handler;


public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(){super(("Produto não encontrado!"));}

    public ProductNotFoundException(String message) {
        super(message);
    }
}
