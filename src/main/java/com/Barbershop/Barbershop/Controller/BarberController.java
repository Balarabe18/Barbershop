package com.Barbershop.Barbershop.Controller;

import com.Barbershop.Barbershop.Entity.Barber;
import com.Barbershop.Barbershop.Service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/barbers")
public class BarberController {

    @Autowired
    private BarberService barberService;

    @PostMapping
    public ResponseEntity<Barber> createBarber(@RequestBody Barber barber) {
        Barber createdBarber = barberService.createBarber(barber);
        return ResponseEntity.ok(createdBarber);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Barber>> getBarberById(@PathVariable Long id) {
        Optional<Barber> barber = barberService.getBarberById(id);
        return ResponseEntity.ok(barber);
    }

    @GetMapping
    public ResponseEntity<List<Barber>> getAllBarbers() {
        List<Barber> barbers = barberService.getAllBarbers();
        return ResponseEntity.ok(barbers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barber> updateBarber(@PathVariable Long id, @RequestBody Barber barber) {
        barber.setBarberId(id);
        Barber updatedBarber = barberService.updateBarber(barber);
        return ResponseEntity.ok(updatedBarber);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarber(@PathVariable Long id) {
        barberService.deleteBarber(id);
        return ResponseEntity.noContent().build();
    }
}

