package com.tna.productservice;

import com.tna.productservice.model.Product;
import com.tna.productservice.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ProductRepository productRepository){
		return args -> {
			productRepository.saveAll(List.of(
					new Product().setName("Iphonee 13").setDescription("iphone 13").setPrice(BigDecimal.valueOf(1200)),
					new Product().setName("Iphone 13 Red").setDescription("iphone 13 red").setPrice(BigDecimal.valueOf(1000)),
					new Product().setName("Iphone 12").setDescription("iphone 12").setPrice(BigDecimal.valueOf(1100))
			));
		};
	}


}
