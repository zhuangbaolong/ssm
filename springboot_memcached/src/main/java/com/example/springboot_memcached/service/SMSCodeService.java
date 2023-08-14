package com.example.springboot_memcached.service;


import com.example.springboot_memcached.domain.SMSCode;

public interface SMSCodeService {
    //发送验证码
    public String sendCodeToSMS(String code);
    //校验验证码
    public boolean checkCode(SMSCode smsCode);
}
