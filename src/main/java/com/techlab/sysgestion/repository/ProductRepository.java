package com.techlab.sysgestion.repository;

import com.techlab.sysgestion.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Integer> {
}
