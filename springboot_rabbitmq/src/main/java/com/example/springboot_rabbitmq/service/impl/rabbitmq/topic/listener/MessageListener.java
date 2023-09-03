package com.example.springboot_rabbitmq.service.impl.rabbitmq.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    //监听器
    @RabbitListener(queues = "topic_queue")
    public void receive(String id){
        System.out.println("处理：已完成短信业务（rabbitmq topic 1）.id"+id);
        System.out.println();
    }
    @RabbitListener(queues = "topic_queue2")
    public void receive2(String id){
        System.out.println("处理：已完成短信业务（rabbitmq topic 2）.id"+id);
        System.out.println();
    }
}
