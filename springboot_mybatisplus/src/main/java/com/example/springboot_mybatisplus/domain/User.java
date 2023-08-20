package com.example.springboot_mybatisplus.domain;

import lombok.Data;

@Data
public class User  {
    private Long id;
    private String name;
    private String pwd;
    private Integer age;
    private String tel;
    private Integer deleted;
    private Integer version;
}
