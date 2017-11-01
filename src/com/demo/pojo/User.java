package com.demo.pojo;

public class User {
    private String openId;

    private String name;

    private String eid;

    private String photoUrl;

    private String phone;

    public User() {
    }

    public User(String openId, String name, String eid, String photoUrl, String phone) {
        this.openId = openId;
        this.name = name;
        this.eid = eid;
        this.photoUrl = photoUrl;
        this.phone = phone;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid == null ? null : eid.trim();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}