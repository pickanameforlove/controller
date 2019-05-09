package com.chatRobot.model;

public class Jixing {
    private int id;
    private String imgUrl;
    private String descri;
    private String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDescri() {
        return descri;
    }

    public String getPrice() {
        return price;
    }
}
