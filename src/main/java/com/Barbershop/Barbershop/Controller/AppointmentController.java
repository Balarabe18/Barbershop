package com.Barbershop.Barbershop.Controller;

import com.Barbershop.Barbershop.Entity.Appointment;
import com.Barbershop.Barbershop.Service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.createAppointment(appointment));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Appointment>> getUserAppointments(@PathVariable Long userId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByUserId(userId));
    }

    @GetMapping("/barber/{barberId}")
    public ResponseEntity<List<Appointment>> getBarberAppointments(@PathVariable Long barberId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByBarberId(barberId));
    }
}
