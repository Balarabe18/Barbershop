package com.Barbershop.Barbershop.Service.Impl;

import com.Barbershop.Barbershop.Entity.User;
import com.Barbershop.Barbershop.Repository.UserRepository;
import com.Barbershop.Barbershop.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered"); // Change to RuntimeException if you don't want custom exceptions
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")); // Change to RuntimeException if you don't want custom exceptions
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        User existingUser = getUserById(user.getId());
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        if (user.getPassword() != null) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(existingUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
