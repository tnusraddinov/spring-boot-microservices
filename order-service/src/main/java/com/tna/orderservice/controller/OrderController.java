package com.tna.orderservice.controller;

import com.tna.orderservice.dto.CreateOrderRequest;
import com.tna.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name="inventory", fallbackMethod = "fallbackMethod")
    public String placeOrder(@RequestBody CreateOrderRequest request){
        orderService.placeOrder(request);
        return "created";
    }

    public String fallbackMethod(CreateOrderRequest request, RuntimeException exception) {
        log.debug(exception.getMessage(), exception);
        return "Oooops! Something went wrong, please order after some time!!!!";
    }

}
