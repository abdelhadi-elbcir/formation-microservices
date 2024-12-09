package com.learnrmq.rabbitMq;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final NotificationService notificationService;

    public WebSocketController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @MessageMapping("/sendNotification")
    @SendTo("/topic/notifications")
    public Notification sendNotification(Notification notification) {
        notificationService.sendNotification(notification);
        return notification;
    }

}