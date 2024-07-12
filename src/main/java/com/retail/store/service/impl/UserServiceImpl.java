package com.retail.store.service.impl;

import com.retail.store.exception.ErrorMessage;
import com.retail.store.exception.RetailStoreException;
import com.retail.store.model.User;
import com.retail.store.model.request.RegisterUser;
import com.retail.store.repository.UserRepository;
import com.retail.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public  UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public User registerUser(RegisterUser registerUser){

        try {
            User user = new User();
            user.setUserName( registerUser.getUserName());
            user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
            user.setRole(registerUser.getRole());
            return userRepository.save(user);
        }catch (Exception ex){
            throw new RetailStoreException(HttpStatus.CONFLICT.value(), ErrorMessage.USER_ALREADY_EXISTS.toString());
        }

    }
}
