package com.techlab.sysgestion.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class Cart {
    private double totalCost;
    private List<CartItem> items;
}
