package com.retail.store.service.impl;

import com.retail.store.model.User;
import com.retail.store.model.request.BillAmount;
import com.retail.store.service.BillService;
import com.retail.store.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    DiscountService discountService;

    @Override
    public double calculateBillForUser(BillAmount billAmount, User user) {

        int discount = discountService.determineDiscountAmountBasedOnRole(user.getUsername());
        double discountBasedOnRole = billAmount.getMoney()-(billAmount.getMoney()*((double) discount /100));
        int discountByJoiningDate = discountService.determineDiscountAmountBasedOnJoiningDate(billAmount.getMoney(),user.getUsername());
        if((double) discountByJoiningDate > discountBasedOnRole){
            return discountByJoiningDate;
        }
        return  discountBasedOnRole;

    }
}
