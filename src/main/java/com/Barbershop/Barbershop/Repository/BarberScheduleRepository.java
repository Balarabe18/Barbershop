package com.Barbershop.Barbershop.Repository;

import com.Barbershop.Barbershop.Entity.BarberSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberScheduleRepository extends JpaRepository<BarberSchedule, Long> {
    // Custom query methods can be added here
}
