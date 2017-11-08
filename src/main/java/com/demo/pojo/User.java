package com.demo.pojo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

public class User implements Serializable {
    
    private static final long serialVersionUID = 5405017927166524992L;

    private int id;
    
    private Long organizationId; //所属公司

    private String username;

    private String realname;

    private String password;
    
    private String salt; //加密密码的盐

    private String gender;
    
    private String imgUrl;
    
    private List<Long> roleIds; //拥有的角色列表
    
    private Boolean locked = Boolean.FALSE;
    
    public User() {}
    
    public User(int id, Long organizationId, String username, String realname, String password, String salt,
        String gender, String imgUrl, List<Long> roleIds, Boolean locked)
    {
        super();
        this.id = id;
        this.organizationId = organizationId;
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.salt = salt;
        this.gender = gender;
        this.imgUrl = imgUrl;
        this.roleIds = roleIds;
        this.locked = locked;
    }



    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Long getOrganizationId()
    {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId)
    {
        this.organizationId = organizationId;
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

    public String getSalt()
    {
        return salt;
    }

    public void setSalt(String salt)
    {
        this.salt = salt;
    }
    
    public String getCredentialsSalt() {
        return username + salt;
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

    public List<Long> getRoleIds()
    {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds)
    {
        this.roleIds = roleIds;
    }
    
    public String getRoleIdsStr() {
        if(CollectionUtils.isEmpty(roleIds)) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for(Long roleId : roleIds) {
            s.append(roleId);
            s.append(",");
        }
        return s.toString();
    }

    public void setRoleIdsStr(String roleIdsStr) {
        if(StringUtils.isEmpty(roleIdsStr)) {
            return;
        }
        String[] roleIdStrs = roleIdsStr.split(",");
        for(String roleIdStr : roleIdStrs) {
            if(StringUtils.isEmpty(roleIdStr)) {
                continue;
            }
            getRoleIds().add(Long.valueOf(roleIdStr));
        }
    }

    public Boolean getLocked()
    {
        return locked;
    }

    public void setLocked(Boolean locked)
    {
        this.locked = locked;
    }

    @Override
    public String toString()
    {
        return "User [id=" + id + ", organizationId=" + organizationId + ", username=" + username + ", realname="
            + realname + ", password=" + password + ", salt=" + salt + ", gender=" + gender + ", imgUrl=" + imgUrl
            + ", roleIds=" + roleIds + ", locked=" + locked + "]";
    }

}