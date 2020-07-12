package com.music.cloundmusic.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.music.cloundmusic.dto.SingerAlbum;
import com.music.cloundmusic.entity.Music;
import com.music.cloundmusic.service.MusicService;
import com.music.cloundmusic.util.PageInfoSinger;
import com.music.cloundmusic.entity.Singer;
import com.music.cloundmusic.service.SingerService;
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
    private MusicService musicService;

    @Autowired
    public void setSingerService(SingerService singerService) {
        this.singerService = singerService;
    }
    @Autowired
    public void setMusicService(MusicService musicService) {
        this.musicService = musicService;
    }

    //歌手详细信息
    @RequestMapping(value = "/singer/{singerId}")
    public String getSingerInfo(@PathVariable("singerId")int singerId, Model model){
        //歌手信息
        Singer singer=singerService.getSingerInfo(singerId);
        singer.setCover(relativePath+singer.getCover());
        model.addAttribute("singerInfo",singer);
        List<SingerAlbum> list=musicService.getMusicBySingerId(singerId);
        for(SingerAlbum singerAlbum : list){
            singerAlbum.setMusicPath(relativePath+singerAlbum.getMusicPath());
        }
        model.addAttribute("musicList",list);
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
        PageInfo<Singer> pageInfo=new PageInfo<>(list);
        return new PageInfoSinger(pageInfo);
    }
}
