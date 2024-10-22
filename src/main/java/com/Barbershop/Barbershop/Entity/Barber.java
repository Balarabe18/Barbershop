package com.Barbershop.Barbershop.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Barber")
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long barberId;  // Unique identifier for the Barber

    @OneToOne
    @JoinColumn(name = "UserID")  // Foreign key reference to User entity
    private User user;

    @ManyToOne
    @JoinColumn(name = "ShopID")  // Foreign key reference to Shop entity
    private Shop shop;

    private String specialties;  // Barber specialties
    private Integer yearsOfExperience;  // Years of experience

    // Getters and Setters
    public Long getBarberId() {
        return barberId;
    }

    public void setBarberId(Long barberId) {
        this.barberId = barberId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}

