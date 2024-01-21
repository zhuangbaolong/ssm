package com.itheima.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import com.itheima.mapper.BookMapper;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookMapperTests {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    BookService bookService;

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
        bookService.update(book);
    }

    @Test
    void testDelete() {
        bookService.delete(2);
    }

    @Test
    void testGetAll() {
        System.out.println(bookService.getAll());
    }

    @Test
    void testGetPage() {
        //要想使用分页，先使用拦截器，先创建一个第一页分五跳数据的分页对象
        IPage<Book> page = bookService.getPage(2, 5);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy() {
        //按条件查询
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        //name like '%a%'
        queryWrapper.like("name", "a");
        bookMapper.selectList(queryWrapper);
    }

    @Test
    void testGetBy2() {
//        //按条件查询
//        String name = null;
//        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
//        //condition为false，不连like
//        queryWrapper.like(name != null, Book::getName, "a");
//        bookMapper.selectList(queryWrapper);
        System.out.println(bookService.getByName("a"));
    }
}
