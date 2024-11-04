package com.Barbershop.Barbershop.Service;

import com.Barbershop.Barbershop.Entity.Barber;

import java.time.LocalDateTime;
import java.util.List;

public interface BarberService {
    Barber createBarber(Barber barber);
    List<Barber> getAvailableBarbers(LocalDateTime dateTime);
    List<Barber> getAllBarbers(); // Add this line
    Barber updateBarber(Barber barber);
}
