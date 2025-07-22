package com.techlab.sysgestion.controller;

import com.techlab.sysgestion.dto.request.ProductRequestDto;
import com.techlab.sysgestion.dto.response.ProductResponseDto;
import com.techlab.sysgestion.exception.ProductNotFound;
import com.techlab.sysgestion.service.impl.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {
    private final ProductServiceImpl productServiceImpl;

    @Autowired
    public AdminProductController(ProductServiceImpl productServiceImpl){
        this.productServiceImpl = productServiceImpl;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequestDto dto){
        ProductResponseDto createProduct = productServiceImpl.createProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProductById(@PathVariable int id, @Valid @RequestBody ProductRequestDto dto){
        ProductResponseDto updateProducto = productServiceImpl.updateProductById(id, dto);
        return ResponseEntity.ok(updateProducto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable int id){
        try {
            productServiceImpl.deleteProductById(id);
            return ResponseEntity.ok("Product deleted successfully");
        }catch (ProductNotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
