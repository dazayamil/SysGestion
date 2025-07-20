package com.techlab.sysgestion.dto.request;

import com.techlab.sysgestion.model.enums.OrderStatus;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class OrderRequestDto {
    @NotNull
    private int clienteId;

    @NotEmpty
    private List<ItemRequestDto> items;
}
