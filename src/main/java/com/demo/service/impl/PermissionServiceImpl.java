package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.PermissionsMapper;
import com.demo.pojo.Permissions;
import com.demo.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionsMapper permissionsMapper;
	
	@Override
	public List<Permissions> selectByRoleId(Integer roleId) {
		return permissionsMapper.selectByRoleId(roleId);
	}

}
