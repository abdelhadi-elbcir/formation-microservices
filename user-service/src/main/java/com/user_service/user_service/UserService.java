package com.user_service.user_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private Repository repository;

    public void addUser(User user) {
        repository.addUser(user);
    }

    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    public Optional<User> getUserById(int id) {
        return repository.getUserById(id);
    }

    public boolean updateUser(int id, User updatedUser) {
        return repository.updateUser(id, updatedUser);
    }

    public boolean deleteUser(int id) {
        return repository.deleteUser(id);
    }
    
}
