package com.demo.service;

import java.util.List;
import java.util.Map;

import com.demo.pojo.Permissions;

/**
 * 
 * @author Administrator
 *
 */
public interface PermissionService {
	
	List<Map<String, String>> selectByRoleId(Integer roleId);
	
	Permissions selectByPrimaryKey(Integer id);

}
