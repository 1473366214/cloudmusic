package com.music.cloundmusic.service.Impl;

import com.music.cloundmusic.dao.AdminMapper;
import com.music.cloundmusic.entity.Admin;
import com.music.cloundmusic.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminMapper adminMapper;
    @Autowired
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public Admin getAdmin(Admin admin){
        return adminMapper.getAdmin(admin);
    }

    public int setAdmin(Admin admin){
        return adminMapper.setAdmin(admin);
    }

    public int updatePassword(Admin admin){
        return adminMapper.updatePassword(admin);
    }

    public boolean adminExist(String accounts){
        return (adminMapper.adminExist(accounts)==1)?true:false;
    }
}
