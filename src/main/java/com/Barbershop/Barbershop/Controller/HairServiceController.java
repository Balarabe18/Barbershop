package com.Barbershop.Barbershop.Controller;

import com.Barbershop.Barbershop.Entity.HairService;
import com.Barbershop.Barbershop.Service.HairServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class HairServiceController {

    private final HairServiceService hairServiceService;

    @GetMapping("/category/{category}")
    public ResponseEntity<List<HairService>> getServicesByCategory(@PathVariable String category) {
        return ResponseEntity.ok(hairServiceService.getServicesByCategory(category));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<List<HairService>> getServicesByMaxPrice(@PathVariable BigDecimal price) {
        return ResponseEntity.ok(hairServiceService.getServicesByMaxPrice(price));
    }
}

