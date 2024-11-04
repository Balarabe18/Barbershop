package com.Barbershop.Barbershop.Repository;

import com.Barbershop.Barbershop.Entity.HairService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface HairServiceRepository extends JpaRepository<HairService, Long> {
    List<HairService> findByCategory(String category);
    List<HairService> findByPriceLessThanEqual(BigDecimal price);
}