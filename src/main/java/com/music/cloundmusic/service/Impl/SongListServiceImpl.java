package com.music.cloundmusic.service.Impl;

import com.music.cloundmusic.dao.SongListMapper;
import com.music.cloundmusic.entity.SongList;
import com.music.cloundmusic.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongListServiceImpl implements SongListService {

    private SongListMapper songListMapper;
    @Autowired
    public void setSongListMapper(SongListMapper songListMapper) {
        this.songListMapper = songListMapper;
    }

    @Override
    public List<SongList> getSongList(int userId) {
        return songListMapper.getSongList(userId);
    }

    @Override
    public int setSongList(SongList songList) {
        return songListMapper.setSongList(songList);
    }

    @Override
    public int updateSongList(SongList songList) {
        return songListMapper.updateSongList(songList);
    }

    @Override
    public int deleteSongList(int songListId) {
        return songListMapper.deleteSongList(songListId);
    }
}
