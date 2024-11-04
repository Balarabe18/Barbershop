package com.Barbershop.Barbershop.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "barbers")
public class Barber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String specialization;

    @OneToMany(mappedBy = "barber")
    private List<Appointment> appointments;

    @ManyToMany
    @JoinTable(
            name = "barber_services",
            joinColumns = @JoinColumn(name = "barber_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<HairService> services;

    @Column(nullable = false)
    private boolean isAvailable;

    @ElementCollection
    @CollectionTable(name = "barber_working_hours")
    private List<WorkingHours> workingHours;
}