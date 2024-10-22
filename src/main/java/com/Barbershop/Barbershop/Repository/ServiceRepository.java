package com.Barbershop.Barbershop.Repository;

import com.Barbershop.Barbershop.Entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    // Custom query methods can be added here
}
