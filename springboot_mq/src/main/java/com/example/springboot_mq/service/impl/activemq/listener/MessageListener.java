package com.example.springboot_mq.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//监听
@Component
public class MessageListener {

    @JmsListener(destination = "orders.queue.id")
    public void recevie(String id) {
        System.out.println("已完成短信发送业务,id:"+id);
    }
}
