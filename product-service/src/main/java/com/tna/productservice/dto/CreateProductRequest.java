package com.tna.productservice.dto;

import java.math.BigDecimal;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public record CreateProductRequest(String name, String description, BigDecimal price) {

}
