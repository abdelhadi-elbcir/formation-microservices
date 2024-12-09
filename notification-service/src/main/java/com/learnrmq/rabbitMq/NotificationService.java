package com.learnrmq.rabbitMq;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final RabbitTemplate rabbitTemplate;
    private final SimpMessagingTemplate messagingTemplate; // For sending WebSocket messages

    public NotificationService(RabbitTemplate rabbitTemplate, SimpMessagingTemplate messagingTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.messagingTemplate = messagingTemplate;
    }

    public void sendNotification(Notification notification) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.TASK_EVENTS_QUEUE, notification);
        messagingTemplate.convertAndSend("/topic/notifications", notification);
    }
    
}