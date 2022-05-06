package com.tna.orderservice.dto;

import com.tna.orderservice.model.OrderItem;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class OrderItemDto {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

    public static OrderItemDto of(OrderItem orderItem) {
        return new OrderItemDto().setId(orderItem.getId())
                .setSkuCode(orderItem.getSkuCode())
                .setPrice(orderItem.getPrice())
                .setQuantity(orderItem.getQuantity());
    }
}
