package com.music.cloundmusic.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.music.cloundmusic.dao.AlbumMapper;
import com.music.cloundmusic.dao.MusicMapper;
import com.music.cloundmusic.dao.SingerMapper;
import com.music.cloundmusic.dto.SingerAlbum;
import com.music.cloundmusic.entity.Album;
import com.music.cloundmusic.entity.Music;
import com.music.cloundmusic.entity.Singer;
import com.music.cloundmusic.util.PageInfoHelper;
import com.music.cloundmusic.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {
    private MusicMapper musicMapper;
    private SingerMapper singerMapper;
    private AlbumMapper albumMapper;
    @Autowired
    public void setMusicMapper(MusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }
    @Autowired
    public void setSingerMapper(SingerMapper singerMapper) {
        this.singerMapper = singerMapper;
    }
    @Autowired
    public void setAlbumMapper(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
    }

    @Override
    public int addMusic(Music music) {
        return musicMapper.addMusic(music);
    }

    @Override
    public List<Music> getAllMusic(String location,String category) {
        return musicMapper.getAllMusic(location,category);
    }

    @Override
    public List<Music> getMusicInSongList(int songListId) {
        return musicMapper.getMusicInSongList(songListId);
    }

    public List<Music> getHotMusic(){
        return musicMapper.getHotMusic();
    }

    public Music getMusicById(int musicId){
        return musicMapper.getMusicById(musicId);
    }

    @Override
    public List<SingerAlbum> getMusicBySingerId(int singerId) {
        return musicMapper.getMusicBySingerId(singerId);
    }

    @Override
    public List<Music> getMusicByAlbumId(int albumId) {
        return musicMapper.getMusicByAlbumId(albumId);
    }

    @Override
    public PageInfoHelper<Music> searchMusic(int pageNum, int pageSize, String name) {
        PageHelper.startPage(pageNum,pageSize);
        List<Music> list1=musicMapper.getMusicByMusicName("%"+name+"%");
        return new PageInfoHelper<>(new PageInfo<Music>(list1));
    }

    /**
     * 获取SingerAlbum
     * @return SingerAlbum
     */
    public SingerAlbum getSingerAlbum(Integer singerId,Integer albumId){
        SingerAlbum singerAlbum=new SingerAlbum();
        Singer singer=singerMapper.getSingerInfo(singerId);
        Album album=albumMapper.getAlbumById(albumId);
        singerAlbum.setAlbumId(albumId);
        singerAlbum.setSingerId(singerId);
        singerAlbum.setAlbumName(album.getName());
        singerAlbum.setSingerName(singer.getName());
        return singerAlbum;
    }
}
