package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.dao.UserInfoDAO;
import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.pojo.UserInfoDO;
import com.example.demo.pojo.UserInfoVO;
import com.example.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;



/**
 * @Author 11123357
 * @Date 2020/8/19 10:19
 * @Version 1.0
 */
@RestController   /*定义该Controller类是用来返回json数据的*/
@Slf4j
@CrossOrigin
@Component
@RequestMapping("/user")   //定义该接口统一的路由

public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @Resource
    UserInfoDAO userInfoDAO;
    UserInfoMapper userInfoMapper;

    /*@PostMapping 表示定义一个post接口*/
    @PostMapping(value = "/submit")
    public Result submitUserInfo(@RequestBody UserInfoVO userInfoVO) {  /*@RequestBody就是把前端传过来的json对象映射为UserInfoVO的java实体*/
        if (null == userInfoVO.getPassWord()) {
            userInfoVO.setPassWord("123456");
        }
        /* 将新增的用户信息插入数据库*/
        userInfoService.insertUserInfoService(userInfoVO);

        return Result.success();
    }

    //*从数据库分页查询*//
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<UserInfoVO> wrapper = Wrappers.<UserInfoVO>lambdaQuery().orderByAsc(UserInfoVO::getId); //通过用户昵称进行模糊搜索
        if (StrUtil.isNotBlank(search)) { //通过hutool工具类里的StrUtil直接判断search不为空
            wrapper.like(UserInfoVO::getNickName, search);  //从数据库查询的用户昵称=关键词search进行模糊查询
        }
        //new Page<>(pageNum, pageSize)表示分页对象， pageNum表示第几页，pageSize表示每一页的数据量
        Page<UserInfoVO> userPage = userInfoMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(userPage);
    }

/*
    @PutMapping("/getUserInfo")
    public List<UserInfoDO> getUserInfo(@RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                        @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<
                UserInfoDO> wrapper = Wrappers.<UserInfoDO>lambdaQuery().orderByAsc(UserInfoDO::getId); //通过用户昵称进行模糊搜索
        if (StrUtil.isNotBlank(search)) { //通过hutool工具类里的StrUtil直接判断search不为空
            wrapper.like(UserInfoDO::getNickName, search);  //从数据库查询的用户昵称=关键词search进行模糊查询
        }
        new Page<>(pageNum, pageSize); //分页对象， pageNum表示第几页，pageSize表示每一页的数据量
        userInfoMapper.findPage()
        List<UserInfoDO> queryUserInfoList = userInfoService.getUserInfoService();

        return queryUserInfoList;
    }*/
}
//@PostMapping是新增、@PutMapping是更新、@GetMapping是查询
