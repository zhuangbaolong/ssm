package com.itheima.app;

import com.itheima.bean.service.BookService;
import com.itheima.bean.service.impl.BookServiceImpl1;
import com.itheima.config.SpringConfig7;
import com.itheima.config.SpringConfig8;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class app8 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig8.class);
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.check();
    }
}
