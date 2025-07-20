package com.techlab.sysgestion.service;

import com.techlab.sysgestion.dto.request.ProductRequestDto;
import com.techlab.sysgestion.dto.response.ProductResponseDto;
import com.techlab.sysgestion.exception.ProductNotFound;

import java.util.List;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto dto);
    ProductResponseDto getProductById(int id) throws ProductNotFound;
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto updateProduct(int id, ProductRequestDto dto);
    void deleteProduct(int id);
}
