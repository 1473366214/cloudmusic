package com.music.cloundmusic.dao;

import com.music.cloundmusic.entity.SongList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SongListMapper {
    public List<SongList> getSongList(@Param("userid")int userId);
    public int setSongList(SongList songList);
    public int updateSongList(SongList songList);
    public int deleteSongList(@Param("songlistid")int songListId);
}
