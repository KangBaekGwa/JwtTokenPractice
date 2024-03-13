package com.union.ssgdotcom.cart.model;

import com.union.ssgdotcom.member.domain.Member;
import com.union.ssgdotcom.product.model.Product;
import jakarta.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    private Integer quantity;

}
