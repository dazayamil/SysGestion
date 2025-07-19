package com.techlab.sysgestion.dto.response;

import com.techlab.sysgestion.model.enums.OrderStatus;

import java.time.LocalDate;

public class OrderResponseDto {
    private int orderId;
    private LocalDate date;
    private OrderStatus state;
    private double totalCost;
}
