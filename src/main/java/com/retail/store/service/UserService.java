package com.retail.store.service;

import com.retail.store.model.User;
import com.retail.store.model.request.RegisterUser;

public interface UserService {

     User registerUser(RegisterUser registerUser);

}
