package com.Barbershop.Barbershop.Repository;

import com.Barbershop.Barbershop.Entity.User;
import com.Barbershop.Barbershop.Entity.User.UserType; // Ensure this import is correct
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findByUserType(UserType userType); // This should match your enum
}
