package com.tna.productservice.dto;

import com.tna.productservice.model.Product;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

//@Data
//@Accessors(chain = true)
//public class ProductDto {
//
//    private Long id;
//    private String name;
//    private String description;
//    private BigDecimal price;
//
//    public static ProductDto of(Product p) {
//        return new ProductDto()
//                .setId(p.getId()).setName(p.getName()).setDescription(p.getDescription()).setPrice(p.getPrice());
//    }
//}

public record ProductDto(Long id, String name, String description, BigDecimal price) {
    public static ProductDto of(Product p) {
        return new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getPrice());
    }
}
