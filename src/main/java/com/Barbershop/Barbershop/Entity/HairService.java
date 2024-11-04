package com.Barbershop.Barbershop.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "hair_services")
public class HairService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer durationMinutes;

    @Column
    private String category;

    @ManyToMany(mappedBy = "services")
    private List<Barber> barbers;
}
