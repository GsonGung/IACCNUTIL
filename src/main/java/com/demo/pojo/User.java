package com.demo.pojo;

import java.io.Serializable;
import java.util.Date;
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
    
    private String isDelete;
    
    private String isValid;
    
    private Date createTime;
    
    private String createBy;
    
    private Date updateTime;
    
    private String uodateBy;
    
    public User() {}

    public User(int id, Long organizationId, String username, String realname, String password, String salt,
        String gender, String imgUrl, List<Long> roleIds, Boolean locked, String isDelete, String isValid,
        Date createTime, String createBy, Date updateTime, String uodateBy)
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
        this.isDelete = isDelete;
        this.isValid = isValid;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.uodateBy = uodateBy;
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
    
    public String getIsDelete()
    {
        return isDelete;
    }

    public void setIsDelete(String isDelete)
    {
        this.isDelete = isDelete;
    }

    public String getIsValid()
    {
        return isValid;
    }

    public void setIsValid(String isValid)
    {
        this.isValid = isValid;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getCreateBy()
    {
        return createBy;
    }

    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public String getUodateBy()
    {
        return uodateBy;
    }

    public void setUodateBy(String uodateBy)
    {
        this.uodateBy = uodateBy;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    @Override
    public String toString()
    {
        return "User [id=" + id + ", organizationId=" + organizationId + ", username=" + username + ", realname="
            + realname + ", password=" + password + ", salt=" + salt + ", gender=" + gender + ", imgUrl=" + imgUrl
            + ", roleIds=" + roleIds + ", locked=" + locked + ", isDelete=" + isDelete + ", isValid=" + isValid
            + ", createTime=" + createTime + ", createBy=" + createBy + ", updateTime=" + updateTime + ", uodateBy="
            + uodateBy + "]";
    }

}