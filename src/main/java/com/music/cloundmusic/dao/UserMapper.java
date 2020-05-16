package com.music.cloundmusic.dao;

import com.music.cloundmusic.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    public User getUser(@Param("accounts")String accounts,@Param("password")String password);
    public int userExist(String accounts);
    public int setUser(User user);
    public int updateMsg(User user);
    public int updateUserPassword(@Param("accounts")String accounts,@Param("oldPassword")String oldPassword,@Param("newPassword")String newPassword);
}
