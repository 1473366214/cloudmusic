package com.music.cloundmusic.entity;

public class Admin {
    private Integer adminid;
    private String accounts;
    private String password;

    public Admin(){}
    public Admin(String accounts, String password) {
        this.accounts = accounts;
        this.password = password;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }
}
