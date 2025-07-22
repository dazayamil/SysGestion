package com.techlab.sysgestion.service;

import com.techlab.sysgestion.model.entity.Cart;
import com.techlab.sysgestion.model.entity.Product;

public interface CartService {
    Cart getCart();
    void addItem(int productId, int amount);
    void deleteItem(int productId);
    void clearCart();

}
