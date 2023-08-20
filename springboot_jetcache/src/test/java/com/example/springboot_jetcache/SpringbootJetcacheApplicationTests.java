package com.example.springboot_jetcache;

import com.example.springboot_jetcache.dao.UserDao;
import com.example.springboot_jetcache.domain.User;
import com.example.springboot_jetcache.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
class SpringbootJetcacheApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUser(){
        User user = userService.getUserById(1L);
        System.out.println(user);
    }

}
