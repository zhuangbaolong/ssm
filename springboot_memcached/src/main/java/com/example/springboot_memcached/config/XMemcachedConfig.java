package com.example.springboot_memcached.config;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

//spring管理config
@Configuration
public class XMemcachedConfig {

    @Autowired
    private XMemcachedProperties memcachedProperties;
    @Bean
    public MemcachedClient getMemcachedClient() throws IOException {
        //配置memcached
        MemcachedClientBuilder memcachedClientBuilder = new XMemcachedClientBuilder(memcachedProperties.getServers());
        memcachedClientBuilder.setOpTimeout(memcachedProperties.getOpTimeout());
        memcachedClientBuilder.setConnectionPoolSize(memcachedProperties.getPoolSize());
        MemcachedClient memcachedClient = memcachedClientBuilder.build();
        return memcachedClient;
    }
}
