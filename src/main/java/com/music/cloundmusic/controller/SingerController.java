package com.music.cloundmusic.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.music.cloundmusic.entity.PageInfoSinger;
import com.music.cloundmusic.entity.Singer;
import com.music.cloundmusic.service.SingerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SingerController {
    @Value("${relativePath}")
    private String relativePath;
    private SingerService singerService;

    @Autowired
    public void setSingerService(SingerService singerService) {
        this.singerService = singerService;
    }
//歌手详细信息
    @RequestMapping(value = "/singer/{singerId}")
    public String getSingerInfo(@PathVariable("singerId")int singerId, Model model){
        Singer singer=singerService.getSingerInfo(singerId);
        singer.setCover(relativePath+singer.getCover());
        model.addAttribute("singerInfo",singer);
        return "singerInfo";
    }
    //歌手列表
    @ResponseBody
    @RequestMapping(value = "/getSingerPage",method = RequestMethod.GET)
    public PageInfoSinger getSingerPage(@RequestParam(defaultValue = "1",value = "pageNum",required = false) Integer pageNum,
                                        @RequestParam(defaultValue = "10",value = "pageSize",required = false) Integer pageSize,
                                        @RequestParam(value = "alphabet",required = false)String alphabet){
        PageHelper.startPage(pageNum,pageSize);
        List<Singer> list=singerService.getSingerPage(alphabet);
        for(Singer singer:list){
            singer.setCover(relativePath+singer.getCover());
        }
        return new PageInfoSinger(new PageInfo<>(list));
    }
}
