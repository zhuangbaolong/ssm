package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.Dao.OrderDao;
import com.example.Dao.UserDao;
import com.example.pojo.Order;
import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {


    @Autowired
    private UserDao userDao;

    @Autowired
    private OrderDao orderDao;

    @Test
    void testGetUserAll() {
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }

    //条件查询
    @Test
    void testGetUser() {
        //特殊第一种
//        QueryWrapper qw = new QueryWrapper<>();
//        //查询小于13的
//        qw.lt("age",13);
//        List<User> list = userDao.selectList(qw);
//        System.out.println(list);
        //第二种
//        QueryWrapper<User> qw2 = new QueryWrapper();
//        qw2.lambda().lt(User::getAge, 13);
//        List<User> userList = userDao.selectList(qw2);
//        System.out.println(userList);

//        //主要第三种
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper();
//        //and 关系
////        lqw.lt(User::getAge, 13).gt(User::getAge, 10);
//        //or 关系
//        lqw.lt(User::getAge, 12).or().gt(User::getAge,13);
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);

//        UserQuery uq = new UserQuery();
//        uq.setAge2(12);
//        //null判定
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper();
//        //链式或者ifelse的null判定
//        lqw.lt(null!=uq.getAge2(),User::getAge,uq.getAge2())
//                .gt(null!=uq.getAge(),User::getAge,uq.getAge());
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);

        //条件查询
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper();
        //=匹配
//        lqw.eq(User::getName,"tom").eq(User::getPassword,"123");
        //范围查询lt< le<= gt> ge>= eq= between
        lqw.between(User::getAge,10,13);
        //模糊匹配 like %
//        lqw.like(User::getName,"t");//%t%
        lqw.likeLeft(User::getName,"m");//%m
//        lqw.likeRight(User::getName,"t");//t%
//        User user = userDao.selectOne(lqw);
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
    }

    //投影，查部分
    @Test
    void testGetUserCount(){
        //查询投影
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper();
//        lqw.select(User::getId,User::getName,User::getAge);
        //2
//        QueryWrapper<User> qw = new QueryWrapper<User>();
//        qw.select("id","name","age");
//        List<User> userList = userDao.selectList(qw);
//        System.out.println(userList);
        //只有qw格式
        QueryWrapper<User> qw = new QueryWrapper<User>();
        qw.select("count(*) as count","tel");
        qw.groupBy("tel");
        List<Map<String, Object>> mapList = userDao.selectMaps(qw);
        System.out.println(mapList);
    }

    @Test
    void testGetUserById() {
        User user = userDao.selectById(1L);
        System.out.println(user);
    }

    @Test
    void testSave() {
        User user = new User();
//        user.setId(2L);
        user.setName("Japanese");
        user.setPassword("123");
        user.setAge(12);
        user.setTel("12345678912");
        userDao.insert(user);
    }

    @Test
    void testBatch() {
//        userDao.deleteById(1679770615974711297L);
        //批量删除
        ArrayList<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        userDao.deleteBatchIds(list);
        //可批量查询
//        userDao.selectBatchIds();
    }
    @Test
    void testDelete() {
        userDao.deleteById(1L);
        System.out.println(userDao.selectList(null));
    }

    @Test
    void testUpdate() {
//        User user = new User();
//        user.setId(1L);
//        user.setName("Tom666");
//        user.setPassword("1111");
//        userDao.updateById(user);

        //模拟乐观锁：a用户
        User user = userDao.selectById(3L); //拿到version=3
        //模拟b用户
        User user2 = userDao.selectById(3L); //拿到version=3
        user.setName("aaa");
        userDao.updateById(user);
        user2.setName("bbb");
        userDao.updateById(user2);
    }

    //分页查询
    @Test
    void testGetByPage() {
        //查第一页2条数据
        IPage iPage = new Page(2, 2);
        userDao.selectPage(iPage, null);
        //当前页码值
        System.out.println("当前页码值:" + iPage.getCurrent());
        System.out.println("每页显示数:" + iPage.getSize());
        System.out.println("一共多少页:" + iPage.getPages());
        System.out.println("一共多少条:" + iPage.getTotal());
        System.out.println("数据:" + iPage.getRecords());
    }

    @Test
    void testTime(){
        Order order = new Order();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(simpleDateFormat.format(date));
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(simpleDateFormat.format(calendar.getTime()));
//        System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
        System.out.println(System.currentTimeMillis());
        order.setTime(date);
        orderDao.insert(order);
    }
}
