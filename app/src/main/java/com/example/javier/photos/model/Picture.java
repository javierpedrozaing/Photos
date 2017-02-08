package com.example.javier.photos.model;

/**
 * Created by javier on 1/31/17.
 */

public class Picture {
    private String picture;
    private String username;
    private String time;
    private String likeNumberCard = "0";

    public Picture(String picture, String username, String time, String likeNumberCard) {
        this.picture = picture;
        this.username = username;
        this.time = time;
        this.likeNumberCard = likeNumberCard;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLikeNumberCard() {
        return likeNumberCard;
    }

    public void setLikeNumberCard(String likeNumberCard) {
        this.likeNumberCard = likeNumberCard;
    }
}
