package com.example.rabbitmqdemo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @RabbitListener(queues = "my-queue")
    public void receiveMessage(String message) {
        try {


            System.out.println("Received from RabbitMQ: " + message);
            messagingTemplate.convertAndSend("/topic/messages", message);
            ListOperations<String, Object> listOps = redisTemplate.opsForList();
            listOps.leftPush("notificationHistory", message);
        }
        catch (Exception exception){
            System.err.println("Exception:::::!!!!! " + exception);

        }

    }
}

