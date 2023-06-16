package com.test.controller;

import com.test.entity.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

//2.controller
@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/commonParam")
    //设置当前返回值类型
    public String commonParam(String name) {
        System.out.println("user: " + name);
        return "{'module':" + name + "'common param'}";
    }

    //日期类型传参
    @RequestMapping("/dateParam")
    public String dateParam(Date date,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
                            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date2) {
        System.out.println("date(默认): " + date);
        System.out.println("date(yyyy-mm-dd): " + date1);
        System.out.println("date(yyyy-mm-dd HH:mm:ss): " + date2);
        return "{'module':" + date + "'date param'}";
    }

    //pojo传参
    @RequestMapping("/pojoParam")
    public String pojoParam(User user) {
        System.out.println("user: " + user);
        return "{'module':" + user + "'date param'}";
    }

    //实体类嵌套实体类
    @RequestMapping("/pojoContainPojoParam")
    public String pojoContainPojoParam(User user) {
        System.out.println("user: " + user);
        return "{'module':" + user + "'date param'}";
    }

    //数组传参
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] likes) {
        System.out.println("user: " + Arrays.toString(likes));
        System.out.println("user: " + likes);
        return "{'module':" + likes + "'date param'}";
    }

    //集合参数
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> likes) {
        System.out.println("user: " + likes);
        return "{'module':" + likes + "'date param'}";
    }

    //json
    @RequestMapping("/listParamForJson")
    public String listParamForJson(@RequestBody List<String> likes) {
        System.out.println("user: " + likes);
        return "{'module':" + likes + "'date param'}";
    }

    //pojo参数：json
    @RequestMapping("/pojoParamForJson")
    public String pojoParamForJson(@RequestBody User user) {
        System.out.println("user: " + user);
        return "{'module':" + user + "'date param'}";
    }

    //多个实体类:json
    @RequestMapping("/listPojoParamForJson")
    public String listPojoParamForJson(@RequestBody List<User> userList) {
        System.out.println("user: " + userList);
        return "{'module':" + userList + "'date param'}";
    }
}
