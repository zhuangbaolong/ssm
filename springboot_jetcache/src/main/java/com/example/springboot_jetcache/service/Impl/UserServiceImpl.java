package com.example.springboot_jetcache.service.Impl;

//import com.alicp.jetcache.anno.Cached;
import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.example.springboot_jetcache.dao.UserDao;
import com.example.springboot_jetcache.domain.User;
import com.example.springboot_jetcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Cached(name = "user_",key = "#id",expire = 3600,cacheType = CacheType.REMOTE)
    public User getUserById(Long id) {
        return userDao.selectById(id);
    }

    @Override
    public boolean save(User user) {
        return userDao.insert(user)>0;
    }

    @Override
    @CacheUpdate(name = "user_",key = "#user.id",value = "#user")
    public boolean update(User user) {
        return userDao.updateById(user)>0;
    }

    @Override
    @CacheInvalidate(name="user_",key = "#id")
    public boolean delete(Long id) {
        return userDao.deleteById(id)>0;
    }

    @Override
    public List<User> getAll() {
        return userDao.selectList(null);
    }
}
