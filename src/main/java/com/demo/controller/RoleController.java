/*
 * 文 件 名:  RoleController.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  龚结铎/andrew
 * 修改时间:  2017年11月9日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.pojo.Roles;
import com.demo.pojo.User;
import com.demo.service.RoleService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  龚结铎/andrew
 * @version  [YOUFULI V300R001C01, 2017年11月9日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("role")
public class RoleController
{
    @Autowired
    private RoleService roleService;
    
    /**
     * 
     * <getRoleList>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("getRoleList")
    @ResponseBody
    public Object getRoleList()
    {
        return roleService.getRoleList();
    }
    
    /**
     * 
     * <detail>
     * <功能详细描述>
     * @param role
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("detail")
    public String detail(HttpSession session, Model model, Integer id, String type)
    {
        if(id == null) {
            model.addAttribute("type", type);
            return "/pages/role/detail";
        }
        
        Roles role = roleService.findRole(id);
        model.addAttribute("role", role);
        model.addAttribute("type", type);
        return "/pages/role/detail";
    }
    
    /**
     * 
     * <addRole>
     * <功能详细描述>
     * @param role
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("addRole")
    @ResponseBody
    public Object addRole(HttpSession session, Roles role)
    {
        try {
            System.out.println("添加角色信息："+role);
            User user = (User)session.getAttribute("user");
            role.setCreateBy(user.getRealname());
            role.setCreateTime(new Date());
            return roleService.addRole(role);
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * 
     * <editRole>
     * <功能详细描述>
     * @param role
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("editRole")
    @ResponseBody
    public Object editRole(HttpSession session, Roles role)
    {
        try {
            System.out.println("修改角色信息："+role);
            User user = (User)session.getAttribute("user");
            role.setUpdateBy(user.getRealname());
            role.setUpdateTime(new Date());
            return roleService.updateRole(role);
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * 
     * <queryRole>
     * <功能详细描述>
     * @param role
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryRole")
    @ResponseBody
    public Object queryRole(Integer id)
    {
        try {
            return roleService.findRole(id);
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * 
     * <delRole>
     * <功能详细描述>
     * @param role
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("delRole")
    @ResponseBody
    public Object delRole(Integer id)
    {
        try {
            return roleService.delRole(id);
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * 
     * <delRoles>
     * <功能详细描述>
     * @param role
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("delRoles")
    @ResponseBody
    public Object delRoles(String ids)
    {
        try {
            String[] split = ids.split(",");
            int rows = 0;
            for(String id : split) {
                roleService.delRole(Integer.parseInt(id));
                rows++;
            }
            return rows;
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
