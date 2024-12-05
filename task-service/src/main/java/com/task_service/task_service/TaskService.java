package com.task_service.task_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TaskService {

    @Autowired
    private Repository repository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String USER_SERVICE_URL = "http://localhost:8080/api/v1/users"; // Update the URL to the actual UserService endpoint

    private boolean doesUserExist(int userId) {
        try {
            restTemplate.getForObject(USER_SERVICE_URL + "/" + userId, String.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void addTask(int id, String title, String description, int userId) {
        if (!doesUserExist(userId)) {
            throw new IllegalArgumentException("User with ID " + userId + " does not exist.");
        }
        Task newTask = new Task(id, title, description, userId);
        repository.addTask(newTask);
    }

    public void updateTask(int id, String title, String description, boolean status, int userId) {
        if (!doesUserExist(userId)) {
            throw new IllegalArgumentException("User with ID " + userId + " does not exist.");
        }
        Task updatedTask = new Task(id, title, description, userId);
        updatedTask.setStatus(status);
        boolean success = repository.updateTask(id, updatedTask);
        if (!success) {
            throw new IllegalArgumentException("Task with ID " + id + " not found for update.");
        }
    }

    public List<Task> getAllTasks() {
        return repository.getAllTasks();
    }

    public Task getTaskById(int id) {
        Task task = repository.getTaskById(id);
        if (task == null) {
            throw new IllegalArgumentException("Task with ID " + id + " not found.");
        }
        return task;
    }

    public void toggleTaskStatus(int id) {
        Task task = getTaskById(id);
        task.toggleStatus();
        repository.updateTask(id, task);
    }

    public void deleteTask(int id) {
        boolean success = repository.deleteTask(id);
        if (!success) {
            throw new IllegalArgumentException("Task with ID " + id + " not found for deletion.");
        }
    }
}
