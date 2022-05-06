package com.tna.orderservice.controller;

import com.tna.orderservice.dto.CreateOrderRequest;
import com.tna.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody CreateOrderRequest request){
        orderService.placeOrder(request);
        return "created";
    }
}
