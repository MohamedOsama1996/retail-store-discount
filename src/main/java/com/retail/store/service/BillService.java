package com.retail.store.service;

import com.retail.store.model.User;
import com.retail.store.model.request.BillAmount;

public interface BillService {


    double calculateBillForUser(BillAmount billAmount, User user);
}
