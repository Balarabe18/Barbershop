package com.Barbershop.Barbershop.Repository;

import com.Barbershop.Barbershop.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Custom query methods can be added here
}
