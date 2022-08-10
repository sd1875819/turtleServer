package com.example.demo.controller;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.example.demo.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/*文件上传类，在resources里新建files文件夹用于保存上传的文件*/
@RestController
@RequestMapping("files")
public class FileController {

    @Value("${server.port}")  //获取端口
    private String port;

    private static final String ip = "http://localhost"; //该处的ip先固定使用本地ip


    //上传文件的接口：
    @PostMapping("upload")
    public Result<?> upload(MultipartFile file) throws IOException {  /*MultipartFile file用于接收前台传过来的文件数据对象*/
        String originalFilename = file.getOriginalFilename();  //获取文件名称，需要思考怎么解决相同文件名重复的问题
        //定义文件的唯一标识，给上传的文件添加前缀，避免上传文件名重复时文件被覆盖的问题,IdUtil.fastSimpleUUID()可以生成一串不重复的字符串
        String flag = IdUtil.fastSimpleUUID();
        //首先通过System.getProperty("user.dir")获取Springboot这个工程的路径地址，再拼接上files文件夹的路径及文件的路径，即是文件存储的绝对路径，注意后面拼接的时候不需要再带工程名，前面已经获取到了
        String rootFilePath = System.getProperty("user.dir") + "/src/main/resources/files/" + flag+ "_" + originalFilename;
        FileUtil.writeBytes(file.getBytes(), rootFilePath);  //使用Hutool工具类提供的工具FileUtil进行IO数据流的读写，直接将传过来的文件以字节流的形式file.getBytes()写入文件夹
        return Result.success(ip + ":" + port + "/files/" + flag);  //上传成功后返回结果url：工程启动的ip+端口+路径+flag
    }

    //下载文件的接口,先把文件的唯一标识flag传过来进行查询该文件，所以该处是用@GetMapping查询注解，然后进行下载操作
    @GetMapping("/{flag}")
    public void getFiles(@PathVariable String flag, HttpServletResponse response) {  //通过response对象可以将文件通过流的方式写出，因为是通过流的方式返回，所以该方法不需要返回任何信息
        OutputStream os; //新建一个输出流对象
        String basePath = System.getProperty("user.dir") + "/src/main/resources/files/";  //获取文件上传后所在的根路径
        List<String> fileNames = FileUtil.listFileNames(basePath);//获取根路径下所有的文件名称
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse(""); //根据提供的文件的唯一标识flag，查询目标文件的名称
        try {
            if (StrUtil.isNotEmpty(fileName)) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + fileName);//下载文件，通过文件路径读取文件字节流
                os = response.getOutputStream(); //通过response响应，通过输出流返回文件到浏览器
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            System.out.println("文件下载失败！");
        }
    }
}
