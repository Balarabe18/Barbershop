package com.Barbershop.Barbershop.Service;

import java.util.List;
import java.util.Optional;

import com.Barbershop.Barbershop.Entity.User;
import com.Barbershop.Barbershop.Entity.User.UserType;

public interface UserService {


        User createUser(User user);
        Optional<User> getUserById(Long id);
        Optional<User> getUserByEmail(String email);
        List<User> getAllUsers();
        List<User> getUsersByType(User.UserType userType);
        User updateUser(User user);
        void deleteUser(Long id);
        boolean existsByEmail(String email);
    }

