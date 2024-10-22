package com.Barbershop.Barbershop.Controller;

import com.Barbershop.Barbershop.Entity.Service;
import com.Barbershop.Barbershop.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<Service> createService(@RequestBody Service service) {
        Service createdService = serviceService.createService(service);
        return ResponseEntity.ok(createdService);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Service>> getServiceById(@PathVariable Long id) {
        Optional<Service> service = serviceService.getServiceById(id);
        return ResponseEntity.ok(service);
    }

    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        List<Service> services = serviceService.getAllServices();
        return ResponseEntity.ok(services);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> updateService(@PathVariable Long id, @RequestBody Service service) {
        service.setServiceId(id);
        Service updatedService = serviceService.updateService(service);
        return ResponseEntity.ok(updatedService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}

