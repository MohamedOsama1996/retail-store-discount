package com.retail.store.controller;

import com.retail.store.model.User;
import com.retail.store.model.request.RegisterUser;
import com.retail.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterUser registerUser){
        return ResponseEntity.ok().body(userService.registerUser(registerUser));
    }
}
