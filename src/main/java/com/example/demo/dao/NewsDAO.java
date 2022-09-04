package com.example.demo.dao;


import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.NewsMapper;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.News;
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
public class NewsDAO {

    @Resource  /*@Resource该注解将mapper引入到使用类中*/
     NewsMapper newsMapper;
    /**
     * @desc 将用户数据插入数据库
     * @return
     */
    public int insertNewsDAO(News news) {
        return newsMapper.insert(news);
    }

    public int updateNewsDAO(News news) {
        return  newsMapper.updateById(news);
    }

    public int deleteNewsDAO(Long id) {
        return  newsMapper.deleteById(id);
    }
}
