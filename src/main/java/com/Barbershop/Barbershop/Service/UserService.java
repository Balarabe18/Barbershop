package com.Barbershop.Barbershop.Service;


import com.Barbershop.Barbershop.Entity.User;

public interface UserService {
        User createUser(User user);
        User getUserById(Long id);
        User updateUser(User user);
        void deleteUser(Long id);
}

