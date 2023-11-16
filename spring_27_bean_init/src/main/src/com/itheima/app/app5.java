package com.itheima.app;

import com.itheima.bean.Cat;
import com.itheima.bean.Dog;
import com.itheima.bean.Mouse;
import com.itheima.config.SpringConfig4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class app5 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig4.class);
        //上下文容器对象已经初始化完，手工加载bean
        context.registerBean("tom", Cat.class,0);
        context.registerBean("tom", Cat.class,1);
        //加载bean,类名首字母小写
        context.register(Mouse.class);
        String[] names = context.getBeanDefinitionNames();//得到所有的bean name
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println(context.getBean(Cat.class));
    }
}
