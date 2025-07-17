package com.techlab.sysgestion.repository;

import com.techlab.sysgestion.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Integer> {
}
