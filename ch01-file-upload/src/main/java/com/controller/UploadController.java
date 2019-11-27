package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 专门处理文件上传的控制器
 */
@Controller
public class UploadController {

    @PostMapping("/upload")
    public String upload(MultipartFile myFile){
        String directory="E:\\aaa";
        String filename=myFile.getOriginalFilename();
        String path=directory+ File.separator+filename;
        File file = new File(path);
        try {
            myFile.transferTo(file);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

}
