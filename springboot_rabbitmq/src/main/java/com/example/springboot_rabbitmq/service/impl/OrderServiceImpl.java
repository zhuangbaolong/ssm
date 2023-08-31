package com.example.springboot_rabbitmq.service.impl;


import com.example.springboot_rabbitmq.service.MessageService;
import com.example.springboot_rabbitmq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MessageService mes;

    @Override
    public void order(String id) {
        //一系列操作，包含各种服务调用，处理各种业务
        System.out.println("订单开始处理!!");
        //短信消息处理
        mes.sendMessage(id);
        System.out.println("订单处理结束!!");
        System.out.println();
    }
}
