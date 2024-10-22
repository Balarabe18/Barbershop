package com.Barbershop.Barbershop.Repository;

import com.Barbershop.Barbershop.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Custom query methods can be added here
}
