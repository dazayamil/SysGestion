package com.techlab.sysgestion.repository;

import com.techlab.sysgestion.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository <OrderItem, Integer> {
}
