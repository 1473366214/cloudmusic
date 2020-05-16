package com.music.cloundmusic.service.Impl;

import com.music.cloundmusic.dao.MusicCategoryMapper;
import com.music.cloundmusic.service.MusicCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicCategoryServiceImpl implements MusicCategoryService {
    private MusicCategoryMapper musicCategoryMapper;

    @Autowired
    public void setMusicCategoryMapper(MusicCategoryMapper musicCategoryMapper) {
        this.musicCategoryMapper = musicCategoryMapper;
    }

    @Override
    public List<String> getMusicCategory() {
        return musicCategoryMapper.getMusicCategory();
    }
}
