package com.Barbershop.Barbershop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Barbershop.Barbershop.Entity.Appointment;
import com.Barbershop.Barbershop.Entity.Appointment.AppointmentStatus; // Ensure to import AppointmentStatus

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByUser_Id(Long userId); // Corrected method name for accessing nested properties
    List<Appointment> findByBarber_Id(Long barberId); // Corrected method name for accessing nested properties
    List<Appointment> findByAppointmentDateTimeBetween(LocalDateTime start, LocalDateTime end);
    List<Appointment> findByStatus(Appointment.AppointmentStatus status);
}
