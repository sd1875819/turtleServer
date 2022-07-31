package com.example.demo.service.impl;

import com.example.demo.dao.UserInfoDAO;
import com.example.demo.pojo.User;
import com.example.demo.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 11123357
 * @Date 2020/9/26 18:08
 * @Version 1.0
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDAO userInfoDAO;

    @Override
    public int insertUserInfoService(User user) {
        int insertResultCode = userInfoDAO.insertUserInfoDAO(user);
        return insertResultCode;
    }

    @Override
    public int updateUserInfoService(User user) {
        int updateResultCode = userInfoDAO.updateInfoDAO(user);
        return updateResultCode;
    }
}
