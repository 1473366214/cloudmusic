package com.music.cloundmusic.service.Impl;

import com.music.cloundmusic.dao.MusicLocationMapper;
import com.music.cloundmusic.service.MusicLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicLocationServiceImpl implements MusicLocationService {
    private MusicLocationMapper musicLocationMapper;

    @Autowired
    public void setMusicLocationMapper(MusicLocationMapper musicLocationMapper) {
        this.musicLocationMapper = musicLocationMapper;
    }

    @Override
    public List<String> getMusicLocation() {
        return musicLocationMapper.getMusicLocation();
    }
}
