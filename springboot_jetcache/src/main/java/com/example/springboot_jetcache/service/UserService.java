package com.example.springboot_jetcache.service;


import com.example.springboot_jetcache.domain.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    boolean save(User user);
    boolean update(User user);
    boolean delete(Long id);
    List<User> getAll();
}
