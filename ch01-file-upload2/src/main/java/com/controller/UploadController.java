package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * 专门处理文件上传请求
 */
@Controller
public class UploadController {
    //我要传到的目录（也可以上传到云服务）
    public static final String FILE_DIRECTORY="E:\\aaa";

    @PostMapping("/upload")
    public String upload(MultipartFile myFile){
        //得到上传过来的文件名，一般要改名（例如：UUID）
        String originalFilename = myFile.getOriginalFilename();//获取原文件名
        //组成路径
        String path=FILE_DIRECTORY + File.separator+originalFilename;
        //弄成文件对象
        File file = new File(path);
        try {
            myFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }


}
