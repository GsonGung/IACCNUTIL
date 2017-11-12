package com.demo.dao;

import java.util.List;
import java.util.Map;

import com.demo.pojo.Permissions;

public interface PermissionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    Permissions selectByPrimaryKey(Integer id);
    
    List<Map<String, String>> selectByRoleId(Integer roleId);
    
    List<Map<String, String>> selectForAllRoles();

    int updateByPrimaryKeySelective(Permissions record);

    int updateByPrimaryKey(Permissions record);
}