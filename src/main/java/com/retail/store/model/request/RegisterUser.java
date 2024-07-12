package com.retail.store.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUser {

    private String userName;

    private String password;

    private String role;
}
