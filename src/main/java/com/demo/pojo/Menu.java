/*
 * 文 件 名:  Menu.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月10日 下午1:39:05
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <菜单实体类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年8月27日 下午1:45:27]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Menu implements Serializable
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 菜单编号
     */
    private int id;
    
    private String moduleId;
    
    private String parentId;
    
    private String enCode;
    
    private String fullName;
    
    private String icon;
    
    private String urlAddress;
    
    private String target;
    
    private String type;
    
    private String allowExpand;
    
    private String isPublic;
    
    private String allowEdit;
    
    private String allowDelete;
    
    private int status;
    
    private int sortCode;
    
    private String isDelete;
    
    private String available;
    
    private String description;
    
    private String deleteReason;
    
    private String permissionName;
    
    private Date createTime;
    
    private String createBy;
    
    private Date updateTime;
    
    private String updateBy;
    
    public Menu()
    {
    }

    public Menu(int id, String moduleId, String parentId, String enCode, String fullName, String icon,
        String urlAddress, String target, String type, String allowExpand, String isPublic, String allowEdit,
        String allowDelete, int status, int sortCode, String isDelete, String available, String description,
        String deleteReason, String permissionName, Date createTime, String createBy, Date updateTime, String updateBy)
    {
        super();
        this.id = id;
        this.moduleId = moduleId;
        this.parentId = parentId;
        this.enCode = enCode;
        this.fullName = fullName;
        this.icon = icon;
        this.urlAddress = urlAddress;
        this.target = target;
        this.type = type;
        this.allowExpand = allowExpand;
        this.isPublic = isPublic;
        this.allowEdit = allowEdit;
        this.allowDelete = allowDelete;
        this.status = status;
        this.sortCode = sortCode;
        this.isDelete = isDelete;
        this.available = available;
        this.description = description;
        this.deleteReason = deleteReason;
        this.permissionName = permissionName;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getModuleId()
    {
        return moduleId;
    }

    public void setModuleId(String moduleId)
    {
        this.moduleId = moduleId;
    }

    public String getParentId()
    {
        return parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    public String getEnCode()
    {
        return enCode;
    }

    public void setEnCode(String enCode)
    {
        this.enCode = enCode;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getUrlAddress()
    {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress)
    {
        this.urlAddress = urlAddress;
    }

    public String getTarget()
    {
        return target;
    }

    public void setTarget(String target)
    {
        this.target = target;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getAllowExpand()
    {
        return allowExpand;
    }

    public void setAllowExpand(String allowExpand)
    {
        this.allowExpand = allowExpand;
    }

    public String getIsPublic()
    {
        return isPublic;
    }

    public void setIsPublic(String isPublic)
    {
        this.isPublic = isPublic;
    }

    public String getAllowEdit()
    {
        return allowEdit;
    }

    public void setAllowEdit(String allowEdit)
    {
        this.allowEdit = allowEdit;
    }

    public String getAllowDelete()
    {
        return allowDelete;
    }

    public void setAllowDelete(String allowDelete)
    {
        this.allowDelete = allowDelete;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public int getSortCode()
    {
        return sortCode;
    }

    public void setSortCode(int sortCode)
    {
        this.sortCode = sortCode;
    }

    public String getIsDelete()
    {
        return isDelete;
    }

    public void setIsDelete(String isDelete)
    {
        this.isDelete = isDelete;
    }

    public String getAvailable()
    {
        return available;
    }

    public void setAvailable(String available)
    {
        this.available = available;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDeleteReason()
    {
        return deleteReason;
    }

    public void setDeleteReason(String deleteReason)
    {
        this.deleteReason = deleteReason;
    }

    public String getPermissionName()
    {
        return permissionName;
    }

    public void setPermissionName(String permissionName)
    {
        this.permissionName = permissionName;
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

    public String getUpdateBy()
    {
        return updateBy;
    }

    public void setUpdateBy(String updateBy)
    {
        this.updateBy = updateBy;
    }

    @Override
    public String toString()
    {
        return "Menu [id=" + id + ", moduleId=" + moduleId + ", parentId=" + parentId + ", enCode=" + enCode
            + ", fullName=" + fullName + ", icon=" + icon + ", urlAddress=" + urlAddress + ", target=" + target
            + ", type=" + type + ", allowExpand=" + allowExpand + ", isPublic=" + isPublic + ", allowEdit=" + allowEdit
            + ", allowDelete=" + allowDelete + ", status=" + status + ", sortCode=" + sortCode + ", isDelete="
            + isDelete + ", available=" + available + ", description=" + description + ", deleteReason=" + deleteReason
            + ", permissionName=" + permissionName + ", createTime=" + createTime + ", createBy=" + createBy + ", updateTime="
            + updateTime + ", updateBy=" + updateBy + "]";
    }
}