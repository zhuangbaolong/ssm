package com.example.springboot_jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//jetcache启用缓存
@EnableCreateCacheAnnotation
public class SpringbootJetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJetcacheApplication.class, args);
    }

}
