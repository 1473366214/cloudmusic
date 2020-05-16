package com.music.cloundmusic.dao;

import com.music.cloundmusic.entity.Album;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AlbumMapper {
    public List<Album> getRecommendAlbum();
    public List<Album> getAllAlbum();
    public Album getAlbumById(int albumId);
}
