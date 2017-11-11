package com.demo.service;

import java.util.List;

import com.demo.pojo.Permissions;

/**
 * 
 * @author Administrator
 *
 */
public interface PermissionService {
	
	List<Permissions> selectByRoleId(Integer roleId);

}
