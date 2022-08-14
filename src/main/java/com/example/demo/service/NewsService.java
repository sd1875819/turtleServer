package com.example.demo.service;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.News;

/**
 * @Author: sunjin.sj
 * @Date: 14/12/18
 * @Description:
 */
public interface NewsService {

    int insertNewsService(News news);
    int updateNewsService(News news);
    int deleteNewsService(Long id);
}
