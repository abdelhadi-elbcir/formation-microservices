package com.task_service.task_service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class Repository {

    private List<Task> db;

    public Repository() {
        this.db = new ArrayList<>();
    }

    public void addTask(Task task) {
        db.add(task);
    }

    // Read: Get all tasks
    public List<Task> getAllTasks() {
        return new ArrayList<>(db);
    }

    // Read: Get a task by ID
    public Task getTaskById(long id) {
        for (Task task : db) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null; 
    }

    public boolean updateTask(long id, Task updatedTask) {
        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getId() == id) {
                db.set(i, updatedTask);
                return true; 
            }
        }
        return false; 
    }

    public boolean deleteTask(int id) {
        return db.removeIf(task -> task.getId() == id);
    }
}
