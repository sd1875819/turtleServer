package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.NewsMapper;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.News;
import com.example.demo.service.BookService;
import com.example.demo.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;


/**
 * @Author 11123357
 * @Date 2020/8/19 10:19
 * @Version 1.0
 */
@RestController
@Slf4j
@CrossOrigin
@Component
@RequestMapping("/news")

public class NewsController {

    @Resource
    NewsService newsService;

    @Resource
    NewsMapper newsMapper;

    @PostMapping(value = "/submit")
    public Result submitNews(@RequestBody News news) {

        news.setTime(new Date()); /*创建新的帖子时设置一下当前时间保存到数据库*/
        /* 将新增的用户信息插入数据库*/
        newsService.insertNewsService(news);

        return Result.success();
    }
    /*编辑更新行数据*/
    @PutMapping(value = "/update")
    public Result<?> update(@RequestBody News news) {
        /* 将编辑后的用户信息插入数据库*/
        newsService.updateNewsService(news);

        return Result.success();
    }
    /*删除数据*/
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        /* */
        newsService.deleteNewsService(id);

        return Result.success();
    }

    //*从数据库分页查询*//
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<News> wrapper = Wrappers.<News>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(News::getTitle, search);
        }
        //new Page<>(pageNum, pageSize)表示分页对象， pageNum表示第几页，pageSize表示每一页的数据量
        Page<News> newsPage = newsMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(newsPage);
    }
}
//@PostMapping是新增数据使用、@PutMapping是更新、@GetMapping是查询、@DeleteMapping 是删除
