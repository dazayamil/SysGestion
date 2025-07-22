package com.techlab.sysgestion.mapper;

import com.techlab.sysgestion.dto.request.ClientRequestDto;
import com.techlab.sysgestion.dto.request.OrderRequestDto;
import com.techlab.sysgestion.dto.response.ClientResponseDto;
import com.techlab.sysgestion.dto.response.OrderResponseDto;
import com.techlab.sysgestion.model.entity.Client;
import com.techlab.sysgestion.model.entity.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "string")
public interface ClientMapper {
    Client toEntity(ClientRequestDto dto);
    ClientResponseDto toResponse(Client client);
}
