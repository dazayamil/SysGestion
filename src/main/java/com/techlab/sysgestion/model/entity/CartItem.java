package com.techlab.sysgestion.model.entity;


public class CartItem{

    private Product product;
    private int amount;

    public CartItem(Product product, int amount){
        this.product = product;
        this.amount = amount;
    }
}
