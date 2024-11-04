package com.Barbershop.Barbershop.Service.Impl;

import com.Barbershop.Barbershop.Entity.Barber;
import com.Barbershop.Barbershop.Repository.BarberRepository;
import com.Barbershop.Barbershop.Service.BarberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BarberServiceImpl implements BarberService {

    private final BarberRepository barberRepository;

    @Override
    @Transactional
    public Barber createBarber(Barber barber) {
        return barberRepository.save(barber);
    }

    @Override
    public List<Barber> getAvailableBarbers(LocalDateTime dateTime) {
        return barberRepository.findByIsAvailable(true);
    }


    @Override
    public List<Barber> getAllBarbers() {
        return barberRepository.findAll(); // Ensure this method exists in your repository
    }

    @Override
    @Transactional
    public Barber updateBarber(Barber barber) {
        return barberRepository.save(barber);
    }
}

