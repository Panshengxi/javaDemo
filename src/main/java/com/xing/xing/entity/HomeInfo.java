package com.xing.xing.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "homeinfo")
public class HomeInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "lotteryConfigList")
    @Autowired
    private String lotteryConfigList;

    @Column(name = "jzdgMatchList")
    private String jzdgMatchList;

    @Column(name = "bannerList")
    private String bannerList;

    @Column(name = "channel")
    private String channel;

    @Column(name = "platform")
    private String platform;


    public Long getId() {
        return id;
    }

    public String getJzdgMatchList() {
        return jzdgMatchList;
    }

    public void setJzdgMatchList(String jzdgMatchList) {
        this.jzdgMatchList = jzdgMatchList;
    }

    public String getLotteryConfigList() {
        return lotteryConfigList;
    }

    public void setLotteryConfigList(String lotteryConfigList) {
        this.lotteryConfigList = lotteryConfigList;
    }

    public void setBannerList(String bannerList) {
        this.bannerList = bannerList;
    }

    public String getBannerList() {
        return bannerList;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }
}

