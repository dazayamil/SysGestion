package com.techlab.sysgestion.controller;

import com.techlab.sysgestion.dto.request.OrderRequestDto;
import com.techlab.sysgestion.dto.response.OrderResponseDto;
import com.techlab.sysgestion.exception.ClientNotFound;
import com.techlab.sysgestion.exception.OrderNotFound;
import com.techlab.sysgestion.exception.ProductNotFound;
import com.techlab.sysgestion.model.enums.OrderStatus;
import com.techlab.sysgestion.service.impl.OrderServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderServiceImpl orderServiceImpl;

    @Autowired
    public OrderController(OrderServiceImpl orderServiceImpl){
        this.orderServiceImpl = orderServiceImpl;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderRequestDto dto) {
        try {
            OrderResponseDto response = orderServiceImpl.createOrder(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (ClientNotFound | ProductNotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable int id) {
        try {
            OrderResponseDto response = orderServiceImpl.getOrderById(id);
            return ResponseEntity.ok(response);
        } catch (OrderNotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getAllOrders() {
        return ResponseEntity.ok(orderServiceImpl.getAllOrders());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateOrderStatus(@PathVariable int id, @RequestParam OrderStatus status) {
        try {
            orderServiceImpl.updateOrderStatus(id, status);
            return ResponseEntity.noContent().build();
        } catch (OrderNotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
