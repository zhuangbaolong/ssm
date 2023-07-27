package com.example.springboot_cache.service;

import com.example.springboot_cache.domain.SMSCode;

public interface SMSCodeService {
    //发送验证码
    public String sendCodeToSMS(String code);
    //校验验证码
    public boolean checkCode(SMSCode smsCode);
}
