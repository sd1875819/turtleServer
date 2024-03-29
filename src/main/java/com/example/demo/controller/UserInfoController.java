package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.dao.UserInfoDAO;
import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.pojo.User;
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

    //@Resource注解可用于bean的注入，即将要使用的类引入，如果对应的接口有两个实现类，则需要指定类名。
    // 该注解有name和type两个属性,如果name属性有值,则使用byName的自动注入策略,将值作为需要注入bean的名字,如果type有值,则使用byType自动注入策略,将值作为需要注入bean的类型
    @Resource
    UserInfoService userInfoService;

    @Resource
    UserInfoMapper userInfoMapper;

    /*@PostMapping 表示定义一个post接口*/
    @PostMapping(value = "/submit")
    public Result submitUserInfo(@RequestBody User user) {  /*@RequestBody就是把前端传过来的json对象映射为UserInfoVO的java实体*/
        if (null == user.getPassword()) {
            user.setPassword("123456");
        }
        /* 将新增的用户信息插入数据库*/
        userInfoService.insertUserInfoService(user);

        return Result.success();
    }

    //*从数据库分页查询*//
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,  //传给后台的分页查询参数，避免前端不传这几个参数，所以需要设置默认值
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery(); //通过用户昵称进行模糊搜索
        if (StrUtil.isNotBlank(search)) { //通过hutool工具类里的StrUtil直接判断search不为空
            wrapper.like(User::getNickName, search);  //User::表示User.getxxx,可以直接访问User的属性，判断数据库查询的昵称是否等于search，进行模糊查询
        }
        //new Page<>(pageNum, pageSize)表示分页对象， pageNum表示第几页，pageSize表示每一页的数据量
        Page<User> userPage = userInfoMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);  //selectPage是mybitasplus提供的分页查询方法
        return Result.success(userPage);
    }
}
//@PostMapping是新增数据使用、@PutMapping是更新、@GetMapping是查询
