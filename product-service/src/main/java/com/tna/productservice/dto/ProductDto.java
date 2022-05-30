package com.tna.productservice.dto;

import com.tna.productservice.model.Product;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

public record ProductDto(Long id, String name, String description, BigDecimal price) {
    public static ProductDto of(Product p) {
        return new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getPrice());
    }
}
