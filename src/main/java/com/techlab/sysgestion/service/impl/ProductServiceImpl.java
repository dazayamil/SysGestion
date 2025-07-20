package com.techlab.sysgestion.service.impl;

import com.techlab.sysgestion.dto.request.ProductRequestDto;
import com.techlab.sysgestion.dto.response.ProductResponseDto;
import com.techlab.sysgestion.exception.ProductNotFound;
import com.techlab.sysgestion.mapper.ProductMapper;
import com.techlab.sysgestion.model.entity.Product;
import com.techlab.sysgestion.repository.ProductRepository;
import com.techlab.sysgestion.service.ProductService;
import com.techlab.sysgestion.utils.Format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto dto){
        dto.setName(Format.formatName(dto.getName()));
        Product product = productMapper.toEntity(dto);
        Product saveProduct = productRepository.save(product);
        return productMapper.toResponse(saveProduct);
    }

    @Override
    public ProductResponseDto getProductById(int id) throws ProductNotFound {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("Product not found"));
        return productMapper.toResponse(product);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> productMapper.toResponse(product))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(int id) throws ProductNotFound{
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("Product not found with id: " + id));
        productRepository.delete(product);
    }

    @Override
    public ProductResponseDto updateProduct(int id, ProductRequestDto dto) throws ProductNotFound{
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("Product not found with id: " + id));

        product.setName(Format.formatName(dto.getName()));
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(dto.getCategory());
        product.setStock(dto.getStock());

        Product finalProduct = productRepository.save(product);
        return productMapper.toResponse(finalProduct);
    }
}
