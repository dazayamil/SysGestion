package com.techlab.sysgestion.model.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Cart {
    private double totalCost;
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int amount) {
        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                item.setAmount(item.getAmount() + amount);
                calculateTotal();
                return;
            }
        }
        items.add(new CartItem(product, amount));
        calculateTotal();
    }

    public void deleteItem(int productId) {
        items.removeIf(item -> item.getProduct().getId() == productId);
        calculateTotal();
    }

    private void calculateTotal() {
        totalCost = items.stream()
                .mapToDouble(i -> i.getAmount() * i.getProduct().getPrice())
                .sum();
    }

    public void clearCart() {
        items.clear();
        totalCost = 0;
    }
}
