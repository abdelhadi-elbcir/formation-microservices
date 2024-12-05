package com.task_service.task_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private Repository repository;

    public void addTask(int id, String title, String description, int userId) {
        Task newTask = new Task(id, title, description, userId);
        repository.addTask(newTask);
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

    public void updateTask(int id, String title, String description, boolean status,int userId) {
        Task updatedTask = new Task(id, title, description, userId);
        updatedTask.setStatus(status);
        boolean success = repository.updateTask(id, updatedTask);
        if (!success) {
            throw new IllegalArgumentException("Task with ID " + id + " not found for update.");
        }
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
