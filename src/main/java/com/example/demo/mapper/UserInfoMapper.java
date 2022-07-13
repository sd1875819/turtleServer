package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.game.pojo.UserInfoDO;
import com.game.pojo.UserInfoVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author 11123357
 * @Date 2020/9/26 13:58
 * @Version 1.0
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoVO> {
    //添加新的消息任务：
//    String INSERT_STATEMENT = "INSERT INTO game-userinfo (nick_name, user_name, invest_time, email, tel_phone)" +
//            " VALUES(#{nickName}, #{userName}, #{investTime}, #{email}, #{telPhone})";
    @Insert({"INSERT INTO user_info(user_name,nick_name,invest_time,email,tel_phone)" +
            " VALUES(#{userName},#{nickName},#{investTime},#{email},#{telPhone})"})
    @Options(useGeneratedKeys = true)
    int insertUserInfoMapper(UserInfoVO userInfoVO);

    //获取当前用户名下的消息列表
    String QUERY_MYTASKS = "SELECT * FROM `turtleDB`.`user_info`;";
    @Select(QUERY_MYTASKS)
    @Options(useGeneratedKeys = true)
    @Results(id = "userInfo", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "nickName", column = "nick_name"),
            @Result(property = "investTime", column = "invest_time"),
            @Result(property = "email", column = "email"),
            @Result(property = "telPhone", column = "tel_phone"),
    })
    List<UserInfoDO> getUserInfoListMapper();


    // 一对多查询
    Page<UserInfoDO> findPage(Page<UserInfoDO> page, @Param("nickName") String nickName);

}
