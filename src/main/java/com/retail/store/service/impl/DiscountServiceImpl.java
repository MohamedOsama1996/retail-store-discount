package com.retail.store.service.impl;

import com.retail.store.exception.ErrorMessage;
import com.retail.store.exception.ErrorResponse;
import com.retail.store.exception.RetailStoreException;
import com.retail.store.model.Discount;
import com.retail.store.model.User;
import com.retail.store.repository.DiscountRepository;
import com.retail.store.repository.UserRepository;
import com.retail.store.service.DiscountService;
import com.retail.store.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    public  UserRepository userRepository;

    @Autowired
    public DiscountRepository discountRepository;
    @Override
    public int determineDiscountAmountBasedOnRole(String userName) {

       User user =  userRepository.findByUserName(userName);
       try {
           Discount discount = discountRepository.findByUserRole(user.getRole());
           return discount.getDiscountPercentage();
       }catch (Exception ex){
           throw new RetailStoreException(HttpStatus.NOT_FOUND.value(), ErrorMessage.ROLE_NOT_FOUND.toString());
       }
    }

    @Override
    public int determineDiscountAmountBasedOnJoiningDate(double billAmount,String userName) {
        User user =  userRepository.findByUserName(userName);
        LocalDate date = LocalDate.now();
        int value = 0;
        long daysbetween = Math.abs(ChronoUnit.DAYS.between(user.getJoinDate(),date));
        if(daysbetween >= Constants.TWO_YEARS_IN_DAYS){
             value = (int) (Math.floor((billAmount/100)))*5;
        }
        return value;

    }
}
