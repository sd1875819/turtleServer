package com.example.demo.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author 11123357
 * @Date 2020/9/26 11:57
 * @Version 1.0
 */
@Data
public class UserInfoDO {
    String id;
    String userName;
    String nickName;
    String investTime;
    String email;
    String telPhone;
}
