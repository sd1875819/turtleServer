package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author 11123357
 * @Date 2020/9/26 11:57
 * @Version 1.0
 */
@TableName("user_info")  //使用mybatis-plus插件时，该处需要添加与数据库表格名称进行关联
@Data
public class User {
    @TableId(type = IdType.AUTO) /*设置id为自动生成的自增id*/
    public Integer id;
    public String username;
    public String nickName;
    public String password;
    public Integer age;
    public String sex;
    public String address;
}
