package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 11123357
 * @Date 2020/9/26 13:58
 * @Version 1.0
 */
@Mapper
//从UserInfoMapper类copy过来
public interface BookMapper extends BaseMapper<Book> {

}
