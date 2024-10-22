package com.Barbershop.Barbershop.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "BarberID")
    private Barber barber;

    @ManyToOne
    @JoinColumn(name = "ServiceID")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "ShopID")
    private Shop shop;

    @Column(nullable = false)
    private LocalDateTime appointmentDateTime;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    // Enum for appointment status
    public enum AppointmentStatus {
        Scheduled, Completed, Cancelled
    }

    // Getter and Setter for appointmentId
    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    // Other getters and setters for the entity fields can go here
}

