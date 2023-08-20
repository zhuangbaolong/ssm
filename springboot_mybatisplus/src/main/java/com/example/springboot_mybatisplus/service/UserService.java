package com.example.springboot_mybatisplus.service;

import com.example.springboot_mybatisplus.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User getUserById(Long id);
    List<User> getAllUser();
    boolean saverUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(Long id);
}
