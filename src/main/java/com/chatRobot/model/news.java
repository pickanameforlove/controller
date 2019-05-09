package com.chatRobot.model;

import java.util.Date;

public class news {
    private int id;
    private String title;
    private String author;
    private String imgUrl;
    private String source;
    private String tag;
    private Date date;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getSource() {
        return source;
    }

    public String getTag() {
        return tag;
    }

    public Date getDate() {
        return date;
    }

    public String getDigest() {
        return digest;
    }

    public String getContent() {
        return content;
    }

    private String digest;
    private String content;
}

