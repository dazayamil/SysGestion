package com.techlab.sysgestion.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private int id;
    private String name;
    private String description;
    private double price;
    private String category;
    private String img;
}
