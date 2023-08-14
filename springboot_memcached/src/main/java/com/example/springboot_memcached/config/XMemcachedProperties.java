package com.example.springboot_memcached.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "memcached")
public class XMemcachedProperties {

    //服务器地址
    private String servers;
    //连接池大小
    private int poolSize;
    //超时时间
    private long opTimeout;
}
