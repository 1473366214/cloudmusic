package com.music.cloundmusic.dto;
/**
 *  用于歌歌手、专辑、音乐 信息
 */
public class SingerAlbum {
    /**
     * 歌手id
     */
    private Integer singerId;
    /**
     * 歌手名称
     */
    private String singerName;
    /**
     * 歌手介绍
     */
    private String singerIntroduction;
    /**
     * 歌手名称
     */
    private String singerMasterPiece;
    /**
     * 专辑id
     */
    private Integer albumId;
    /**
     * 专辑名称
     */
    private String albumName;
    /**
     * 音乐id
     */
    private Integer musicId;
    /**
     * 音乐名称
     */
    private String musicName;
    /**
     * 音乐存储路径
     */
    private String musicPath;

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicPath() {
        return musicPath;
    }

    public void setMusicPath(String musicPath) {
        this.musicPath = musicPath;
    }

    public String getSingerIntroduction() {
        return singerIntroduction;
    }

    public void setSingerIntroduction(String singerIntroduction) {
        this.singerIntroduction = singerIntroduction;
    }

    public String getSingerMasterPiece() {
        return singerMasterPiece;
    }

    public void setSingerMasterPiece(String singerMasterPiece) {
        this.singerMasterPiece = singerMasterPiece;
    }
}
