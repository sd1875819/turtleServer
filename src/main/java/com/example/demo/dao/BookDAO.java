package com.example.demo.dao;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.common.Result;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author 11123357
 * @Date 2020/8/19 10:21
 * @Version 1.0
 */
@Component
@Slf4j
public class BookDAO {

    @Resource  /*@Resource该注解将mapper引入到使用类中*/
    BookMapper bookMapper;
    /**
     * @desc 将用户数据插入数据库
     * @return
     */
    public int insertBookDAO(Book book) {
        return bookMapper.insert(book);
    }

    public int updateBookDAO(Book book) {
        return  bookMapper.updateById(book);
    }

    public int deleteBookDAO(Long id) {
        return  bookMapper.deleteById(id);
    }
}
