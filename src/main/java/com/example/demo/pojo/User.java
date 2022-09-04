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
//通过@TableName 中可直接指定该javaBean中的字段与数据库中哪个表格映射关联。
//mybatis-plus插件可以将javabean中字段的驼峰直接映射成数据库字段的下划线
@TableName("user_info")
@Data
public class User {
    @TableId(type = IdType.AUTO) /*该处可设置id为自动生成的自增id，注意在创建数据库表格字段时，也要把id设置成自增类型*/
    public Integer id;
    public String username;
    public String nickName;
    public String password;
    public Integer age;
    public String sex;
    public String address;
    public Integer role;
}
