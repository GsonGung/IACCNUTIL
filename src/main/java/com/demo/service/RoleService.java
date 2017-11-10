/*
 * 文 件 名:  RoleService.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  龚结铎/andrew
 * 修改时间:  2017年11月9日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.demo.pojo.Roles;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  龚结铎/andrew
 * @version  [YOUFULI V300R001C01, 2017年11月9日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface RoleService
{
    JSONObject getRoleList();

    int addRole(Roles role);

    Roles findRole(Integer id);

    int updateRole(Roles role);

    int delRole(Integer id);

	int findPermissions(Integer roleId);
}
