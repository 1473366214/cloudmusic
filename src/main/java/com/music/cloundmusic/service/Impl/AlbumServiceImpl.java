package com.music.cloundmusic.service.Impl;

import com.music.cloundmusic.dao.AlbumMapper;
import com.music.cloundmusic.entity.Album;
import com.music.cloundmusic.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    private AlbumMapper albumMapper;

    @Autowired
    public void setAlbumMapper(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
    }

    @Override
    public List<Album> getRecommendAlbum() {
        return albumMapper.getRecommendAlbum();
    }

    @Override
    public List<Album> getAllAlbum() {
        return albumMapper.getAllAlbum();
    }

    @Override
    public Album getAlbumById(int albumId) {
        return albumMapper.getAlbumById(albumId);
    }
}
