package com.Barbershop.Barbershop.Repository;

import com.Barbershop.Barbershop.Entity.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends JpaRepository<Barber, Long> {
    // Custom query methods can be added here
}
