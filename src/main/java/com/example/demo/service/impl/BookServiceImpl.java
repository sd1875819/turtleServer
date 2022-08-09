package com.example.demo.service.impl;

import com.example.demo.common.Result;
import com.example.demo.dao.BookDAO;
import com.example.demo.dao.UserInfoDAO;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.User;
import com.example.demo.service.BookService;
import com.example.demo.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 11123357
 * @Date 2020/9/26 18:08
 * @Version 1.0
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Resource
    private BookDAO bookDAO;

    @Override
    public int insertBookService(Book book) {
        int insertResultCode = bookDAO.insertBookDAO(book);
        return insertResultCode;
    }

    @Override
    public int updateBookService(Book book) {
        int updateResultCode = bookDAO.updateBookDAO(book);
        return updateResultCode;
    }

    @Override
    public int deleteBookService(Long id) {
        int deleteResultCode = bookDAO.deleteBookDAO(id);
        return deleteResultCode;
    }
}
