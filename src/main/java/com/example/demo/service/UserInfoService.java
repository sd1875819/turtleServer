package com.example.demo.service;

import com.example.demo.pojo.UserInfoDO;
import com.example.demo.pojo.UserInfoVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: sunjin.sj
 * @Date: 14/12/18
 * @Description:
 */
public interface UserInfoService {

    int insertUserInfoService(UserInfoVO userInfoVO);
}
