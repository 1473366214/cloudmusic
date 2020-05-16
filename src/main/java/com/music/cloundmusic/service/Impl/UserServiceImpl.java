package com.music.cloundmusic.service.Impl;

import com.music.cloundmusic.dao.UserMapper;
import com.music.cloundmusic.entity.User;
import com.music.cloundmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public User getUser(String accounts,String password) {
        return userMapper.getUser(accounts,password);
    }

    @Override
    public boolean userExist(String accounts) {
        return (userMapper.userExist(accounts)==1)?true:false;
    }

    @Override
    public int setUser(User user) {
        return userMapper.setUser(user);
    }

    @Override
    public int updateMsg(User user) {
        return userMapper.updateMsg(user);
    }

    @Override
    public int updateUserPassword(String accounts, String oldPassword,String newPassword) {
        return userMapper.updateUserPassword(accounts, oldPassword,newPassword);
    }
}
