package com.music.cloundmusic.service;

import com.music.cloundmusic.entity.User;

public interface UserService {
    public User getUser(String accounts,String password);
    public boolean userExist(String accounts);
    public int setUser(User user);
    public int updateMsg(User user);
    public int updateUserPassword(String accounts,String oldPassword,String newPassword);
}
