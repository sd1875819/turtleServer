package com.example.demo.service;

import com.game.pojo.UserInfoDO;
import com.game.pojo.UserInfoVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: sunjin.sj
 * @Date: 14/12/18
 * @Description:
 */
public interface UserInfoService {

    List<UserInfoDO> getUserInfoService();

    int insertUserInfoService(UserInfoVO userInfoVO);
}
