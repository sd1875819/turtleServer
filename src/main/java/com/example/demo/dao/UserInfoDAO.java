package com.example.demo.dao;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.common.Result;
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

    public Result<?> queryInfoDAO(User user) {
        /*用户名和密码是唯一的，可以用BaseMapper里的selectOne方法查询用户登陆的账号和密码是否存在
        * lambdaQuery()使用时需要指定类型，两个eq分别查询从数据库查询与前台传过来的用户名和密码均是唯一匹配的用户*/
        User res = userInfoMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()).eq(User::getPassword, user.getPassword()));
        if (null == res) {
            return Result.error("-1", "用户名或密码错误");
        }
        log.info(res.getUsername());
        return Result.success();  /*查询用户存在，返回的code就是0*/
    }

    public Result<?> registerInfoDAO(User user) {
        /*新增用户前，先要判断用户名是否存在，所以该处只用一个eq去校验用户名是否唯一*/
        User res = userInfoMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
        if (null != res) { /*结果不等于null，表示用户名重复*/
            return Result.error("-1", "用户名重复");
        }
        userInfoMapper.insert(user);  //如果用户名唯一性校验通过，则直接执行新增方法里的插入新用户的操作逻辑即可

        return Result.success();
    }
}
