package com.techlab.sysgestion.mapper;

import com.techlab.sysgestion.dto.request.ProductRequestDto;
import com.techlab.sysgestion.dto.response.ProductResponseDto;
import com.techlab.sysgestion.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductRequestDto dto);
    ProductResponseDto toResponse(Product product);
}
