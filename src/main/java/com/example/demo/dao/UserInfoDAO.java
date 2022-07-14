package com.example.demo.dao;


import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.pojo.UserInfoDO;
import com.example.demo.pojo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

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
    public int insertUserInfoDAO(UserInfoVO userInfoVO) {
        return userInfoMapper.insert(userInfoVO);  //直接调用BaseMapper类中的insert方法将数据插入数据库，userInfoVO中的参数名与数据库表中的参数名一一对应即可
    }
}
