package com.music.cloundmusic.dao;

import com.music.cloundmusic.dto.UserComment;
import com.music.cloundmusic.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CommentMapper {
    public List<UserComment> getComment(@Param("keyid")String keyid, @Param("type") String type, @Param("types")String types);
    public int setComment(Comment comment);
    public int addLikes(int commentId);
    public int getCommentCount(@Param("keyid")String keyId,@Param("type")String type);
}
