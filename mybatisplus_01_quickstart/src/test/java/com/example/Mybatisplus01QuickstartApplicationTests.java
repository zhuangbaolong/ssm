package com.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    void testGetUserAll(){
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }

    @Test
    void testGetUserById(){
        User user = userDao.selectById(1L);
        System.out.println(user);
    }

    @Test
    void testSave(){
        User user = new User();
//        user.setId(2L);
        user.setName("tom");
        user.setPassword("123");
        user.setAge(12);
        user.setTel("12345678912");
        userDao.insert(user);
    }

    @Test
    void testDelete(){
        userDao.deleteById(1679770615974711297L);
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(1L);
        user.setName("Tom666");
        user.setPassword("1111");
        userDao.updateById(user);
    }

    //分页查询
    @Test
    void testGetByPage(){
        //查第一页2条数据
        IPage iPage = new Page(1,2);
        userDao.selectPage(iPage,null);
        //当前页码值
        System.out.println("当前页码值:"+iPage.getCurrent());
        System.out.println("每页显示数:"+iPage.getSize());
        System.out.println("一共多少页:"+iPage.getPages());
        System.out.println("一共多少条:"+iPage.getTotal());
        System.out.println("数据:"+iPage.getRecords());
    }
}
