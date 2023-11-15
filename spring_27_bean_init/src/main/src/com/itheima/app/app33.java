package com.itheima.app;

import com.itheima.config.SpringConfig32;
import com.itheima.config.SpringConfig33;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class app33 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig33.class);
        String[] names = context.getBeanDefinitionNames();//得到所有的bean name
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("--------------默认CGLIB代理创建");
        System.out.println(context.getBean("springConfig33"));
    }
}
