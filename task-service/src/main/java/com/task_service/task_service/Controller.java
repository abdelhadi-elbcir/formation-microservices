package com.task_service.task_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin
public class Controller {

    @Autowired
    private TaskService service;

    @Autowired
    private TaskEventPublisher taskEventPublisher;

    @PostMapping
    public void addTask(@RequestBody Task task) {
        taskEventPublisher.publishTaskCreatedEvent(task);
        service.addTask(task.getId(), task.getTitle(), task.getDescription(), task.getUserId());
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return service.getTaskById(id);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable int id, @RequestBody Task task) {
        service.updateTask(id, task.getTitle(), task.getDescription(), task.isStatus(), task.getUserId());
    }

    @PatchMapping("/{id}/toggle-status")
    public void toggleTaskStatus(@PathVariable int id) {
        service.toggleTaskStatus(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }

}
