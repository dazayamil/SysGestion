package com.techlab.sysgestion.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

@Entity
@Table(name = "order_item")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int amount;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
