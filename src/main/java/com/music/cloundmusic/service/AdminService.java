package com.music.cloundmusic.service;

import com.music.cloundmusic.entity.Admin;

public interface AdminService {
    public Admin getAdmin(Admin admin);
    public int setAdmin(Admin admin);
    public int updatePassword(Admin admin);
    public boolean adminExist(String accounts);
}
