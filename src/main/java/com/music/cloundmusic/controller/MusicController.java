package com.music.cloundmusic.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.music.cloundmusic.entity.Music;
import com.music.cloundmusic.entity.PageInfoHelper;
import com.music.cloundmusic.entity.User;
import com.music.cloundmusic.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Value("${relativePath}")
    private String relativePath;
    private MusicService musicService;
    @Autowired
    public void setMusicService(MusicService musicService) {
        this.musicService = musicService;
    }

    //获得所有音乐
    @ResponseBody
    @RequestMapping(value = "/getAllMusic",method = RequestMethod.GET)
    public PageInfoHelper<Music> getAllMusic(int pageNum, int pageSize,
                                             @RequestParam(name = "location",required = false) String location,
                                             @RequestParam(name = "category",required = false)String category){
        PageHelper.startPage(pageNum,pageSize);
        List<Music> list=musicService.getAllMusic(location,category);
        for(Music music:list){
            music.setCover(relativePath+music.getCover());
        }
        PageInfo<Music> pageInfo=new PageInfo<>(list);
        return new PageInfoHelper<>(pageInfo);
    }

    //获得歌单中的歌曲
    @ResponseBody
    @RequestMapping(value = "/getMusicFormSongList.do",method = RequestMethod.GET)
    public List<Music> getMusicFormSongList(int songlistid, HttpServletRequest request){
        if(songlistid==0)
            return null;
        List<Music> list = musicService.getMusicInSongList(songlistid);
        for(Music music:list){
            music.setPath(relativePath+music.getPath());
            music.setCover(relativePath+music.getCover());
        }
        return list;
    }
    //热门音乐
    @ResponseBody
    @RequestMapping(value = "/getHotMusic",method = RequestMethod.GET)
    public List<Music> getHotMusic(HttpServletRequest request){
        @SuppressWarnings("unchecked")
        List<Music> list=(List<Music>)request.getSession().getAttribute("hotMusic");
        if(list==null){
            list=musicService.getHotMusic();
            request.getSession().setAttribute("hotMusic",list);
        }
        return list;
    }
    //歌曲播放
    @RequestMapping(value = "/musicPlay/{musicId}",method = RequestMethod.GET)
    public String musicPlay(@PathVariable(name = "musicId") int musicId, Model model,HttpServletRequest request){
        Music music=musicService.getMusicById(musicId);
        if(music!=null){
            music.setMusicid(musicId);
            music.setPath(relativePath+music.getPath());
            music.setCover(relativePath+music.getCover());
            model.addAttribute("music",music);
        }
        User user=(User)request.getSession().getAttribute("userMsg");
        if(user!=null){
            model.addAttribute("userMsg",user);
        }
        return "musicAudio";
    }
    //歌手的歌
    @ResponseBody
    @RequestMapping(value = "/getMusicBySingerId",method = RequestMethod.GET)
    public List<Music> getMusicBySingerId(int singerId){

        return musicService.getMusicBySingerId(singerId);
    }
}
