package com.itheima.app;

import com.itheima.config.SpringConfig3;
import com.itheima.config.SpringConfig32;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class app32 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig32.class);
        String[] names = context.getBeanDefinitionNames();//得到所有的bean name
        for (String name : names) {
            System.out.println(name);
        }
    }
}
