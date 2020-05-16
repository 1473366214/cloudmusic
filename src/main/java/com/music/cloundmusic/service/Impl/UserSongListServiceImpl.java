package com.music.cloundmusic.service.Impl;

import com.music.cloundmusic.dao.UserSongListMapper;
import com.music.cloundmusic.entity.UserSongList;
import com.music.cloundmusic.service.UserSongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSongListServiceImpl implements UserSongListService {
    private UserSongListMapper userSongListMapper;
    @Autowired
    public void setUserSongListMapper(UserSongListMapper userSongListMapper) {
        this.userSongListMapper = userSongListMapper;
    }

    @Override
    public int addUserSongList(UserSongList userSongList) {
        return userSongListMapper.addUserSongList(userSongList);
    }

    @Override
    public int deleteUserSongList(UserSongList userSongList) {
        return userSongListMapper.deleteUserSongList(userSongList);
    }
}
