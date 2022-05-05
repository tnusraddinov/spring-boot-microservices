package com.tna.productservice.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class CreateProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
}
