package com.music.cloundmusic.service;

import com.music.cloundmusic.entity.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> getComment(int keyid,String type,String types);
    public int setComment(Comment comment);
    public int addLikes(int commentId);
}
