package com.music.cloundmusic.dao;

import com.music.cloundmusic.entity.UserSongList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserSongListMapper {
    public int addUserSongList(UserSongList userSongList);
    public int deleteUserSongList(UserSongList userSongList);
}
