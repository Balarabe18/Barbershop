package com.Barbershop.Barbershop.Service;

import com.Barbershop.Barbershop.Entity.Appointment;
import com.Barbershop.Barbershop.Entity.Appointment.AppointmentStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);
    Optional<Appointment> getAppointmentById(Long id);
    List<Appointment> getAllAppointments();
    List<Appointment> getAppointmentsByBarber(Long barberId);
    List<Appointment> getAppointmentsByCustomer(Long customerId);
    List<Appointment> getAppointmentsByShop(Long shopId);
    List<Appointment> getAppointmentsByDateRange(LocalDateTime start, LocalDateTime end);
    List<Appointment> getAppointmentsByStatus(Appointment.AppointmentStatus status);
    Appointment updateAppointment(Appointment appointment);
    void deleteAppointment(Long id);
    boolean isTimeSlotAvailable(Long barberId, LocalDateTime dateTime);
}