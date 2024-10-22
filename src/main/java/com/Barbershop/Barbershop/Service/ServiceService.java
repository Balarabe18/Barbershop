package com.Barbershop.Barbershop.Service;

import com.Barbershop.Barbershop.Entity.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceService {

    // Create a new service
    Service createService(Service service);

    // Retrieve a service by its ID
    Optional<Service> getServiceById(Long id);

    // Retrieve all available services
    List<Service> getAllServices();

    // Update an existing service
    Service updateService(Service service);

    // Delete a service by its ID
    void deleteService(Long id);
}

