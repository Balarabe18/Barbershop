package com.Barbershop.Barbershop.Service;

import java.util.List;
import java.util.Optional;

import com.Barbershop.Barbershop.Entity.Barber;

public interface BarberService {
    Barber createBarber(Barber barber);
    Optional<Barber> getBarberById(Long id); // Keep this as Optional
    List<Barber> getAllBarbers();
    List<Barber> getBarbersByShop(Long shopId);
    Barber updateBarber(Barber barber);
    void deleteBarber(Long id);
    List<Barber> findBarbersBySpecialty(String specialty);
    List<Barber> findBarbersByExperience(int yearsOfExperience);
}
