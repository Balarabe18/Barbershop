package com.Barbershop.Barbershop.Service;

import com.Barbershop.Barbershop.Entity.HairService;

import java.math.BigDecimal;
import java.util.List;

public interface HairServiceService {

    List<HairService> getServicesByCategory(String category);

    List<HairService> getServicesByMaxPrice(BigDecimal price);
}

