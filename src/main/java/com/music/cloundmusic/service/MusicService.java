package com.music.cloundmusic.service;

import com.music.cloundmusic.entity.Music;
import com.music.cloundmusic.util.PageInfoHelper;

import java.util.List;

public interface MusicService {
    public int addMusic(Music music);
    public List<Music> getAllMusic(String location,String category);
    public List<Music> getMusicInSongList(int songListId);
    public List<Music> getHotMusic();
    public Music getMusicById(int musicId);
    public List<Music> getMusicBySingerId(int singerId);
    public List<Music> getMusicByAlbumId(int albumId);
    public PageInfoHelper<Music> searchMusic(int pageNum, int pageSize, String name);
}
