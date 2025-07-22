package com.techlab.sysgestion.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class OrderItemRequestDto {
    @NotNull(message = "Product ID is required")
    private int productId;
    @Positive
    @Min(1)
    private int amount;

}
