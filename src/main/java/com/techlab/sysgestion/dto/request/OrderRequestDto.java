package com.techlab.sysgestion.dto.request;

import com.techlab.sysgestion.model.enums.OrderStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class OrderRequestDto {
    @NotNull(message = "Date is required")
    @FutureOrPresent
    private LocalDate date;
    @NotNull(message = "Order status is required")
    private OrderStatus state;
    @Positive
    private double totalCost;
}
