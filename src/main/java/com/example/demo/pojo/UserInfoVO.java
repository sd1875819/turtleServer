package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author 11123357
 * @Date 2020/9/26 11:57
 * @Version 1.0
 */
@Data
@Getter
@Setter
public class UserInfoVO {
    @TableId(type = IdType.AUTO) /*设置id为自动生成的自增id*/
    public Integer id;
    public String username;
    public String nickName;
    public String passWord;
    public Integer age;
    public String sex;
    public String address;
}
