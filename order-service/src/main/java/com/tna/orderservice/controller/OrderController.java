package com.tna.orderservice.controller;

import com.tna.orderservice.dto.CreateOrderRequest;
import com.tna.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import java.util.concurrent.CompletableFuture;
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
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name="inventory")
    public CompletableFuture<String> placeOrder(@RequestBody CreateOrderRequest request) {
        return CompletableFuture.supplyAsync(() -> orderService.placeOrder(request));
    }

    public CompletableFuture<String> fallbackMethod(CreateOrderRequest request, RuntimeException exception) {
        log.debug(exception.getMessage(), exception);
        return CompletableFuture.supplyAsync(() -> "Oooops! Something went wrong, please order after some time!!!!");
    }

}
