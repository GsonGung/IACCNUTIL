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

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.demo.exception.BizHandlerException;
import com.demo.pojo.Permissions;
import com.demo.pojo.Roles;
import com.demo.pojo.RolesPermissions;
import com.demo.pojo.User;
import com.demo.service.PermissionService;
import com.demo.service.RolePermissionService;
import com.demo.service.RoleService;
import com.demo.utils.StringUtil;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author 龚结铎/andrew
 * @version [YOUFULI V300R001C01, 2017年11月9日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RolePermissionService rolePermissionService;
	
	@Autowired
	private PermissionService permissionService;

	/**
	 * 
	 * <getRoleList> <功能详细描述>
	 * 
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping("getRoleList")
	@ResponseBody
	public Object getRoleList() {
		return roleService.getRoleList();
	}

	/**
	 * 
	 * <detail> <功能详细描述>
	 * 
	 * @param role
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping("detail")
	public String detail(HttpSession session, Model model, Integer id, String type) {
		if (id == null) {
			model.addAttribute("type", type);
			return "/pages/role/detail";
		}

		Roles role = roleService.findRole(id);
		model.addAttribute("role", role);
		model.addAttribute("type", type);
		return "/pages/role/detail";
	}

	/**
	 * 
	 * <permissionTree> <功能详细描述>
	 * 
	 * @param role
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping("toPermissionTree")
	public String toPermissionTree(@RequestParam("id") Integer roleId, Model model) {
		if (roleId == null) {
			return "/pages/role/permission_tree";
		}
		
		List<Map<String, String>> permissions = roleService.findAllPermissions();
		
		model.addAttribute("roleId", roleId);
		model.addAttribute("permissions", JSONArray.toJSONString(permissions));
		return "/pages/role/permission_tree";
	}
	
	/**
	 * 
	 * <updatePermissionTree> <功能详细描述>
	 * 
	 * @param role
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping("updatePermissionTree")
	@ResponseBody
	public Object updatePermissionTree(String ids, String roleId, Model model, HttpSession session) {
		if (StringUtil.isEmpty(ids)) {
			throw new BizHandlerException("权限ID为空");
		}
		
		User user = (User) session.getAttribute("user");
		
		Roles role = roleService.findRole(Integer.parseInt(roleId));
		
		rolePermissionService.delPermissionByRoleId(Long.parseLong(roleId));
		String[] idArr = ids.split(",");
		for(String id : idArr) {
			Permissions permissions = permissionService.selectByPrimaryKey(Integer.parseInt(id));
			RolesPermissions record = new RolesPermissions();
			record.setRoleName(role.getRoleCode());
			record.setPermission(permissions.getPermissionName());
			record.setCreateBy(user.getRealname());
			record.setCreateTime(new Date());
			rolePermissionService.addPermission(record);
		}
		
		return 0;
	}

	/**
	 * 
	 * <addRole> <功能详细描述>
	 * 
	 * @param role
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping("addRole")
	@ResponseBody
	public Object addRole(HttpSession session, Roles role) {
		System.out.println("添加角色信息：" + role);
		User user = (User) session.getAttribute("user");
		role.setCreateBy(user.getRealname());
		role.setCreateTime(new Date());
		return roleService.addRole(role);
	}

	/**
	 * 
	 * <editRole> <功能详细描述>
	 * 
	 * @param role
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping("editRole")
	@ResponseBody
	public Object editRole(HttpSession session, Roles role) {
		System.out.println("修改角色信息：" + role);
		User user = (User) session.getAttribute("user");
		role.setUpdateBy(user.getRealname());
		role.setUpdateTime(new Date());
		return roleService.updateRole(role);
	}

	/**
	 * 
	 * <delRole> <功能详细描述>
	 * 
	 * @param role
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping("delRole")
	@ResponseBody
	public Object delRole(Integer id) {
		return roleService.delRole(id);
	}

	/**
	 * 
	 * <delRoles> <功能详细描述>
	 * 
	 * @param role
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping("delRoles")
	@ResponseBody
	public Object delRoles(String ids) {
		String[] split = ids.split(",");
		int rows = 0;
		for (String id : split) {
			roleService.delRole(Integer.parseInt(id));
			rows++;
		}
		return rows;
	}
}
