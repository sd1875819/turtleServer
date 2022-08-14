package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author 11123357
 * @Date 2020/9/26 11:57
 * @Version 1.0
 */
@TableName("news")  //mybatis-plus插件将javabean中的驼峰直接映射成数据库字段的下划线
@Data
public class News {
    @TableId(type = IdType.AUTO) /*设置id为自动生成的自增id*/
    public Integer id;
    public String title;
    public String content;  //跟数据库里的decimal类型对应
    public String author;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") //设置时间格式
    public Date time;
}
