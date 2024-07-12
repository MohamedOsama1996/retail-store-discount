package com.retail.store.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table( name = "discounts")
@Data
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "discount_percentage")
    private int discountPercentage;
}
