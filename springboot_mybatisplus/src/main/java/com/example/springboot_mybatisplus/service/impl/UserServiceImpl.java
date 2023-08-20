package com.example.springboot_mybatisplus.service.impl;

import com.example.springboot_mybatisplus.dao.UserDao;
import com.example.springboot_mybatisplus.domain.User;
import com.example.springboot_mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.UIResource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Long id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.selectList(null);
    }

    @Override
    public boolean saverUser(User user) {
        return userDao.insert(user)>0;
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateById(user)>0;
    }


    @Override
    public boolean deleteUser(Long id) {
        return userDao.deleteById(id)>0;
    }
}
