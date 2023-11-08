package com.itheima.bean_init.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class app2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        String[] names = context.getBeanDefinitionNames();//得到所有的bean name
        for (String name : names) {
            System.out.println(name);
        }
        /**
         * cat
         * com.itheima.bean_init.Dog#0
         */
    }
}
