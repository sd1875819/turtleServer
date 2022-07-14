package com.example.demo.service.impl;

import com.example.demo.dao.UserInfoDAO;
import com.example.demo.pojo.UserInfoDO;
import com.example.demo.pojo.UserInfoVO;
import com.example.demo.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public int insertUserInfoService(UserInfoVO userInfoVO) {
        int insertResultCode = userInfoDAO.insertUserInfoDAO(userInfoVO);
        return insertResultCode;
    }
}
