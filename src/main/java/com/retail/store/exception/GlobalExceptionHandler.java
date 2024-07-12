package com.retail.store.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RetailStoreException.class)
    public ResponseEntity<ErrorResponse>handleRetailStoreException(RetailStoreException ex){

        return new ResponseEntity<>( new ErrorResponse(ex.status,ex.message),null,ex.status);
    }
}
