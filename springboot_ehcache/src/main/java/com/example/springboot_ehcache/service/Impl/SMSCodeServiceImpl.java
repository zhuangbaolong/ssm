package com.example.springboot_ehcache.service.Impl;


import com.example.springboot_ehcache.domain.SMSCode;
import com.example.springboot_ehcache.service.SMSCodeService;
import com.example.springboot_ehcache.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

//核心业务：验证码
@Service
public class SMSCodeServiceImpl  implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;
    
    @Override
    //放缓存
    @CachePut(value = "smsCode",key = "#tele")
    public String sendCodeToSMS(String tele) {
        String generator = codeUtils.generator(tele);
        return generator;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = smsCode.getCode();
        String cacheCode = codeUtils.get(smsCode.getTele());
        System.out.println(cacheCode);
        return code.equals(cacheCode);
    }
}
