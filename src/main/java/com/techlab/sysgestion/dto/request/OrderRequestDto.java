package com.techlab.sysgestion.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequestDto {
    @NotNull
    private int clienteId;

    @NotEmpty
    private List<OrderItemRequestDto> items;
}
