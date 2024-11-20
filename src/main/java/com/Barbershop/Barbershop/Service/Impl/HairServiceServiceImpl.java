package com.Barbershop.Barbershop.Service;

import com.Barbershop.Barbershop.Entity.HairService;
import com.Barbershop.Barbershop.Repository.HairServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HairServiceServiceImpl implements HairServiceService {

    private final HairServiceRepository hairServiceRepository;

    @Override
    public List<HairService> getServicesByCategory(String category) {
        return hairServiceRepository.findByCategory(category);
    }

    @Override
    public List<HairService> getServicesByMaxPrice(BigDecimal price) {
        return hairServiceRepository.findByPriceLessThanEqual(price);
    }
}
