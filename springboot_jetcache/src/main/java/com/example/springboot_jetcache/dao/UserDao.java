package com.example.springboot_jetcache.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_jetcache.domain.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao extends BaseMapper<User> {
}
