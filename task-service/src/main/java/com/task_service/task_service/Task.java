package com.task_service.task_service;


public class Task {
    
    private int id;
    private String title;
    private String description;
    private int userId;
    private boolean status = false;

    public Task(int id, String title, String description, int userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

 
    public void toggleStatus() {
        this.status = !this.status;
    }

    @Override
    public String toString() {
        return "Task{id=" + id + 
               ", title='" + title + '\'' + 
               ", description='" + description + '\'' + 
               ", status=" + (status ? "Completed" : "Pending") + '}';
    }


}
