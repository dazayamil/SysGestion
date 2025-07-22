package com.techlab.sysgestion.service.impl;

import com.techlab.sysgestion.dto.request.ClientRequestDto;
import com.techlab.sysgestion.dto.response.ClientResponseDto;
import com.techlab.sysgestion.exception.ClientNotFound;
import com.techlab.sysgestion.exception.ProductNotFound;
import com.techlab.sysgestion.mapper.ClientMapper;
import com.techlab.sysgestion.model.entity.Client;
import com.techlab.sysgestion.model.entity.Product;
import com.techlab.sysgestion.repository.ClientRepository;
import com.techlab.sysgestion.service.ClientService;
import com.techlab.sysgestion.utils.Format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientMapper clientMapper;
    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientMapper clientMapper, ClientRepository clientRepository){
        this.clientMapper = clientMapper;
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientResponseDto createClient(ClientRequestDto dto) {
        Client client = clientMapper.toEntity(dto);
        Client saveClient = clientRepository.save(client);
        return clientMapper.toResponse(saveClient);
    }

    @Override
    public ClientResponseDto getClientById(int id) throws ClientNotFound {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFound("Client not found with id: " + id));
        return clientMapper.toResponse(client);
    }

    @Override
    public List<ClientResponseDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(client -> clientMapper.toResponse(client))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteClientById(int id) throws ClientNotFound{
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFound("Product not found with id: " + id));
        clientRepository.delete(client);
    }

    @Override
    public ClientResponseDto updateClientById(int id, ClientRequestDto dto) throws ClientNotFound {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFound("Product not found with id: " + id));

        client.setName(Format.formatName(dto.getName()));
        client.setLastName(Format.formatName(dto.getLastName()));
        client.setPhone(dto.getPhone());
        client.setEmail(dto.getEmail());

        Client saveClient = clientRepository.save(client);
        return clientMapper.toResponse(saveClient);
    }
}
