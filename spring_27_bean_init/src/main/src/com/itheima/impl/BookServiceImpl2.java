package com.itheima.impl;

import com.itheima.bean.service.BookService;

public class BookServiceImpl2 implements BookService {
    @Override
    public void check() {
        System.out.printf("book service 2...");
    }
}
