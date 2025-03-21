package com.devsalmeida.techstore.handler;

public class EmptyStockException extends RuntimeException {
    public EmptyStockException(){super(("Não há produtos em estoque!"));}

    public EmptyStockException(String message) {
        super(message);
    }
}
