package com.techlab.sysgestion.service;

import com.techlab.sysgestion.dto.request.ClientRequestDto;
import com.techlab.sysgestion.dto.request.ProductRequestDto;
import com.techlab.sysgestion.dto.response.ClientResponseDto;
import com.techlab.sysgestion.dto.response.ProductResponseDto;
import com.techlab.sysgestion.exception.ClientNotFound;
import com.techlab.sysgestion.exception.ProductNotFound;

import java.util.List;

public interface ClientService {
    ClientResponseDto createClient(ClientRequestDto dto);
    ClientResponseDto getClientById(int id) throws ClientNotFound;
    List<ClientResponseDto> getAllClients();
    ClientResponseDto updateClientById(int id, ClientRequestDto dto);
    void deleteClientById(int id);
}
