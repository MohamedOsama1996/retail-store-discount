package com.retail.store.service;

import com.retail.store.model.User;
import com.retail.store.model.request.BillAmount;
import com.retail.store.service.impl.BillServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BillServiceTest {

    @Mock
    DiscountService discountService;

    @InjectMocks
    BillServiceImpl billService;



    private User user;

    @BeforeEach
    public void setup(){

        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setUserName("mohamed");
        user.setPassword("123456");
        user.setRole("customer");
    }

    @Test
    public void testCalculateBillForUser(){

        BillAmount bill = new BillAmount();
        bill.setMoney(930.0);
        when(discountService.determineDiscountAmountBasedOnRole(user.getUsername() )).thenReturn(30);
        when(discountService.determineDiscountAmountBasedOnJoiningDate(bill.getMoney(),user.getUsername())).thenReturn(0);
        assertEquals(651,billService.calculateBillForUser(bill,user));

    }
}
