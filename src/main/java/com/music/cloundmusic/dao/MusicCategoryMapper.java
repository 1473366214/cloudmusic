package com.music.cloundmusic.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MusicCategoryMapper {
    public List<String> getMusicCategory();
}
