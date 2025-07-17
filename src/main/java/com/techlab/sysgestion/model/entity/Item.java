package com.techlab.sysgestion.model.entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public abstract class Item {
    private Product product;
    private int amount;
}
