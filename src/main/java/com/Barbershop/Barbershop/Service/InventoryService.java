package com.Barbershop.Barbershop.Service;

import com.Barbershop.Barbershop.Entity.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryService {

    Inventory createItem(Inventory item);
    Optional<Inventory> getItemById(Long id);
    List<Inventory > getAllItems();
    List<Inventory> getItemsByShop(Long shopId);
    Inventory updateItem(Inventory item);
    void deleteItem(Long id);
    List<Inventory> findLowStockItems(Long shopId, int threshold);
    void updateItemQuantity(Long itemId, int quantityChange);
    boolean isItemInStock(Long itemId);
}