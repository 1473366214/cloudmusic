package com.music.cloundmusic.dao;

import com.music.cloundmusic.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminMapper {
    public Admin getAdmin(Admin admin);
    public int setAdmin(Admin admin);
    public int updatePassword(Admin admin);
    public int adminExist(String accounts);
}
