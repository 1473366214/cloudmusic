package com.music.cloundmusic.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {
    @Value("${relativePath}")
    String relativePath;
    @Value("${absolutePath}")
    String absolutePath;
    //上传文件
    @ResponseBody
    @RequestMapping("/uploadFile.do")
    public String uploadUserCover(@RequestParam("file") MultipartFile file,@RequestParam("style") String style){
        String fileName = file.getOriginalFilename();
        String path = absolutePath+style+"\\";
        String fileStyle;
        if(fileName!=null&&fileName.contains("."))
            fileStyle = fileName.substring(fileName.lastIndexOf("."));
        else
            return null;
        if("userCover".equals(style)||"musicCover".equals(style)){
            fileName = UUID.randomUUID().toString().replaceAll("-","")+fileStyle;
        }else if("music".equals(style)){
            fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
        }
        File userCover = new File(path);
        if(!userCover.exists())
            if(!userCover.mkdirs())
                return null;
        path += fileName;
        FileOutputStream output;
        try{
            output = new FileOutputStream(path);
            output.write(file.getBytes());
            output.flush();
            output.close();
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return relativePath+style+"/"+fileName;
    }
}
