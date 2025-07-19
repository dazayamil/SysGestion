package com.techlab.sysgestion.model.entity;

import com.techlab.sysgestion.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_table")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private OrderStatus state;

    private double totalCost;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();
}
