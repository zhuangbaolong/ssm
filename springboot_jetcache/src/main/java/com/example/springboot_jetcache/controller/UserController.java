package com.example.springboot_jetcache.controller;

import com.example.springboot_jetcache.domain.User;
import com.example.springboot_jetcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("")
    public boolean saveUser(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id){
        return userService.delete(id);
    }

    @PutMapping("")
    public boolean updateUser(@RequestBody User user){
        return userService.update(user);
    }
}
