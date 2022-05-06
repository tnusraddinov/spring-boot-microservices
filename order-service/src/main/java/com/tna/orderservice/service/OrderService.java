package com.tna.orderservice.service;

import com.tna.orderservice.dto.CreateOrderRequest;
import com.tna.orderservice.model.Order;
import com.tna.orderservice.model.OrderItem;
import com.tna.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(CreateOrderRequest request){
        Order order = new Order().setOrderNumber(UUID.randomUUID().toString());
        List<OrderItem> orderItems = request.getOrderItems().stream().map(OrderItem::of).toList();
        order.setOrderItems(orderItems);
        order = orderRepository.save(order);
    }
}
