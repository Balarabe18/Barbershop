package com.Barbershop.Barbershop.Service;

import com.Barbershop.Barbershop.Entity.Appointment;
import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);
    List<Appointment> getAppointmentsByUserId(Long userId);
    List<Appointment> getAppointmentsByBarberId(Long barberId);
}
