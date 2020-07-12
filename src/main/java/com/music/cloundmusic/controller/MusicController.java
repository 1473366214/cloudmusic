package com.music.cloundmusic.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.music.cloundmusic.dto.SingerAlbum;
import com.music.cloundmusic.dto.UserComment;
import com.music.cloundmusic.entity.Comment;
import com.music.cloundmusic.entity.Music;
import com.music.cloundmusic.entity.Singer;
import com.music.cloundmusic.service.CommentService;
import com.music.cloundmusic.util.ApplicationHelper;
import com.music.cloundmusic.util.PageInfoHelper;
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
    private ApplicationHelper applicationHelper;
    private CommentService commentService;
    private MusicService musicService;
    @Autowired
    public void setMusicService(MusicService musicService) {
        this.musicService = musicService;
    }
    @Autowired
    public void setApplicationHelper(ApplicationHelper applicationHelper) {
        this.applicationHelper = applicationHelper;
    }
    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
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
            music.setCover(applicationHelper.getRelativePath()+music.getCover());
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
            music.setPath(applicationHelper.getRelativePath()+music.getPath());
            music.setCover(applicationHelper.getRelativePath()+music.getCover());
        }
        String s=applicationHelper.getRelativePath();
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
            music.setPath(applicationHelper.getRelativePath()+music.getPath());
            music.setCover(applicationHelper.getRelativePath()+music.getCover());
            model.addAttribute("music",music);
        }
        User user=(User)request.getSession().getAttribute("userMsg");
        if(user==null) {
            user=new User();
            user.setCover(applicationHelper.getDefaultUserCover());
        }
        model.addAttribute("userMsg",user);
        //热门评论
        List<UserComment> list=commentService.getComment(musicId,"music","likes");
        if(list.size()>0){
            for(int i=0,length=list.size();i<length;i++){
                UserComment userComment=list.get(i);
                if(userComment.getLikes()==0){
                    list.remove(userComment);
                    i--;
                    length--;
                    continue;
                }
                userComment.setUsercover(applicationHelper.getRelativePath()+userComment.getUsercover());
            }
        }
        model.addAttribute("commentHotList",list);
        //最新评论
        list=commentService.getComment(musicId,"music","createtime");
        if(list.size()>0){
            for(UserComment c:list){
                c.setUsercover(applicationHelper.getRelativePath()+c.getUsercover());
            }
        }
        model.addAttribute("commentNewList",list);
        //评论数
        model.addAttribute("commentCount",commentService.getCommentCount(musicId,"music"));
        SingerAlbum singerAlbum=null;
        assert music != null;
        if(music.getSingerid()!=null&&music.getAlbumid()!=null)
            singerAlbum=musicService.getSingerAlbum(music.getSingerid(),music.getAlbumid());
        model.addAttribute("singerAlbumInfo",singerAlbum);
        return "musicAudio";
    }
    //歌手的歌
    @ResponseBody
    @RequestMapping(value = "/getMusicBySingerId",method = RequestMethod.GET)
    public List<SingerAlbum> getMusicBySingerId(int singerId){

        return musicService.getMusicBySingerId(singerId);
    }
    //搜索音乐
    @RequestMapping(value = "/searchMusic",method = RequestMethod.GET)
    public String searchMusic(@RequestParam(name = "pageNum",defaultValue = "1",required = false)Integer pageNum,
                              @RequestParam(name = "pageSize",defaultValue = "10",required = false)int pageSize,
                              String key,Model model){
        PageInfoHelper<Music> pageInfoHelper =musicService.searchMusic(pageNum,pageSize,key);
        for(Music m:pageInfoHelper.getList()){
            m.setCover(applicationHelper.getRelativePath()+m.getCover());
        }
        model.addAttribute("musicList",pageInfoHelper);
        model.addAttribute("key",key);
        return "searchPage";
    }
    //
    @ResponseBody
    @RequestMapping(value = "/searchMusicPage",method = RequestMethod.GET)
    public PageInfoHelper<Music> searchMusicPage(int pageNum,int pageSize,String key){
        PageInfoHelper<Music> pageInfoHelper =musicService.searchMusic(pageNum,pageSize,key);
        for(Music m:pageInfoHelper.getList()){
            m.setCover(applicationHelper.getRelativePath()+m.getCover());
        }
        return pageInfoHelper;
    }
}
