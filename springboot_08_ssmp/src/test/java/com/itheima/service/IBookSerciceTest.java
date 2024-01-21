package com.itheima.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import com.itheima.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IBookSerciceTest {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    IBookService bookService;

    @Test
    void testGetById() {
        System.out.println(bookService.getById(1));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("test");
        book.setName("test");
        book.setDescrption("test");
        bookService.save(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(2);
        book.setType("test2");
        book.setName("test2");
        book.setDescrption("test2");
        bookService.updateById(book);
    }

    @Test
    void testDelete() {
        bookService.removeById(2);
    }

    @Test
    void testGetAll() {
        System.out.println(bookService.list());
    }

    @Test
    void testGetPage() {
        //要想使用分页，先使用拦截器，先创建一个第一页分五跳数据的分页对象
        IPage<Book> bookPage = new Page<>(2, 5);
        bookService.page(bookPage);
        System.out.println(bookPage.getPages());
        System.out.println(bookPage.getCurrent());
        System.out.println(bookPage.getSize());
        System.out.println(bookPage.getTotal());
        System.out.println(bookPage.getRecords());
    }

    @Test
    void testGetBy() {
        //按条件查询
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        //name like '%a%'
        queryWrapper.like("name", "a");
        bookMapper.selectList(queryWrapper);
    }

//    @Test
//    void testGetBy2() {
////        //按条件查询
////        String name = null;
////        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
////        //condition为false，不连like
////        queryWrapper.like(name != null, Book::getName, "a");
////        bookMapper.selectList(queryWrapper);
//        System.out.println(bookService.getByName("a"));
//    }
}
