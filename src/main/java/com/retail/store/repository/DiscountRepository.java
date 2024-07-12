package com.retail.store.repository;

import com.retail.store.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount,Integer> {

    Discount findByUserRole(String userRole);


}
