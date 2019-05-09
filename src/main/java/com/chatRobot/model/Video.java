package com.chatRobot.model;

public class Video {
    private int vid;
    private String imgUrl;
    private String videoUrl;

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getDescri() {
        return descri;
    }

    private String descri;
}
