package com.Barbershop.Barbershop.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "barber_id", nullable = false)
    private Barber barber;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private HairService service;

    @Column(nullable = false)
    private LocalDateTime appointmentDateTime;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @Column(nullable = false)
    private BigDecimal price;

    @Column
    private String notes;

    @Column(nullable = false, updatable = false) // Prevent updates to createdAt
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public enum AppointmentStatus {
        PENDING,
        CONFIRMED,
        CANCELED
    }
}

