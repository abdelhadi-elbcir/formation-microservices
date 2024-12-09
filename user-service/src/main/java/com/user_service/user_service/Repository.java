package com.user_service.user_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class Repository {

    private List<User> db = new ArrayList<>();

    public void addUser(User user) {
        db.add(user);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(db);
    }

    public Optional<User> getUserById(int id) {
        return db.stream()
                 .filter(user -> user.getId() == id)
                 .findFirst();
    }

    public boolean checkUserId(int id) {
        return db.stream()
                 .filter(user -> user.getId() == id)
                 .findFirst().isPresent();
    }

    public boolean updateUser(int id, User updatedUser) {
        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getId() == id) {
                db.set(i, updatedUser);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id) {
        return db.removeIf(user -> user.getId() == id);
    }
}
