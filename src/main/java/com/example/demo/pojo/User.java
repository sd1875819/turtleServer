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
@TableName("user_info")  //mybatis-plus插件将javabean中的驼峰直接映射成数据库字段的下划线
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
    public Integer role;
}
