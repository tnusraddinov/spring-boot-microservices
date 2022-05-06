package com.tna.orderservice.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class CreateOrderRequest {
    private List<OrderItemDto> orderItems;
}
