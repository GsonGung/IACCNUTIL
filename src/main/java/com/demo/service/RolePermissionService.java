package com.demo.service;

import com.demo.pojo.RolesPermissions;

public interface RolePermissionService {
	
	public int delPermissionByRoleId(long roleId);
	
	public int addPermission(RolesPermissions record);

}
