package com.example.demo.service;

import com.example.demo.common.Result;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.User;

/**
 * @Author: sunjin.sj
 * @Date: 14/12/18
 * @Description:
 */
public interface BookService {

    int insertBookService(Book book);
    int updateBookService(Book book);
    int deleteBookService(Long id);
}
