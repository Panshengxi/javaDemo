package com.xing.xing.entity.user;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "ck")
    private String ck;

    @Column(name = "channel")
    private String channel;

    @Column(name = "isTodaySign")
    private String isTodaySign;

    @Column(name = "loginTime")
    private Long loginTime;

    public void setMobile(String sno) {
        this.mobile = sno;
    }

    public String getMobile() {
        return mobile;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setCk(String ck) {
        this.ck = ck;
    }
    public String getCk() {
        return ck;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
    public String getChannel() {
        return channel;
    }

    public void setIsTodaySign(String isTodaySign) {
        this.isTodaySign = isTodaySign;
    }

    public String getIsTodaySign() {
        return isTodaySign;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    @Override
    public String toString(){
        String str;
        str = "{'userName':'"+this.getUserName()+"','mobile':'"+this.getMobile()+"','ck':'"+this.getCk()+"'}";
        return str;
    }
}
