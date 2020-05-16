package com.music.cloundmusic.service;

import com.music.cloundmusic.entity.SongList;

import java.util.List;

public interface SongListService {
    public List<SongList> getSongList(int userId);
    public int setSongList(SongList songList);
    public int updateSongList(SongList songList);
    public int deleteSongList(int songListId);
}
