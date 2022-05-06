package com.tna.inventoryservice.service;

import com.tna.inventoryservice.dto.InventoryResponse;
import com.tna.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCodes) {
        return inventoryRepository.findBySkuCodeIn(skuCodes)
                .stream()
                .map(inventory -> new InventoryResponse().setSkuCode(inventory.getSkuCode())
                        .setInStock(inventory.getQuantity() > 0)).toList();
    }
}
