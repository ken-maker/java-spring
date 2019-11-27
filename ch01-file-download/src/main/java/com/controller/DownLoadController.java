package com.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URLEncoder;

@Controller
public class DownLoadController {

    //提供给用户下载的文件路径
    public static String FILE_DIRECTORY="E:\\aaa";

    @RequestMapping("/download")
    public ResponseEntity<InputStreamSource> download(String fileName) throws Exception {

        String fullPath=FILE_DIRECTORY + File.separator + fileName;//拼接成完整路径
        File file = new File(fullPath);//创建出完整路径的对象

        //根据文件名猜测内容类型（图片、音频、视频等）
        String mediaType= URLConnection.guessContentTypeFromName(fileName);
        if(mediaType==null){//猜不出来就用它：application/octet-stream（下面常量的内容）
            mediaType= MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        System.out.println("mediaType = " + mediaType);//输出内容类型

        HttpHeaders respHeaders = new HttpHeaders();//创建一个响应对象的头部
        respHeaders.setContentType(MediaType.parseMediaType(mediaType));//设置内容类型，解析上面猜出来的内容类型进行设置
        //设置内容配置表单数据  attachment:附件
        respHeaders.setContentDispositionFormData("attachment", URLEncoder.encode(fileName,"UTF-8"));

        //创建一个输入流，里面有完整路径文件的文件流
        InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));

        //返回“响应实体” （内容流，响应头部，状态码）
        return new ResponseEntity<>(inputStreamResource,respHeaders, HttpStatus.OK);
    }

}
