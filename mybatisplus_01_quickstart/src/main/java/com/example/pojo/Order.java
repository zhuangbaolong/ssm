package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

@Data
//@TableName("tbl_user") 对应数据库名
public class Order {
    @TableId(type = IdType.AUTO)
    //AUTO数据自增策略/NONE不设置/INPUT用户手动输入id/ASSIGN_ID雪花算法生成id/ASSIGN_UUID以UUID生成算法作为id生成策略
    private Long id;
//    private String name;
//    //映射数据库字段名,select=false设置字段不参与查询
//    @TableField(value = "pwd",select = false)
//    private String password;
//    private Integer age;
//    private String tel;
    private Date time;
    //数据库不存在的字段,类里使用的
//    @TableField(exist = false)
//    private Integer online;
    //逻辑删除字段,默认为0
//    @TableLogic(value = "0",delval = "1")
//    private Integer deleted;

}
