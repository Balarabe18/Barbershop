package com.Barbershop.Barbershop.Controller;

import com.Barbershop.Barbershop.Entity.Barber;
import com.Barbershop.Barbershop.Service.BarberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/barbers")
@RequiredArgsConstructor
public class BarberController {
    private final BarberService barberService;

    @PostMapping
    public ResponseEntity<Barber> createBarber(@RequestBody Barber barber) {
        return ResponseEntity.ok(barberService.createBarber(barber));
    }

    @GetMapping
    public ResponseEntity<List<Barber>> getAllBarbers() {
        return ResponseEntity.ok(barberService.getAllBarbers());
    }

    @GetMapping("/available")
    public ResponseEntity<List<Barber>> getAvailableBarbers(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime
    ) {
        return ResponseEntity.ok(barberService.getAvailableBarbers(dateTime));
    }
}
