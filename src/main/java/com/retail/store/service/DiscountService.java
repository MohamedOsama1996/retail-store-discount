package com.retail.store.service;

public interface DiscountService {

    int determineDiscountAmountBasedOnRole(String userName);

    int determineDiscountAmountBasedOnJoiningDate(double billAmount,String userName);
}
