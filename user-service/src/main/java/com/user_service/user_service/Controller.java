package com.user_service.user_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class Controller {

    @Autowired
    private UserService service;

    @PostMapping
    public String createUser(@RequestBody User user) {
        service.addUser(user);
        return "User created successfully!";
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        boolean isUpdated = service.updateUser(id, updatedUser);
        return isUpdated ? "User updated successfully!" : "User not found.";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        boolean isDeleted = service.deleteUser(id);
        return isDeleted ? "User deleted successfully!" : "User not found.";
    }
}
