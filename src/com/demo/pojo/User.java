package com.demo.pojo;

import java.io.Serializable;

public class User implements Serializable {
    
    private static final long serialVersionUID = 5405017927166524992L;

    private int id;

    private String username;

    private String realname;

    private String password;

    private String gender;
    
    private String imgUrl;
    
    public User() {}

    public User(int id, String username, String realname, String password, String gender, String imgUrl)
    {
        super();
        this.id = id;
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.gender = gender;
        this.imgUrl = imgUrl;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getRealname()
    {
        return realname;
    }

    public void setRealname(String realname)
    {
        this.realname = realname;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

}