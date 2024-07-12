package com.retail.store.exception;

public class RetailStoreException extends RuntimeException{

    public String message;

    public int status;

    public RetailStoreException(int status,String message) {
        this.message = message;
        this.status = status;
    }
}
