package com.example.springboot_jetcache.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

//验证码工具
@Component
public class CodeUtils {

    //加密生成验证码
    public String generator(String tele) {
        int hashCode = tele.hashCode(); //转成hashCode
        //加密
        int encryption = 20206666;
        //异或加密密码
        long result = hashCode ^ encryption;
        //当前时间戳
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        result = result<0? -result:result;
        String res = String.valueOf(result);
        res = res.substring(res.length() - 6);
        return res;
    }

    //取缓存tele得值
    @Cacheable(value = "smsCode",key = "#tele")
    public String get(String tele){
        return null;
    }
//
//    public static void main(String[] args) {
//        System.out.println(new CodeUtils().generator("18866668888"));
//    }
}
