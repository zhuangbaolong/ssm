package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//2.controller
@Controller
public class UserController {

    @RequestMapping("/commonParam")
    //设置当前返回值类型
    @ResponseBody
    public String commonParam(String name){
        System.out.println("user: "+name);
        return "{'module':"+name +"'common param'}";
    }
}
