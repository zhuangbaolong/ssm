package com.test.controller;

import com.test.entity.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    //日期类型传参
    @RequestMapping("/dateParam")
    @ResponseBody
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        System.out.println("date(yyyy-mm-dd): "+date);
        return "{'module':"+date +"'date param'}";
    }

    //pojo传参
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user){
        System.out.println("user: "+user);
        return "{'module':"+user +"'date param'}";
    }

    //实体类嵌套实体类
    @RequestMapping("/pojoContainPojoParam")
    @ResponseBody
    public String pojoContainPojoParam(User user){
        System.out.println("user: "+user);
        return "{'module':"+user +"'date param'}";
    }

    //数组传参
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes){
        System.out.println("user: "+ Arrays.toString(likes));
        System.out.println("user: "+ likes);
        return "{'module':"+likes +"'date param'}";
    }
    //集合参数
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes){
        System.out.println("user: "+ likes);
        return "{'module':"+likes +"'date param'}";
    }

    //json
    @RequestMapping("/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes){
        System.out.println("user: "+ likes);
        return "{'module':"+likes +"'date param'}";
    }

}
