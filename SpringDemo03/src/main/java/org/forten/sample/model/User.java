package org.forten.sample.model;

import org.forten.sample.util.StringUtil;

import java.util.Date;

/**
 * Created by Administrator on 2016/7/26.
 */
public class User {
    private int id;
    private String loginName;
    private String password;
    private String email;
    private int userLevel;
    private String status;
    private Date registTime;
    private Date lastLoginTime;
    private String valCode;

    public User() {
        this.userLevel=0;
        this.status="NA";
        Date now = new Date();
        this.registTime = now;
        this.lastLoginTime = now;
        this.valCode = StringUtil.getRandomLetterAndNumberStr(15);
    }

    public User(String loginName, String password, String email) {
        this();
        this.loginName = loginName;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getValCode() {
        return valCode;
    }

    public void setValCode(String valCode) {
        this.valCode = valCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userLevel=" + userLevel +
                ", status='" + status + '\'' +
                ", registTime=" + registTime +
                ", lastLoginTime=" + lastLoginTime +
                ", valCode='" + valCode + '\'' +
                '}';
    }
}
