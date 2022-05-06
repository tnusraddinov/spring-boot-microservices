package com.tna.orderservice.model;

import com.tna.orderservice.dto.OrderItemDto;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

    public static OrderItem of(OrderItemDto orderItemDto){
        return new OrderItem().setId(orderItemDto.getId())
                .setPrice(orderItemDto.getPrice())
                .setQuantity(orderItemDto.getQuantity())
                .setSkuCode(orderItemDto.getSkuCode());
    }
}
