package com.example.springboot_memcached.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SMSCode implements Serializable {
    private String tele;
    private String code;
}
