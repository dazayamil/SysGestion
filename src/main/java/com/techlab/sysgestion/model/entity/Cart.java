package com.techlab.sysgestion.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class Cart {
    private double totalCost;
    private List<CartItem> items = new ArrayList<>();
}
