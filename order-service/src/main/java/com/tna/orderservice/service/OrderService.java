package com.tna.orderservice.service;

import com.tna.orderservice.dto.CreateOrderRequest;
import com.tna.orderservice.dto.InventoryResponse;
import com.tna.orderservice.model.Order;
import com.tna.orderservice.model.OrderItem;
import com.tna.orderservice.repository.OrderRepository;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public OrderService(OrderRepository orderRepository, WebClient.Builder webClientBuilder) {
        this.orderRepository = orderRepository;
        this.webClientBuilder = webClientBuilder;
    }

    public String placeOrder(CreateOrderRequest request) {
        Order order = new Order().setOrderNumber(UUID.randomUUID().toString());
        List<OrderItem> orderItems = request.getOrderItems().stream().map(OrderItem::of).toList();
        order.setOrderItems(orderItems);

        List<String> skuCodes = order.getOrderItems().stream().map(OrderItem::getSkuCode).collect(Collectors.toList());

        InventoryResponse [] inventoryResponses = webClientBuilder.build()
                .get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build()
                )
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStock = !Arrays.stream(inventoryResponses).toList().isEmpty() &&
                Stream.of(inventoryResponses).allMatch(InventoryResponse::isInStock);

        if (allProductsInStock) {
            order = orderRepository.save(order);
            return "Order Placed Successfully";
        } else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }
    }
}
