package com.Barbershop.Barbershop.Repository;

import com.Barbershop.Barbershop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findByRole(UserRoleAuthorizationInterceptor role);
}
