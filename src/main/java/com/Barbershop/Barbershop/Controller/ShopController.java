package com.Barbershop.Barbershop.Controller;

import com.Barbershop.Barbershop.Entity.Shop;
import com.Barbershop.Barbershop.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        Shop createdShop = shopService.createShop(shop);
        return ResponseEntity.ok(createdShop);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Shop>> getShopById(@PathVariable Long id) {
        Optional<Shop> shop = shopService.getShopById(id);
        return ResponseEntity.ok(shop);
    }

    @GetMapping
    public ResponseEntity<List<Shop>> getAllShops() {
        List<Shop> shops = shopService.getAllShops();
        return ResponseEntity.ok(shops);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable Long id, @RequestBody Shop shop) {
        shop.setShopId(id);  // Assuming the entity has a setter for the shop ID
        Shop updatedShop = shopService.updateShop(shop);
        return ResponseEntity.ok(updatedShop);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
        return ResponseEntity.noContent().build();
    }
}
