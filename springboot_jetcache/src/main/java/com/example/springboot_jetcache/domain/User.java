package com.example.springboot_jetcache.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
//Serializable序列化
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    //AUTO数据自增策略/NONE不设置/INPUT用户手动输入id/ASSIGN_ID雪花算法生成id/ASSIGN_UUID以UUID生成算法作为id生成策略
    private Long id;
    private String name;
    //映射数据库字段名,select=false设置字段不参与查询
//    @TableField(value = "pwd",select = false)
    private String pwd;
    private Integer age;
    private String tel;
    //数据库不存在的字段,类里使用的
//    @TableField(exist = false)
//    private Integer online;
    //逻辑删除字段,默认为0
//    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

//    @Version
    private Integer version;
}
