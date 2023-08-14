package com.example.springboot_memcached.service.Impl;



import com.example.springboot_memcached.config.XMemcachedConfig;
import com.example.springboot_memcached.domain.SMSCode;
import com.example.springboot_memcached.service.SMSCodeService;
import com.example.springboot_memcached.utils.CodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

//核心业务：验证码
@Service
public class SMSCodeServiceImpl  implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;
    @Autowired
    private XMemcachedConfig memcachedConfig;

    @Autowired
    private MemcachedClient memcachedClient;

    @Override
    public String sendCodeToSMS(String tele) {
        //生成验证码
        String code = codeUtils.generator(tele);
        try {
            //放缓存
            memcachedClient.set(tele,0,code);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = null;
        try {
            code = memcachedClient.get(smsCode.getTele()).toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return smsCode.getCode().equals(code);
    }

//    @Override
//    //放缓存
//    @CachePut(value = "smsCode",key = "#tele")
//    public String sendCodeToSMS(String tele) {
//        String generator = codeUtils.generator(tele);
//        return generator;
//    }
//
//    @Override
//    public boolean checkCode(SMSCode smsCode) {
//        String code = smsCode.getCode();
//        String cacheCode = codeUtils.get(smsCode.getTele());
//        System.out.println(cacheCode);
//        return code.equals(cacheCode);
//    }
}
