package com.Barbershop.Barbershop.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @OneToMany(mappedBy = "user")
    private List<Appointment> appointments;

    @Column(nullable = false, updatable = false) // Prevent updates to createdAt
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
    public enum UserRole {
        ROLE_USER,
        ROLE_ADMIN,
        ROLE_BARBER
    }
}

