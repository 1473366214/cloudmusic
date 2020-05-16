package com.music.cloundmusic.dao;

import com.music.cloundmusic.entity.Singer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface SingerMapper {
    public Singer getSingerInfo(int singerId);
    public List<Singer> getSingerPage(String alphabet);
}
