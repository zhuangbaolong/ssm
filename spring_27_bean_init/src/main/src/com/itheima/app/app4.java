package com.itheima.app;

import com.itheima.bean.Dog;
import com.itheima.config.SpringConfig3;
import com.itheima.config.SpringConfig4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class app4 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig4.class);
        String[] names = context.getBeanDefinitionNames();//得到所有的bean name
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println(context.getBean(Dog.class));
    }
}
