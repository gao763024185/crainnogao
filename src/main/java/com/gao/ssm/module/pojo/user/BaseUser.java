package com.gao.ssm.module.pojo.user;

import java.util.Date;

public class BaseUser {

    private Integer uid;

    private String userName;

    private String password;

    private Date loginTime;

    private Date created;

    private String avatar;

    private String avatarthumbnail;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarthumbnail() {
        return avatarthumbnail;
    }

    public void setAvatarthumbnail(String avatarthumbnail) {
        this.avatarthumbnail = avatarthumbnail;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}