package com.itheima.controller;

import cn.itcast.service.IpCountService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService iBookService;

    @Autowired
    private IpCountService ipCountService;

    @GetMapping
    public R getAll(){
        return new R(true,iBookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book){
        return new R(iBookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(iBookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(iBookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,iBookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        ipCountService.count();
        IPage<Book> page = iBookService.getPage(currentPage, pageSize, book);
        if (currentPage > page.getPages()){
            iBookService.getPage((int)page.getPages(),pageSize,book);
        }
        return new R(true,iBookService.getPage(currentPage, pageSize, book));
    }
}
