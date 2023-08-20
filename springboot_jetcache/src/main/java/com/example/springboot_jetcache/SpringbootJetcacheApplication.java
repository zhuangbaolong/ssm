package com.example.springboot_jetcache;

//import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
//import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan("com.example.springboot_jetcache.dao")
@SpringBootApplication
//jetcache启用缓存
@EnableCreateCacheAnnotation
//配合上面开启方法缓存
@EnableMethodCache(basePackages = "com.example.springboot_jetcache")
public class SpringbootJetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJetcacheApplication.class, args);
    }

}
