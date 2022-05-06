package com.tna.inventoryservice;

import com.tna.inventoryservice.model.Inventory;
import com.tna.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			inventoryRepository.saveAll(List.of(
				new Inventory().setSkuCode("iphone_12").setQuantity(50),
				new Inventory().setSkuCode("iphone_13").setQuantity(100),
				new Inventory().setSkuCode("iphone_13_red").setQuantity(0)
			));
		};
	}

}
