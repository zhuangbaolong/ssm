package com.example.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;

@Data
//@TableName("tbl_user") 对应数据库名
public class User {
    @TableId(type = IdType.AUTO)
    //AUTO数据自增策略/NONE不设置/INPUT用户手动输入id/ASSIGN_ID雪花算法生成id/ASSIGN_UUID以UUID生成算法作为id生成策略
    private Long id;
    private String name;
    //映射数据库字段名,select=false设置字段不参与查询
    @TableField(value = "pwd",select = false)
    private String password;
    private Integer age;
    private String tel;
    //数据库不存在的字段,类里使用的
    @TableField(exist = false)
    private Integer online;
    //逻辑删除字段,默认为0
//    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    private Integer version;
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", password='" + password + '\'' +
//                ", age=" + age +
//                ", tel='" + tel + '\'' +
//                '}';
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public String getTel() {
//        return tel;
//    }
//
//    public void setTel(String tel) {
//        this.tel = tel;
//    }
}
