package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.User;
import com.example.demo.service.BookService;
import com.example.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Author 11123357
 * @Date 2020/8/19 10:19
 * @Version 1.0
 */
@RestController
@Slf4j
@CrossOrigin
@Component
@RequestMapping("/book")

public class BookController {

    @Resource
    BookService bookService;

    @Resource
    BookMapper bookMapper;

    @PostMapping(value = "/submit")
    public Result submitBook(@RequestBody Book book) {

        /* 将新增的用户信息插入数据库*/
        bookService.insertBookService(book);

        return Result.success();
    }
    /*编辑更新行数据*/
    @PutMapping(value = "/update")
    public Result<?> update(@RequestBody Book book) {
        /* 将编辑后的用户信息插入数据库*/
        bookService.updateBookService(book);

        return Result.success();
    }
    /*删除数据*/
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        /* */
        bookService.deleteBookService(id);

        return Result.success();
    }

    /*通过id批量删除行*/
    @PostMapping("/deleteBatch")
    public Result<?> deleteBatch(@RequestBody List<Integer> ids) {
        bookMapper.deleteBatchIds(ids);

        return Result.success();
    }

    //*从数据库分页查询*//
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<Book> wrapper = Wrappers.<Book>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(Book::getName, search);
        }
        Page<Book> bookPage = bookMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(bookPage);
    }
}
//@PostMapping是新增数据使用、@PutMapping是更新、@GetMapping是查询、@DeleteMapping 是删除
