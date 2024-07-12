package com.retail.store.service.impl;

import com.retail.store.exception.ErrorMessage;
import com.retail.store.exception.RetailStoreException;
import com.retail.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            return userRepository.findByUserName(username);
        }catch (RetailStoreException ex){
            throw new RetailStoreException(HttpStatus.UNAUTHORIZED.value(), ErrorMessage.UNAUTHORIZED.toString());

        }
    }
}
