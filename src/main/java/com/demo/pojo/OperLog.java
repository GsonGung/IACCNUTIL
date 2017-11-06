package com.demo.pojo;

public class OperLog {
    private Integer id;

    private Byte type;

    private Byte state;

    private String content;

    private String remark;

    public OperLog() {
    }

    public OperLog(Byte state, Byte type, String content, String remark) {
        this.type = type;
        this.state = state;
        this.content = content;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}