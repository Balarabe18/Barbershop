package com.Barbershop.Barbershop.Service.Impl;

import com.Barbershop.Barbershop.Entity.Barber;
import com.Barbershop.Barbershop.Repository.BarberRepository;
import com.Barbershop.Barbershop.Service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarberServiceImpl implements BarberService {

    @Autowired
    private BarberRepository barberRepository;

    @Override
    public Barber createBarber(Barber barber) {
        return barberRepository.save(barber);
    }

    @Override
    public Optional<Barber> getBarberById(Long id) { // Return Optional
        return barberRepository.findById(id); // Adjusted to return Optional
    }

    @Override
    public List<Barber> getAllBarbers() {
        return barberRepository.findAll();
    }

    @Override
    public Barber updateBarber(Barber barber) {
        return barberRepository.save(barber);
    }

    @Override
    public void deleteBarber(Long id) {
        barberRepository.deleteById(id);
    }

    @Override
    public List<Barber> getBarbersByShop(Long shopId) {
        return barberRepository.findByShopId(shopId); // You need to implement this in the repository
    }

    @Override
    public List<Barber> findBarbersBySpecialty(String specialty) {
        return barberRepository.findBySpecialtiesContaining(specialty); // You need to implement this in the repository
    }

    @Override
    public List<Barber> findBarbersByExperience(int yearsOfExperience) {
        return barberRepository.findByYearsOfExperienceGreaterThanEqual(yearsOfExperience); // You need to implement this in the repository
    }
}

