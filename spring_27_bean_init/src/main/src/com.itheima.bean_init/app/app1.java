package com.itheima.bean_init.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class app1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Object cat = context.getBean("cat");
        System.out.println(cat);//com.itheima.bean_init.Cat@e45f292
    }
}
