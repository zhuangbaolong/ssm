package com.test.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//3.创建springmvc配置文件，加载controller对应的bean
@Configuration
@ComponentScan("com.test.controller")
//开启json数据转对象等功能
@EnableWebMvc
public class SpringMvcConfig {
}
