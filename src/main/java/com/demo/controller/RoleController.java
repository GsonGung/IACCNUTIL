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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
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
}
