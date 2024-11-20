package com.Barbershop.Barbershop.Service.Impl;

import com.Barbershop.Barbershop.Entity.Appointment;
import com.Barbershop.Barbershop.Repository.AppointmentRepository;
import com.Barbershop.Barbershop.Repository.BarberRepository;
import com.Barbershop.Barbershop.Repository.UserRepository;
import com.Barbershop.Barbershop.Service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private final BarberRepository barberRepository;

    @Override
    @Transactional
    public Appointment createAppointment(Appointment appointment) {
        // You can add any validation logic here if needed
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAppointmentsByUserId(Long userId) {
        return appointmentRepository.findByUser_Id(userId);
    }

    @Override
    public List<Appointment> getAppointmentsByBarberId(Long barberId) {
        return appointmentRepository.findByBarber_Id(barberId);
    }
}
