package com.Barbershop.Barbershop.Controller;

import com.Barbershop.Barbershop.Entity.Inventory;
import com.Barbershop.Barbershop.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<Inventory> createItem(@RequestBody Inventory item) {
        Inventory createdItem = inventoryService.createItem(item);
        return ResponseEntity.ok(createdItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Inventory>> getItemById(@PathVariable Long id) {
        Optional<Inventory> item = inventoryService.getItemById(id);
        return ResponseEntity.ok(item);
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllItems() {
        List<Inventory> items = inventoryService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateItem(@PathVariable Long id, @RequestBody Inventory item) {
        item.setItemId(id);
        Inventory updatedItem = inventoryService.updateItem(item);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        inventoryService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<Inventory>> findLowStockItems(@RequestParam Long shopId, @RequestParam int threshold) {
        List<Inventory> items = inventoryService.findLowStockItems(shopId, threshold);
        return ResponseEntity.ok(items);
    }

    @PutMapping("/update-quantity/{id}")
    public ResponseEntity<Void> updateItemQuantity(@PathVariable Long id, @RequestParam int quantityChange) {
        inventoryService.updateItemQuantity(id, quantityChange);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/in-stock/{id}")
    public ResponseEntity<Boolean> isItemInStock(@PathVariable Long id) {
        boolean inStock = inventoryService.isItemInStock(id);
        return ResponseEntity.ok(inStock);
    }
}
