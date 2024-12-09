package com.task_service.task_service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaskEventPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishTaskCreatedEvent(Task task) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.TASK_EVENTS_QUEUE, "Tasl Created "+ task.getId());
    }

    public void publishTaskUpdatedEvent(Task task) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.TASK_EVENTS_QUEUE, "Task Updated: " + task.getId());
    }

    public void publishTaskDeletedEvent(UUID taskId) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.TASK_EVENTS_QUEUE, "Task Deleted: " + taskId);
    }
    
}