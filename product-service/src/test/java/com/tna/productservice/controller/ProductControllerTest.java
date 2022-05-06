package com.tna.productservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tna.productservice.dto.CreateProductRequest;
import com.tna.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Value("${myname:}")
    private String name;

    @Autowired
    private Environment env;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ProductRepository productRepository;

    @Test
    void whenCreateProductOk_shouldCreateProduct() throws Exception {

        CreateProductRequest request = new CreateProductRequest()
                .setName("name")
                .setDescription("desc")
                .setPrice(BigDecimal.ONE);

        String requestString = objectMapper.writeValueAsString(request);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestString))
                .andExpect(status().isCreated());

        assertThat(productRepository.findAll()).hasSize(1);
        
    }


}