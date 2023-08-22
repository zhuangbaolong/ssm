package com.example.springboot_mq.service;

import org.springframework.stereotype.Service;

@Service
public interface MessageService {
    void sendMessage(String id);
    String doMessage();
}
