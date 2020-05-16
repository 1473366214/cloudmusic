package com.music.cloundmusic.service.Impl;

import com.music.cloundmusic.dao.SingerMapper;
import com.music.cloundmusic.entity.Singer;
import com.music.cloundmusic.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {
    private SingerMapper singerMapper;
    @Autowired
    public void setSingerMapper(SingerMapper singerMapper) {
        this.singerMapper = singerMapper;
    }

    @Override
    public Singer getSingerInfo(int singerId) {
        return singerMapper.getSingerInfo(singerId);
    }

    @Override
    public List<Singer> getSingerPage(String alphabet) {
        return singerMapper.getSingerPage(alphabet);
    }
}
