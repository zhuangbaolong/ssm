package com.example.springboot_mybatisplus;

import com.example.springboot_mybatisplus.dao.UserDao;
import com.example.springboot_mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisplusApplicationTests {


    @Autowired
    private UserService userService;

    @Test
    void getUserAll(){
        System.out.println(userService.getUserById(1L));
    }

}
