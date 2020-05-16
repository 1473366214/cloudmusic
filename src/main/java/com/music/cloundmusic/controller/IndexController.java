package com.music.cloundmusic.controller;

import com.music.cloundmusic.entity.Music;
import com.music.cloundmusic.service.MusicCategoryService;
import com.music.cloundmusic.service.MusicLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    private static String[] paths={"index","home","music","singer","album"};

    private MusicCategoryService musicCategoryService;
    private MusicLocationService musicLocationService;

    @Autowired
    public void setMusicCategoryService(MusicCategoryService musicCategoryService) {
        this.musicCategoryService = musicCategoryService;
    }

    @Autowired
    public void setMusicLocationService(MusicLocationService musicLocationService) {
        this.musicLocationService = musicLocationService;
    }

    @RequestMapping(value = "/index/{path}")
    public String getIndexWithPath(@PathVariable("path") String path,Model model){
        if("login".equals(path)){
            model.addAttribute("indexPath","/login");
            return "index2";
        }
        boolean flag=false;
        for(String s:paths){
            if(s.equals(path))
                flag=true;
        }
        if(flag)
            path="/index_"+path;
        else
            path="/index_"+paths[0];
        model.addAttribute("indexPath",path);
        return "index2";
    }

    @RequestMapping(value = "/index")
    public String getIndexWithOutPath(Model model){
        String path="/index_"+paths[0];
        model.addAttribute("indexPath",path);
        return "index2";
    }

    //index_music页面
    @RequestMapping("/index_music")
    public String indexMusicPage(Model model){
        List<String> categoryList=musicCategoryService.getMusicCategory();
        List<String> locationList=musicLocationService.getMusicLocation();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("locationList",locationList);
        return "index_music";
    }
}
