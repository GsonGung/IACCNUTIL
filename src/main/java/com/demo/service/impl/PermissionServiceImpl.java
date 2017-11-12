package com.demo.service.impl;

import java.util.List;
import java.util.Map;

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
	public List<Map<String, String>> selectByRoleId(Integer roleId) {
		return permissionsMapper.selectByRoleId(roleId);
	}

	@Override
	public Permissions selectByPrimaryKey(Integer id) {
		return permissionsMapper.selectByPrimaryKey(id);
	}

}
