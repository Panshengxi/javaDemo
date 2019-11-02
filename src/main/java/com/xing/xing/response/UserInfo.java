package com.xing.xing.response;

import com.xing.xing.entity.user.User;

public class UserInfo {
    private Long id;
    private String userName;
    private String mobile;
    private String isTodaySign;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String getName() {
        return userName;
    }

    public void setMobile(String sno) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setIsTodaySign(String isTodaySign) {
        this.isTodaySign = isTodaySign;
    }

    public String getIsTodaySign() {
        return isTodaySign;
    }

    public UserInfo setData(User user){
        UserInfo userInfo = new UserInfo();
        userInfo.setName(user.getUserName());
        userInfo.setMobile(user.getMobile());
        userInfo.setId(user.getId());
        userInfo.setIsTodaySign(user.getIsTodaySign());
        return userInfo;
    }
}
