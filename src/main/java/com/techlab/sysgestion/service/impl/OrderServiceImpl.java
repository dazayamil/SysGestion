package com.techlab.sysgestion.service.impl;

import com.techlab.sysgestion.dto.request.OrderRequestDto;
import com.techlab.sysgestion.dto.response.OrderResponseDto;
import com.techlab.sysgestion.exception.ClientNotFound;
import com.techlab.sysgestion.exception.ProductNotFound;
import com.techlab.sysgestion.mapper.OrderMapper;
import com.techlab.sysgestion.model.entity.Client;
import com.techlab.sysgestion.model.entity.Order;
import com.techlab.sysgestion.model.entity.OrderItem;
import com.techlab.sysgestion.model.entity.Product;
import com.techlab.sysgestion.model.enums.OrderStatus;
import com.techlab.sysgestion.repository.ClientRepository;
import com.techlab.sysgestion.repository.OrderRepository;
import com.techlab.sysgestion.repository.ProductRepository;
import com.techlab.sysgestion.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;
    private ClientRepository clientRepository;
    private ProductRepository productRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderMapper orderMapper,
                            ClientRepository clientRepository,
                            ProductRepository productRepository){
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderResponseDto createOrder(OrderRequestDto dto) throws ClientNotFound, ProductNotFound {
        Client client = clientRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ClientNotFound("Client not found with id: " + dto.getClienteId()));

        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setState(OrderStatus.IN_PROGRESS);
        order.setClient(client);

        List<OrderItem> items = dto.getItems().stream().map(itemDto -> {
                    Product product = productRepository.findById(itemDto.getProductId())
                            .orElseThrow(() -> new ProductNotFound("Product nor found with id: " + itemDto.getProductId()));
                    OrderItem orderItem = new OrderItem();
                    orderItem.setProduct(product);
                    orderItem.setAmount(itemDto.getAmount());
                    orderItem.setOrder(order);
                    return orderItem;
                }).collect(Collectors.toList());

        order.setItems(items);
        Order saveOrder = orderRepository.save(order);
        return orderMapper.toResponse(saveOrder);
    }

    @Override
    public OrderResponseDto getOrderById(int id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.toResponse(order);
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return null;
    }

    @Override
    public void deleteOrder(int id) {

    }
}
