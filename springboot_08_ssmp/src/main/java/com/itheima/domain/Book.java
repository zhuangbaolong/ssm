package com.itheima.domain;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String name;
    private String type;
    private String description;

    // 省略构造方法、getter和setter方法
    public Book(){

    }
}
