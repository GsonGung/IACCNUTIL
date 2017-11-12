package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.RolesPermissionsMapper;
import com.demo.pojo.RolesPermissions;
import com.demo.service.RolePermissionService;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
	
	@Autowired
	private RolesPermissionsMapper rolesPermissionsMapper;

	@Override
	public int delPermissionByRoleId(long roleId) {
		return rolesPermissionsMapper.deleteByRoleId(roleId);
	}

	@Override
	public int addPermission(RolesPermissions record) {
		return rolesPermissionsMapper.insertSelective(record);
	}

}
