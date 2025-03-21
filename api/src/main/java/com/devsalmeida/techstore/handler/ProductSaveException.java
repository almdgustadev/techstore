package com.devsalmeida.techstore.handler;

public class ProductSaveException extends RuntimeException {
    public ProductSaveException(){super(("Erro ao cadastrar produto!"));}

    public ProductSaveException(String message) {
        super(message);
    }
}
