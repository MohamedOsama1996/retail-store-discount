package com.retail.store.controller;

import com.retail.store.model.User;
import com.retail.store.model.request.BillAmount;
import com.retail.store.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
   public BillService billService;


    @PostMapping("/calculate")
    public ResponseEntity<?> calculateUserBill(@RequestBody BillAmount billAmount){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = (User) authentication.getPrincipal();

        return ResponseEntity.ok().body(billService.calculateBillForUser(billAmount,user));
    }
}
