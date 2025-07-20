package com.techlab.sysgestion.service;

import com.techlab.sysgestion.dto.request.OrderRequestDto;
import com.techlab.sysgestion.dto.response.OrderResponseDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto dto);
    OrderResponseDto getOrderById(int id);
    List<OrderResponseDto> getAllOrders();
    void deleteOrder(int id);
}
