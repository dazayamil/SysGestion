package com.techlab.sysgestion.model.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem{

    private Product product;
    private int amount;

    public CartItem(Product product, int amount){
        this.product = product;
        this.amount = amount;
    }
}
