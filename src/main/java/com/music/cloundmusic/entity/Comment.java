package com.music.cloundmusic.entity;

import java.sql.Date;

public class Comment {
    private Integer commentid;
    private Integer userid;
    private Integer keyid;
    private String type;
    private String text;
    private Integer likes;
    private Date createtime;
    private User user;

    public Comment(){};

    public Comment(Integer userid, Integer keyid, String type, String text, Date createtime) {
        this.userid = userid;
        this.keyid = keyid;
        this.type = type;
        this.text = text;
        this.createtime = createtime;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getKeyid() {
        return keyid;
    }

    public void setKeyid(Integer keyid) {
        this.keyid = keyid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
