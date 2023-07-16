package com.example.pojo.query;

import com.example.pojo.User;
import lombok.Data;

//封装User模型的查询条件
@Data
public class UserQuery extends User {
    //年龄的上限
    private Integer age2;
}
