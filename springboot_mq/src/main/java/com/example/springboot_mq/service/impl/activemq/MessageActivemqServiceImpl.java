package com.example.springboot_mq.service.impl.activemq;

import com.example.springboot_mq.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageActivemqServiceImpl implements MessageService {

    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    public void sendMessage(String id) {
        System.out.println("待发送的短信订单已纳入处理队列，id:"+id);
        messagingTemplate.convertAndSend("order.queue.id",id);
    }

    public String doMessage() {
        String id = messagingTemplate.receiveAndConvert("order.queue.id",String.class);
        System.out.println("已完成短信发送业务,id:"+id);
        return id;
    }
}
