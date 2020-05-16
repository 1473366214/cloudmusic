package com.music.cloundmusic.entity;

public class UserSongList {
    private Integer userid;
    private Integer songlistid;
    private String type;

    public UserSongList(){}

    public UserSongList(Integer userid, Integer songlistid, String type) {
        this.userid = userid;
        this.songlistid = songlistid;
        this.type = type;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSonglistid() {
        return songlistid;
    }

    public void setSonglistid(Integer songlistid) {
        this.songlistid = songlistid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
