package com.retail.store.exception;

public enum ErrorMessage {

    USER_ALREADY_EXISTS("USER ALREADY EXISTS"),
    UNAUTHORIZED("please check your username and password"),
    ROLE_NOT_FOUND("USER ROLE NOT FOUND");

    private String message;

    ErrorMessage( String message){
       this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
