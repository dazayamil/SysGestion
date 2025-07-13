package com.techlab.sysgestion.model.entity;

import com.techlab.sysgestion.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "order")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private OrderStatus state;
    private double totalCost;
}
