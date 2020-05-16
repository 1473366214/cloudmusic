package com.music.cloundmusic.entity;

import java.sql.Date;

public class Share {
    private Integer shareid;
    private Integer userid;
    private Integer musicid;
    private Integer songlistid;
    private String text;
    private Date createtime;

    public Integer getShareid() {
        return shareid;
    }

    public void setShareid(Integer shareid) {
        this.shareid = shareid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMusicid() {
        return musicid;
    }

    public void setMusicid(Integer musicid) {
        this.musicid = musicid;
    }

    public Integer getSonglistid() {
        return songlistid;
    }

    public void setSonglistid(Integer songlistid) {
        this.songlistid = songlistid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
