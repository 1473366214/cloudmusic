package com.music.cloundmusic.dao;

import com.music.cloundmusic.entity.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MusicMapper {
    public int addMusic(Music music);
    public List<Music> getAllMusic(@Param("location")String location, @Param("category")String category);
    public List<Music> getMusicInSongList(int songListId);
    public List<Music> getHotMusic();
    public Music getMusicById(int musicId);
    public List<Music> getMusicBySingerId(int singerId);
    public List<Music> getMusicByAlbumId(int albumId);
}
