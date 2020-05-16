package com.music.cloundmusic.controller;

import com.music.cloundmusic.entity.User;
import com.music.cloundmusic.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    @Value("${default-user-cover}")
    String defaultUserCover;
    @Value("${default-username}")
    String defaultUserName;
    @Value("${relativePath}")
    String relativePath;

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //登录
    @RequestMapping("/userLogin.do")
    public int userLogin(@Param("accounts")String accounts, @Param("password")String password, HttpServletRequest request){
        User user=null;
        user = userService.getUser(accounts,password);
        if(user!=null) {
            user.setAccounts(accounts);
            user.setCover(relativePath+user.getCover());
            request.getSession().setAttribute("userMsg", user);
            return 1;
        }
        return 0;
    }
    //注册
    @RequestMapping("/userRegister.do")
    public int userRegister(@RequestParam("accounts") String accounts,@RequestParam("password") String password){
        if(userService.userExist(accounts))
            return -1;
        User user = new User();
        user.setAccounts(accounts);
        user.setPassword(password);
        user.setCover(defaultUserCover);
        user.setName(defaultUserName);
        user.setRegisttime(new Date(new java.util.Date().getTime()));
        if(userService.setUser(user)==1){
            return 1;
        }
        return 0;
    }
    //修改信息
    @RequestMapping(value = "/updateUserMsg.do",method = RequestMethod.PUT)
    public User updateUserMsg(User newUser,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("userMsg");
        String name = newUser.getName();
        String cover = newUser.getCover();
        String introduction = newUser.getIntroduction();
        String sex = newUser.getSex();
        Integer age = newUser.getAge();
        String address = newUser.getAddress();
        try{
            if(name.equals("")||name.equals(user.getName())){
                if(name.equals(user.getName()))
                    name=null;
                newUser.setName(null);
            }
            if(cover.equals(user.getCover())){
                cover=null;
                newUser.setCover(null);
            }
            if(introduction.equals("")||introduction.equals(user.getIntroduction())){
                if(introduction.equals(user.getIntroduction()))
                    introduction=null;
                newUser.setIntroduction(null);
            }
            if(sex.equals("")||sex.equals(user.getSex())){
                if(sex.equals(user.getSex()))
                    sex=null;
                newUser.setSex(null);
            }
            if(address.equals("")||address.equals(user.getAddress())){
                if(address.equals(user.getAddress()))
                    address=null;
                newUser.setAddress(null);
            }
            if(age.equals(0)||age.equals(user.getAge())){
                if(age.equals(user.getAge()))
                    age=null;
                newUser.setAge(null);
            }
        }catch (Exception e){
            return null;
        }
        newUser.setUserid(user.getUserid());
        if(cover!=null){
            newUser.setCover(cover.substring(cover.lastIndexOf("/")+1));
        }
        if(userService.updateMsg(newUser)==1){
            if(name!=null)
                user.setName(name);
            if(cover!=null)
                user.setCover(cover);
            if(introduction!=null)
                user.setIntroduction(introduction);
            if(age!=null)
                user.setAge(age);
            if(sex!=null)
                user.setSex(sex);
            if(address!=null)
                user.setAddress(address);
            request.getSession().setAttribute("userMsg",user);
            return user;
        }
        return null;
    }
    //修改密码
    @RequestMapping(value = "/updateUserPassword.do",method = RequestMethod.PUT)
    public int updateUserPassword(String accounts,String oldPassword,String newPassword,HttpServletRequest request){
        final int Success = 0;
        final int NullPoint = 1;
        final int AccountsError = 2;
        final int PasswordEquals = 3;
        final int PasswordError = 4;
        User user = (User)request.getSession().getAttribute("userMsg");
        if("".equals(accounts)||"".equals(newPassword)||"".equals(oldPassword))
            return NullPoint;
        else if(!accounts.equals(user.getAccounts())){
            return AccountsError;
        }else if(newPassword.equals(oldPassword)){
            return PasswordEquals;
        }else if(userService.updateUserPassword(accounts,oldPassword,newPassword)==1){
            return Success;
        }else {
            return PasswordError;
        }
    }
    //获取登录信息
    @RequestMapping(value = "/getUserMsg.do",method = RequestMethod.GET)
    public User getUserMsg(HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("userMsg");
        return user;
    }
    //登出
    @RequestMapping(value = "/userLogout.do",method = RequestMethod.PUT)
    public int userLogout(HttpServletRequest request){
        request.getSession().setAttribute("userMsg",null);
        request.getSession().setAttribute("userSongList",null);
        return 1;
    }
}
