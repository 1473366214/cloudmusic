package com.music.cloundmusic.service;

import com.music.cloundmusic.entity.Singer;

import java.util.List;

public interface SingerService {
    public Singer getSingerInfo(int singerId);
    public List<Singer> getSingerPage(String alphabet);
}
