package com.example.demo.service.impl;

import com.example.demo.dao.BookDAO;
import com.example.demo.dao.NewsDAO;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.News;
import com.example.demo.service.BookService;
import com.example.demo.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 11123357
 * @Date 2020/9/26 18:08
 * @Version 1.0
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsDAO newsDAO;

    @Override
    public int insertNewsService(News news) {
        int insertResultCode = newsDAO.insertNewsDAO(news);
        return insertResultCode;
    }

    @Override
    public int updateNewsService(News news) {
        int updateResultCode = newsDAO.updateNewsDAO(news);
        return updateResultCode;
    }

    @Override
    public int deleteNewsService(Long id) {
        int deleteResultCode = newsDAO.deleteNewsDAO(id);
        return deleteResultCode;
    }
}
