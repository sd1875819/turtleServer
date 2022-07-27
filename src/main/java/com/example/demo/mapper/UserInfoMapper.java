package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.*;

/**
 * @Author 11123357
 * @Date 2020/9/26 13:58
 * @Version 1.0
 */
@Mapper
//BaseMapper中有各种操作数据库的方法，在需要操作数据库时直接调用即可，在javebean对象User类里直接指定要操作的表格名，并与表格里的字段一一对应即可
public interface UserInfoMapper extends BaseMapper<User> {

}
