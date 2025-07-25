package com.techlab.sysgestion.service.impl;

import com.techlab.sysgestion.dto.request.OrderItemRequestDto;
import com.techlab.sysgestion.dto.request.OrderRequestDto;
import com.techlab.sysgestion.dto.response.OrderResponseDto;
import com.techlab.sysgestion.exception.ClientNotFound;
import com.techlab.sysgestion.exception.InsufficientStockException;
import com.techlab.sysgestion.exception.OrderNotFound;
import com.techlab.sysgestion.exception.ProductNotFound;
import com.techlab.sysgestion.mapper.OrderMapper;
import com.techlab.sysgestion.model.entity.*;
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

    private Client verifyClient(int clientId) throws ClientNotFound{
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFound("Client not found with id: " + clientId));
    }

    private void updateStock(List<OrderItem> items){
        items.forEach(item -> {
            Product product = item.getProduct();
            product.setStock(product.getStock() - item.getAmount());
            productRepository.save(product);
        });
    }

    private double calculateTotalCost(List<OrderItem> items){
        return items.stream()
                .mapToDouble(item -> item.getAmount() * item.getProduct().getPrice())
                .sum();
    }

    @Override
    public OrderResponseDto createOrder(int clientId, Cart cart) {
        Client client = verifyClient(clientId);

        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setState(OrderStatus.IN_PROGRESS);
        order.setClient(client);

        List<OrderItem> items = cart.getItems().stream().map(cartItem -> {
            Product product = productRepository.findById(cartItem.getProduct().getId())
                    .orElseThrow(() -> new ProductNotFound("Product not found with id: " + cartItem.getProduct().getId()));

            if (cartItem.getAmount() > product.getStock()) {
                throw new InsufficientStockException("Not enough stock for product: " + product.getName());
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setAmount(cartItem.getAmount());
            orderItem.setOrder(order);
            return orderItem;
        }).collect(Collectors.toList());

        order.setItems(items);
        order.setTotalCost(calculateTotalCost(items));
        Order saveOrder = orderRepository.save(order);
        updateStock(items);
        cart.clearCart();
        return orderMapper.toResponse(saveOrder);
    }

    @Override
    public OrderResponseDto getOrderById(int id) throws OrderNotFound {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFound("Order not found with id: " + id));
        return orderMapper.toResponse(order);
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> orderMapper.toResponse(order))
                .collect(Collectors.toList());
    }

    @Override
    public void updateOrderStatus(int id, OrderStatus status) throws OrderNotFound {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFound("Order not found with id: " + id));
        order.setState(status);
        orderRepository.save(order);
    }
}
