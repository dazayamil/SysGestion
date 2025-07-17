package com.techlab.sysgestion.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class ProductRequestDto {
    @NotBlank(message = "Name is required")
    @Size(min = 5, max = 20)
    private String name;
    @NotBlank(message = "Description is required")
    @Size(min = 5, max = 100)
    private String description;
    @Positive
    @Min(0)
    private double price;
    @NotBlank(message = "Category is required")
    private String category;
    @NotBlank(message = "IMG is required")
    private String img;
    @PositiveOrZero
    @Min(0)
    private int stock;
}
