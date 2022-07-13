package com.example.demo.service.impl;

import com.game.dao.UserInfoDAO;
import com.game.pojo.UserInfoDO;
import com.game.pojo.UserInfoVO;
import com.game.service.UserInfoService;
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
    public List<UserInfoDO> getUserInfoService() {
        List<UserInfoDO> getUserInfo = userInfoDAO.getUserInfoDAO();
        return getUserInfo;
    }

    @Override
    public int insertUserInfoService(UserInfoVO userInfoVO) {
        int insertResultCode = userInfoDAO.insertUserInfoDAO(userInfoVO);
        return insertResultCode;
    }
}
