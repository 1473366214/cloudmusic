package com.music.cloundmusic.dto;

import com.music.cloundmusic.entity.Comment;

public class UserComment extends Comment {
    private String usercover;
    private String username;

    public String getUsercover() {
        return usercover;
    }

    public void setUsercover(String usercover) {
        this.usercover = usercover;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
