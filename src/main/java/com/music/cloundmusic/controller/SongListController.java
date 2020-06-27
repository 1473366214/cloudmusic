package com.music.cloundmusic.controller;

import com.music.cloundmusic.entity.Music;
import com.music.cloundmusic.entity.SongList;
import com.music.cloundmusic.entity.User;
import com.music.cloundmusic.entity.UserSongList;
import com.music.cloundmusic.service.SongListService;
import com.music.cloundmusic.service.UserSongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/songList")
public class SongListController {
    @Value("${default-music-cover}")
    private String defaultMusicCover;
    @Value("${relativePath}")
    private String relativePath;

    private SongListService songListService;
    private UserSongListService userSongListService;
    @Autowired
    public void setSongListService(SongListService songListService) {
        this.songListService = songListService;
    }
    @Autowired
    public void setUserSongListService(UserSongListService userSongListService) {
        this.userSongListService = userSongListService;
    }

    //查询用户歌单列表
    @RequestMapping(value = "/getUserSongList.do",method = RequestMethod.GET)
    public List<SongList> getUserSongList(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("userMsg");
        if(user==null)
            return null;
        @SuppressWarnings("unchecked")
        List<SongList> list = (List<SongList>)request.getSession().getAttribute("userSongList");
        if(list==null)
            list = songListService.getSongList(user.getUserid());
        if(list.isEmpty()){
            SongList songList = new SongList();
            songList.setCreatorid(user.getUserid());
            songList.setCover(defaultMusicCover);
            songList.setName("我喜欢的音乐");
            songList.setCreatetime(new Date(new java.util.Date().getTime()));
            if(songListService.setSongList(songList)==1){
                UserSongList userSongList = new UserSongList();
                userSongList.setUserid(user.getUserid());
                userSongList.setSonglistid(songList.getSonglistid());
                userSongList.setType("default");
                if(userSongListService.addUserSongList(userSongList)==1)
                    list.add(songList);
                else
                    return list;
            }else
                return list;
        }else {
            for(SongList songList : list){
                if(!songList.getCover().equals(defaultMusicCover)){
                    songList.setCover(relativePath+"musicCover/"+songList.getCover());
                }
            }
        }
        request.getSession().setAttribute("userSongList",list);
        return list;
    }
    //创建歌单
    @RequestMapping(value = "/setUserSongList.do",method = RequestMethod.POST)
    public SongList setUserSongList(@RequestParam("songListName") String name, HttpServletRequest request){
        SongList songList = new SongList();
        if(name==null||name.equals(""))
            return songList;
        User user = (User)request.getSession().getAttribute("userMsg");
        if(user==null)
            return songList;
        @SuppressWarnings("unchecked")
        List<SongList> list = (List<SongList>)request.getSession().getAttribute("userSongList");
        songList.setCreatorid(user.getUserid());
        songList.setName(name);
        songList.setCover(defaultMusicCover);
        songList.setCreatetime(new Date(new java.util.Date().getTime()));
        songList.setCollectiontimes(0);
        if(songListService.setSongList(songList)==1){
            UserSongList userSongList = new UserSongList(user.getUserid(),songList.getSonglistid(),"create");
            if(userSongListService.addUserSongList(userSongList)==1) {
                list.add(songList);
                request.getSession().setAttribute("userSongList", list);
                return songList;
            }
        }
        return new SongList();
    }
    //删除用户歌单
    @RequestMapping(value = "/deleteUserSongList.do",method = RequestMethod.DELETE)
    public int deleteUserSongList(int songListId,HttpServletRequest request){
        final int Error = 0;
        final int Success = 1;
        final int NullList = 2;
        final int DefaultList = 3;
        User user = (User)request.getSession().getAttribute("userMsg");
        if(user==null)
            return Error;
        @SuppressWarnings("unchecked")
        List<SongList> list = (List<SongList>)request.getSession().getAttribute("userSongList");
        if(list==null)
            return NullList;
        for(SongList songList : list){
            if(songList.getSonglistid()==songListId){
                String type = songList.getType();
                if(type.equals("default"))
                    return DefaultList;
                else if(type.equals("create")){
                    list.remove(songList);
                    if(songListService.deleteSongList(songListId)==1&&userSongListService.deleteUserSongList(new UserSongList(user.getUserid(),songListId,""))==1){
                        request.getSession().setAttribute("userSongList",list);
                        return Success;
                    }
                }else if(type.equals("collect")){
                    if(userSongListService.deleteUserSongList(new UserSongList(user.getUserid(),songListId,""))==1){
                        list.remove(songList);
                        request.getSession().setAttribute("userSongList",list);
                        return Success;
                    }
                }
                break;
            }
        }
        return Error;
    }
    //修改歌单信息
    @RequestMapping(value = "updateUserSongList.do",method = RequestMethod.PUT)
    public int updateUserSongList(SongList newSongList,HttpServletRequest request){
        final int Error = 0;
        final int Success = 1;
        final int NullList = 2;
        final int EmptyList = 3;
        boolean temp = false;
        Integer songListId = newSongList.getSonglistid();
        String name = newSongList.getName();
        String cover = newSongList.getCover();
        String introduction = newSongList.getIntroduction();
        @SuppressWarnings("unchecked")
        List<SongList> list = (List<SongList>)request.getSession().getAttribute("userSongList");
        if(list==null)
            return NullList;
        if(songListId==null||songListId.equals(0))
            return EmptyList;
        for(SongList songList :list){
            if(songList.getSonglistid().equals(songListId)){
                if(songList.getStyle().equals("default")||songList.getName().equals(name)||name.equals("")){
                    if(songList.getName().equals(name))
                        name = null;
                    newSongList.setName(null);
                }
                if(songList.getCover().equals(cover)){
                    cover = null;
                    newSongList.setCover(null);
                }
                if(songList.getIntroduction().equals(introduction)||introduction.equals("")){
                    if(introduction.equals(songList.getIntroduction()))
                        introduction = null;
                    newSongList.setIntroduction(null);
                }
                if(songListService.updateSongList(newSongList)==1){
                    if(name!=null)
                        songList.setName(name);
                    if(cover!=null)
                        songList.setCover(cover);
                    if(introduction!=null)
                        songList.setIntroduction(introduction);
                    temp = true;
                }
                break;
            }
        }
        if(temp)
            return Success;
        else
            return Error;
    }
}
