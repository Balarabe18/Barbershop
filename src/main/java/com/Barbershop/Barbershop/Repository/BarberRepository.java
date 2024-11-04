package com.Barbershop.Barbershop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Barbershop.Barbershop.Entity.Barber;

import java.util.List;

@Repository
public interface BarberRepository extends JpaRepository<Barber, Long> {
    List<Barber> findByIsAvailable(boolean isAvailable);
    List<Barber> findByServicesId(Long serviceId);
}