package com.Barbershop.Barbershop.Repository;

import com.Barbershop.Barbershop.Entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    // Custom query methods can be added here
}
