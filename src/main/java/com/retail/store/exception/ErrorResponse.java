package com.retail.store.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse {

    public int status;

    public String message;
}
