package com.Barbershop.Barbershop.Service;

import com.Barbershop.Barbershop.Entity.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {

        Shop createShop(Shop shop);
        Optional<Shop> getShopById(Long id);
        List<Shop> getAllShops();
        Shop updateShop(Shop shop);
        void deleteShop(Long id);
        List<Shop> findShopsByName(String name);
        Optional<Shop> findShopByManagerId(Long managerId);
    }

