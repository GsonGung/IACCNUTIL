/*
 * 文 件 名:  RoleServiceImpl.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  龚结铎/andrew
 * 修改时间:  2017年11月9日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.demo.dao.RolesMapper;
import com.demo.pojo.Roles;
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
@Service
public class RoleServiceImpl implements RoleService
{
    
    @Autowired
    private RolesMapper rolesMapper;
    
    /** {@inheritDoc} */
    @Override
    public JSONObject getRoleList()
    {
        List<Map<String, Object>> roles = rolesMapper.queryRoleList();
        
        JSONObject json  = new JSONObject();
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", roles.size());
        json.put("data", roles);
        
        return json;
    }

    @Override
    public int addRole(Roles role)
    {
        return rolesMapper.insertSelective(role);
    }
    
    @Override
    public int updateRole(Roles role)
    {
        return rolesMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public Roles findRole(Integer id)
    {
        return rolesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delRole(Integer id)
    {
        return rolesMapper.deleteByPrimaryKey(id);
    }

	@Override
	public int findPermissions(Integer roleId) {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
