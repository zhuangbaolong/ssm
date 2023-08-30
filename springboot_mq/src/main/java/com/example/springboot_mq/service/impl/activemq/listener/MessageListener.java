package com.example.springboot_mq.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

//监听
@Component
public class MessageListener {


    //监听orders
    @JmsListener(destination = "order.queue.id")
    //接受消息后发给新的队列
    @SendTo("order.other.queue.id")
    public String recevie(String id) {
        System.out.println("已完成短信发送业务,id:"+id);
        return "new"+id;
    }
}
