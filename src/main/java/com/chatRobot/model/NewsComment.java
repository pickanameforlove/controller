package com.chatRobot.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class NewsComment {
    private int cid;
    private int id;
    private String userImg;
    private String userNickname;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    public int getCid() {
        return cid;
    }

    public int getId() {
        return id;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserImg() {
        return userImg;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public String getContent() {
        return content;
    }

    public Date getTime() {
        return time;
    }
}
