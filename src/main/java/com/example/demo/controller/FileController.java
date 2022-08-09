package com.example.demo.controller;


import cn.hutool.core.io.FileUtil;
import com.example.demo.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/*文件上传类，在resources里新建files文件夹用于保存上传的文件*/
@RestController
@RequestMapping("files")
public class FileController {

    @PostMapping("upload")
    public Result<?> upload(MultipartFile file) throws IOException {  /*MultipartFile file用于接收前台传过来的文件数据对象*/
        String originalFilename = file.getOriginalFilename();  //获取文件名称，需要思考怎么解决相同文件名重复的问题
        //首先通过System.getProperty("user.dir")获取Springboot这个工程的路径地址，再拼接上files文件夹的路径及文件的路径，即是文件存储的绝对路径，注意后面拼接的时候不需要再带工程名，前面已经获取到了
        String rootFilePath = System.getProperty("user.dir") + "/src/main/resources/files/" + originalFilename;
        FileUtil.writeBytes(file.getBytes(), rootFilePath);  //使用Hutool工具类提供的工具FileUtil进行IO数据流的读写，直接将传过来的文件以字节流的形式file.getBytes()写入文件夹
        return Result.success();
    }
}
