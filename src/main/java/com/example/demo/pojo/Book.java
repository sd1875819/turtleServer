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
@TableName("book")
@Data
public class Book {
    @TableId(type = IdType.AUTO) /*设置id为自动生成的自增id*/
    public Integer id;
    public String name;
    public BigDecimal price;  //该字段设置成BigDecimal类型，跟数据库里的decimal类型对应
    public String author;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") //设置插入数据库的时间格式
    public Date createTime;
    public String cover;  //文件地址url,注意在数据库里存储url的参数的类型一定要设置大一些，varchar(45)不够，可设置成varchar(200)

}
