package com.music.cloundmusic.dao;

import com.music.cloundmusic.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CommentMapper {
    public List<Comment> getComment(@Param("keyid")String keyid,@Param("type") String type,@Param("types")String types);
    public int setComment(Comment comment);
    public int addLikes(int commentId);
}
