package com.example.demo.service;

import com.example.demo.pojo.User;

/**
 * @Author: sunjin.sj
 * @Date: 14/12/18
 * @Description:
 */
public interface UserInfoService {

    int insertUserInfoService(User user);
    int updateUserInfoService(User user);
    int deleteInfoService(Long id);
}
