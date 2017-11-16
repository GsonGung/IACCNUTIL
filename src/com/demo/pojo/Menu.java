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
    
    private int isMenu;
    
    private int allowExpand;
    
    private int isPublic;
    
    private String allowEdit;
    
    private String allowDelete;
    
    private int status;
    
    private int sortCode;
    
    private int deleteMark;
    
    private int enabledMark;
    
    private String description;
    
    private Date createDate;
    
    private String createUserId;
    
    private String createUserName;
    
    private Date modifyDate;
    
    private String modifyUserId;
    
    private String modifyUserName;
    
    public Menu()
    {
    }
    
    public Menu(int id, String moduleId, String parentId, String enCode, String fullName, String icon,
        String urlAddress, String target, int isMenu, int allowExpand, int isPublic, String allowEdit,
        String allowDelete, int status, int sortCode, int deleteMark, int enabledMark, String description,
        Date createDate, String createUserId, String createUserName, Date modifyDate, String modifyUserId,
        String modifyUserName)
    {
        this.id = id;
        this.moduleId = moduleId;
        this.parentId = parentId;
        this.enCode = enCode;
        this.fullName = fullName;
        this.icon = icon;
        this.urlAddress = urlAddress;
        this.target = target;
        this.isMenu = isMenu;
        this.allowExpand = allowExpand;
        this.isPublic = isPublic;
        this.allowEdit = allowEdit;
        this.allowDelete = allowDelete;
        this.status = status;
        this.sortCode = sortCode;
        this.deleteMark = deleteMark;
        this.enabledMark = enabledMark;
        this.description = description;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.modifyDate = modifyDate;
        this.modifyUserId = modifyUserId;
        this.modifyUserName = modifyUserName;
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
    
    public int getIsMenu()
    {
        return isMenu;
    }
    
    public void setIsMenu(int isMenu)
    {
        this.isMenu = isMenu;
    }
    
    public int getAllowExpand()
    {
        return allowExpand;
    }
    
    public void setAllowExpand(int allowExpand)
    {
        this.allowExpand = allowExpand;
    }
    
    public int getIsPublic()
    {
        return isPublic;
    }
    
    public void setIsPublic(int isPublic)
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
    
    public int getDeleteMark()
    {
        return deleteMark;
    }
    
    public void setDeleteMark(int deleteMark)
    {
        this.deleteMark = deleteMark;
    }
    
    public int getEnabledMark()
    {
        return enabledMark;
    }
    
    public void setEnabledMark(int enabledMark)
    {
        this.enabledMark = enabledMark;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public Date getCreateDate()
    {
        return createDate;
    }
    
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }
    
    public String getCreateUserId()
    {
        return createUserId;
    }
    
    public void setCreateUserId(String createUserId)
    {
        this.createUserId = createUserId;
    }
    
    public String getCreateUserName()
    {
        return createUserName;
    }
    
    public void setCreateUserName(String createUserName)
    {
        this.createUserName = createUserName;
    }
    
    public Date getModifyDate()
    {
        return modifyDate;
    }
    
    public void setModifyDate(Date modifyDate)
    {
        this.modifyDate = modifyDate;
    }
    
    public String getModifyUserId()
    {
        return modifyUserId;
    }
    
    public void setModifyUserId(String modifyUserId)
    {
        this.modifyUserId = modifyUserId;
    }
    
    public String getModifyUserName()
    {
        return modifyUserName;
    }
    
    public void setModifyUserName(String modifyUserName)
    {
        this.modifyUserName = modifyUserName;
    }
}