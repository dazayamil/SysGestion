package com.techlab.sysgestion.service.impl;

import com.techlab.sysgestion.model.entity.Cart;
import com.techlab.sysgestion.model.entity.Product;
import com.techlab.sysgestion.repository.ProductRepository;
import com.techlab.sysgestion.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private final ProductRepository productRepository;
    private final Cart cart = new Cart();

    @Autowired
    public CartServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public void addItem(int productId, int amount) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        cart.addItem(product, amount);
    }

    @Override
    public void deleteItem(int productId) {
        cart.deleteItem(productId);
    }

    @Override
    public void clearCart() {
        cart.getItems().clear();
        cart.setTotalCost(0);
    }
}
