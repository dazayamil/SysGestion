package com.techlab.sysgestion.controller;

import com.techlab.sysgestion.dto.response.OrderResponseDto;
import com.techlab.sysgestion.model.entity.Cart;
import com.techlab.sysgestion.service.CartService;
import com.techlab.sysgestion.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<Cart> getCart() {
        return ResponseEntity.ok(cartService.getCart());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestParam int productId, @RequestParam int amount) {
        cartService.addItem(productId, amount);
        return ResponseEntity.ok("Item added to cart");
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<String> removeItem(@PathVariable int productId) {
        cartService.deleteItem(productId);
        return ResponseEntity.ok("Item removed from cart");
    }

    @DeleteMapping("/clear")
    public ResponseEntity<String> clearCart() {
        cartService.clearCart();
        return ResponseEntity.ok("Cart cleared");
    }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestParam int clientId) {
        try {
            Cart cart = cartService.getCart();
            OrderResponseDto order = orderServiceImpl.createOrder(clientId, cart);
            return ResponseEntity.status(HttpStatus.CREATED).body(order);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

