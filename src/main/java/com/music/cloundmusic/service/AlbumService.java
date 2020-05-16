package com.music.cloundmusic.service;

import com.music.cloundmusic.entity.Album;

import java.util.List;

public interface AlbumService {
    public List<Album> getRecommendAlbum();
    public List<Album> getAllAlbum();
    public Album getAlbumById(int albumId);
}
