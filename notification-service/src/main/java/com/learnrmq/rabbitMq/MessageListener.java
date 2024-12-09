package com.learnrmq.rabbitMq;


import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class MessageListener {

    @RabbitListener(queues = RabbitMQConfig.TASK_EVENTS_QUEUE)
    public void listener(String message) {
        System.out.println("Received from RabbitMQ: " + message);
    }

}
