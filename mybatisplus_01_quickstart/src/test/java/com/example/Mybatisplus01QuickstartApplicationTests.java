package com.example;

import com.example.Dao.UserDao;
import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {


    @Autowired
    private UserDao userDao;

    @Test
    void GetUserAll(){
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }
}
