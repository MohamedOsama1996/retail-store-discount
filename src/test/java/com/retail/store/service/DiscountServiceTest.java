package com.retail.store.service;

import com.retail.store.model.Discount;
import com.retail.store.model.User;
import com.retail.store.repository.DiscountRepository;
import com.retail.store.repository.UserRepository;
import com.retail.store.service.impl.DiscountServiceImpl;
import com.retail.store.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DiscountServiceTest {


    @Mock
   public UserRepository userRepository;

    @Mock
    public DiscountRepository discountRepository;

    @InjectMocks
    DiscountServiceImpl discountService;

    private User user;

    private Discount discount;

    @BeforeEach
    public void setup(){

        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setUserName("mohamed");
        user.setPassword("123456");
        user.setRole("customer");

        discount = new Discount();
        discount.setDiscountPercentage(30);
        discount.setUserRole(user.getRole());
    }


    @Test
    public void testGetDiscountPercentageForCustomerRole(){

       when(userRepository.findByUserName(any())).thenReturn(user);
       when(discountRepository.findByUserRole(any())).thenReturn(discount);
       assertEquals(30,discountService.determineDiscountAmountBasedOnRole(user.getUsername()));

    }

    @Test
    public void testGetDiscountPercentageForAfilliateRole(){
        user.setRole("affiliate");
        discount.setDiscountPercentage(5);
        when(userRepository.findByUserName(any())).thenReturn(user);
        when(discountRepository.findByUserRole(any())).thenReturn(discount);
        assertEquals(5,discountService.determineDiscountAmountBasedOnRole(user.getUsername()));

    }

    @Test
    public void testGetDiscountPercentageBasedOnJoiningDateWithTwoYearsDifference(){
       LocalDate date = LocalDate.now();
       date = date.plusDays(Constants.TWO_YEARS_IN_DAYS);
       user.setJoinDate(date);
        when(userRepository.findByUserName(any())).thenReturn(user);
        when(discountRepository.findByUserRole(any())).thenReturn(discount);
        assertEquals(45,discountService.determineDiscountAmountBasedOnJoiningDate(990,user.getUsername()));

    }

    @Test
    public void testGetDiscountPercentageBasedOnJoiningDateLessThanTwoYearsDifference(){
        LocalDate date = LocalDate.now();
        user.setJoinDate(date);
        when(userRepository.findByUserName(any())).thenReturn(user);
        when(discountRepository.findByUserRole(any())).thenReturn(discount);
        assertEquals(0,discountService.determineDiscountAmountBasedOnJoiningDate(990,user.getUsername()));

    }



}
