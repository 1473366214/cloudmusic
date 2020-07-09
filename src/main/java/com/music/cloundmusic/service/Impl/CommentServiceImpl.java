package com.music.cloundmusic.service.Impl;

import com.music.cloundmusic.dao.CommentMapper;
import com.music.cloundmusic.dto.UserComment;
import com.music.cloundmusic.entity.Comment;
import com.music.cloundmusic.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentMapper commentMapper;

    @Autowired
    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<UserComment> getComment(int keyid, String type, String types) {
        return commentMapper.getComment(String.valueOf(keyid),type,types);
    }

    @Override
    public int setComment(Comment comment) {
        return commentMapper.setComment(comment);
    }

    @Override
    public int addLikes(int commentId) {
        return commentMapper.addLikes(commentId);
    }
}
