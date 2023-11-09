package com.itheima.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class app1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
//        Object cat = context.getBean("cat");//指定名称
//        System.out.println(cat);//com.itheima.bean_init.Cat@e45f292
//        Dog dog = context.getBean(Dog.class);//指定类型
//        System.out.println(dog);// com.itheima.bean_init.Dog@56ac3a89
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
