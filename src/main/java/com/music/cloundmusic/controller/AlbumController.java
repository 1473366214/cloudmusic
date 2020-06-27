package com.music.cloundmusic.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.music.cloundmusic.entity.Album;
import com.music.cloundmusic.entity.Music;
import com.music.cloundmusic.util.PageInfoHelper;
import com.music.cloundmusic.service.AlbumService;
import com.music.cloundmusic.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("album")
public class AlbumController {
    @Value("${relativePath}")
    private String relativePath;
    private AlbumService albumService;
    private MusicService musicService;
    @Autowired
    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }
    @Autowired
    public void setMusicService(MusicService musicService) {
        this.musicService = musicService;
    }

    //专辑信息页面
    @RequestMapping(value = "/albumInfo",method = RequestMethod.GET)
    public String albumInfo(int albumId, Model model){
        Album album=albumService.getAlbumById(albumId);
        album.setCover(relativePath+album.getCover());
        List<Music> list=musicService.getMusicByAlbumId(albumId);
        model.addAttribute("album",album);
        model.addAttribute("musicList",list);
        return "albumInfo";
    }
    //推荐专辑
    @ResponseBody
    @RequestMapping(value = "getRecommendAlbum",method = RequestMethod.GET)
    public List<Album> getRecommendAlbum(){
        List<Album> list=albumService.getRecommendAlbum();
        for(Album album:list){
            album.setCover(relativePath+album.getCover());
        }
        return list;
    }

    //所有专辑
    @ResponseBody
    @RequestMapping(value = "getAllAlbum",method = RequestMethod.GET)
    public PageInfoHelper<Album> getAllAlbum(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Album> list=albumService.getAllAlbum();
        for(Album album:list){
            album.setCover(relativePath+album.getCover());
        }
        PageInfo<Album> pageInfo=new PageInfo<>(list);
        return new PageInfoHelper<>(pageInfo);
    }
}
