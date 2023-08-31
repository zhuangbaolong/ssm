package com.example.springboot_rabbitmq.service.impl.rabbitmq.direct.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class MessageListener {

    @RabbitListener(queues = "direct_queue")
    public void receive(String id){
        System.out.println("处理：已完成短信业务（rabbitmq direct）.id"+id);
    }
}
