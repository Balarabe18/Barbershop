package com.Barbershop.Barbershop.Repository;

import com.Barbershop.Barbershop.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    // Custom query methods can be added here
}
