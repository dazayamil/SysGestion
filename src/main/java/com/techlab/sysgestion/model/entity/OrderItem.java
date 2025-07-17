package com.techlab.sysgestion.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.aspectj.weaver.ast.Or;

@Entity
@Table(name = "order_item")
@Getter
public class OrderItem extends Item{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem(Product product, int amount, Order order){
        super(product, amount);
        this.order = order;
    }
}
