package com.music.cloundmusic.controller;


import com.music.cloundmusic.entity.Admin;
import com.music.cloundmusic.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;
    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/login")
    public String admin(){
        return "adminLogin";
    }
    @ResponseBody
    @RequestMapping("/getAdmin.do")
    public Admin getAdmin(Admin admin, HttpServletRequest request){
        if(!admin.getAccounts().equals("")&&!admin.getPassword().equals("")){
            Admin newAdmin = adminService.getAdmin(admin);
            if(newAdmin!=null){
                request.getSession().setAttribute("admin",newAdmin);
                return newAdmin;
            }
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/setAdmin.do",method = RequestMethod.POST)
    public int setAdmin(Admin admin){
        if(!admin.getAccounts().equals("")&&!admin.getPassword().equals("")){
            if(!adminService.adminExist(admin.getAccounts())) {
                if(adminService.setAdmin(admin)==1)
                return 1;
            }
        }
        return 0;
    }

    @ResponseBody
    @RequestMapping("/updateAdminPassword.do")
    public int updateAdminPassword(Admin admin){
        if(admin.getAccounts()!=null&&!admin.getAccounts().equals("")){
            if(adminService.updatePassword(admin)==1)
                return 1;
        }
        return 0;
    }
}
