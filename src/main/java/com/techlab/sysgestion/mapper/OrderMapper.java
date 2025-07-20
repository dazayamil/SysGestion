package com.techlab.sysgestion.mapper;

import com.techlab.sysgestion.dto.request.OrderRequestDto;
import com.techlab.sysgestion.dto.response.OrderResponseDto;
import com.techlab.sysgestion.model.entity.Order;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface OrderMapper {
    Order toEntity(OrderRequestDto dto);
    OrderResponseDto toResponse(Order order);
}
