package com.Barbershop.Barbershop.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class HairServiceController {
    private final HairServiceService hairServiceService;

    @PostMapping
    public ResponseEntity<HairService> createService(@RequestBody HairService service) {
        return ResponseEntity.ok(hairServiceService.createService(service));
    }

    @GetMapping
    public ResponseEntity<List<HairService>> getAllServices() {
        return ResponseEntity.ok(hairServiceService.getAllServices());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<HairService>> getServicesByCategory(@PathVariable String category) {
        return ResponseEntity.ok(hairServiceService.getServicesByCategory(category));
    }
}

