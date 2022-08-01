package com.example.demo.dao;


import com.example.demo.mapper.UserInfoMapper;
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
public class UserInfoDAO {

    @Resource  /*@Resource该注解将mapper引入到使用类中*/
    UserInfoMapper userInfoMapper;
    /**
     * @desc 将用户数据插入数据库
     * @return
     */
    public int insertUserInfoDAO(User user) {
        return userInfoMapper.insert(user);  //直接调用BaseMapper类中的insert方法将数据插入数据库，userInfoVO中的参数名与数据库表中的参数名一一对应即可
    }

    public int updateInfoDAO(User user) {
        return  userInfoMapper.updateById(user);
    }

    public int deleteInfoDAO(Long id) {
        return  userInfoMapper.deleteById(id);  /*调用BaseMapper类中的deleteById方法删除数据库对应id的行数据*/
    }
}
