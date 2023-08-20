package com.example.springboot_jetcache.service.Impl;


import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.example.springboot_jetcache.domain.SMSCode;
import com.example.springboot_jetcache.service.SMSCodeService;
import com.example.springboot_jetcache.utils.CodeUtils;
//import org.checkerframework.checker.mustcall.qual.CreatesMustCallFor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

//核心业务：验证码
@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;


    //remote
//    @CreateCache(name = "jetCache", area = "sms", expire = 3600, timeUnit = TimeUnit.SECONDS)
    //本地方案
    @CreateCache(name = "jetcache",  expire = 3600, timeUnit = TimeUnit.SECONDS,cacheType = CacheType.BOTH)
    private Cache<String, String> jetCache;

    @Override
    //放缓存
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        jetCache.put(tele, code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = jetCache.get(smsCode.getTele());
        return smsCode.getCode().equals(code);
    }
}
