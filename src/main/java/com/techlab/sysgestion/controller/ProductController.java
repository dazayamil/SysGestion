package com.techlab.sysgestion.controller;

import com.techlab.sysgestion.dto.request.ProductRequestDto;
import com.techlab.sysgestion.dto.response.ProductResponseDto;
import com.techlab.sysgestion.exception.ProductNotFound;
import com.techlab.sysgestion.service.ProductService;
import com.techlab.sysgestion.service.impl.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductServiceImpl productServiceImpl;

    @Autowired
    public ProductController(ProductServiceImpl productServiceImpl){
        this.productServiceImpl = productServiceImpl;
    }

    // ENDPOINTS LIBRES
    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        List<ProductResponseDto> products = productServiceImpl.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable int id){
        ProductResponseDto product = productServiceImpl.getProductById(id);
        return ResponseEntity.ok(product);
    }
}
