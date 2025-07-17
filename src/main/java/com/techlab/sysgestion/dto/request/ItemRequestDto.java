package com.techlab.sysgestion.dto.request;

import com.techlab.sysgestion.model.entity.Order;
import com.techlab.sysgestion.model.entity.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class ItemRequestDto {
    @NotNull(message = "Product is required")
    private Product product;
    @Positive
    @Min(0)
    private int amount;
    @NotNull(message = "Order es required")
    private Order order;

}
