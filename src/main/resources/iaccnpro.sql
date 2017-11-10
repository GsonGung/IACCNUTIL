/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : iaccnpro

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-10 09:31:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `module_id` varchar(255) NOT NULL COMMENT '菜单模块ID',
  `parent_id` varchar(255) DEFAULT NULL COMMENT '父级菜单ID',
  `en_code` varchar(255) DEFAULT NULL COMMENT '菜单编码',
  `full_name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `url_address` varchar(255) DEFAULT NULL COMMENT '菜单链接地址',
  `target` varchar(255) DEFAULT NULL COMMENT '是否展开   expand：展开  iframe：不展开',
  `type` varchar(100) DEFAULT NULL COMMENT '是否为菜单',
  `allow_expand` char(1) DEFAULT NULL COMMENT '是否允许展开',
  `is_public` char(1) DEFAULT NULL COMMENT '是不是公共的',
  `allow_edit` varchar(255) DEFAULT NULL COMMENT '是否允许编辑',
  `allow_delete` varchar(255) DEFAULT NULL COMMENT '是否允许删除',
  `status` int(4) DEFAULT '0' COMMENT '显示或隐藏，默认为0；  0：显示；1 ：隐藏  ',
  `sort_code` int(4) DEFAULT NULL COMMENT '排序编号',
  `is_delete` char(1) DEFAULT '0' COMMENT '删除描述',
  `available` char(1) DEFAULT '1',
  `description` varchar(255) DEFAULT NULL COMMENT '说明',
  `delete_reason` varchar(255) DEFAULT NULL,
  `permission_name` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建者名称',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改者名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='系统菜单信息表';

-- ----------------------------
-- Records of permissions
-- ----------------------------
INSERT INTO `permissions` VALUES ('1', '1', '0', 'SysManage', '系统管理', 'fa fa-desktop', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', null, null, 'system:show', '2017-08-27 00:00:00', null, '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('2', '2', '1', 'PwdManage', '密码生成', 'fa fa-leaf', 'toPassword', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '行政区域管理', null, 'system:pwd:show', '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('3', '3', '1', 'DBManage', '数据库信息', 'fa fa-book', 'toDBInfoManage', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '数据库信息', null, 'system:db:show', '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('4', '4', '1', 'MenuManage', '菜单管理', 'fa fa-leaf', 'toMenuManage', 'iframe', '1', '1', '0', null, null, '0', '3', '0', '1', '菜单管理', null, 'system:menu:show', '2017-08-27 19:52:10', '超级管理员', '2017-08-27 19:52:27', '超级管理员');
INSERT INTO `permissions` VALUES ('5', '5', '1', 'PlugManage', '插件管理', 'fa fa-desktop', 'toPlugManage', 'iframe', '1', '1', '0', null, null, '0', '4', '0', '1', '插件管理', null, 'system:plug:show', '2017-10-24 16:54:23', '超级管理员', '2017-10-24 16:54:36', '超级管理员');
INSERT INTO `permissions` VALUES ('6', '6', '0', 'Dashboard', 'Dashboard', 'fa fa-dashboard', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '工作台', null, 'system:dashboard:show', '2017-08-27 00:00:00', null, '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('7', '7', '6', 'Dashboard v1', 'Dashboard v1', 'fa fa-circle-o', 'toDashboardV1', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '工作台1', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('8', '8', '6', 'Dashboard v2', 'Dashboard v2', 'fa fa-circle-o', 'toDashboardV2', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '工作台2', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('9', '9', '0', 'Layout Options', 'Layout Options', 'fa fa-files-o', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2017-08-27 00:00:00', null, '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('10', '10', '9', 'Top Navigation', 'Top Navigation', 'fa fa-circle-o', 'toTopNavigation', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('11', '11', '9', 'Boxed', 'Boxed', 'fa fa-circle-o', 'toBoxed', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('12', '12', '9', 'Fixed', 'Fixed', 'fa fa-circle-o', 'toFixed', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('13', '13', '9', 'Collapsed Sidebar', 'Collapsed Sidebar', 'fa fa-circle-o', 'toCollapsedSidebar', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('14', '14', '0', 'Widgets', 'Widgets', 'fa fa-th', 'toWidgets', 'iframe', '0', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('15', '15', '0', 'Charts', 'Charts', 'fa fa-pie-chart', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2017-08-27 00:00:00', null, '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('16', '16', '15', 'ChartJS', 'ChartJS', 'fa fa-circle-o', 'toChartJS', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('17', '17', '15', 'Morris', 'Morris', 'fa fa-circle-o', 'toMorris', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('18', '18', '15', 'Flot', 'Flot', 'fa fa-circle-o', 'toFlot', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('19', '19', '15', 'Inline charts', 'Inline charts', 'fa fa-circle-o', 'toInlineCharts', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('20', '20', '0', 'UI Elements', 'UI Elements', 'fa fa-laptop', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2017-08-27 00:00:00', null, '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('21', '21', '20', 'General', 'General', 'fa fa-circle-o', 'toGeneral', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('22', '22', '20', 'Icons', 'Icons', 'fa fa-circle-o', 'toIcons', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('23', '23', '20', 'Buttons', 'Buttons', 'fa fa-circle-o', 'toButtons', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('24', '24', '20', 'Sliders', 'Sliders', 'fa fa-circle-o', 'toSliders', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('25', '25', '20', 'Timeline', 'Timeline', 'fa fa-circle-o', 'toTimeline', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('26', '26', '20', 'Modals', 'Modals', 'fa fa-circle-o', 'toModals', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('27', '27', '0', 'Forms', 'Forms', 'fa fa-edit', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2017-08-27 00:00:00', null, '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('28', '28', '27', 'General Elements', 'General Elements', 'fa fa-circle-o', 'toGeneralElements', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('29', '29', '27', 'Advanced Elements', 'Advanced Elements', 'fa fa-circle-o', 'toAdvancedElements', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('30', '30', '27', 'Editors', 'Editors', 'fa fa-circle-o', 'toEditors', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('31', '31', '0', 'Tables', 'Tables', 'fa fa-table', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2017-08-27 00:00:00', null, '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('32', '32', '31', 'Simple tables', 'Simple tables', 'fa fa-circle-o', 'toSimpleTables', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('33', '33', '31', 'Data tables', 'Data tables', 'fa fa-circle-o', 'toDataTables', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('34', '34', '0', 'Calendar', 'Calendar', 'fa fa-calendar', 'toCalendar', 'expand', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('35', '35', '0', 'Mailbox', 'Mailbox', 'fa fa-envelope', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2017-08-27 00:00:00', null, '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('36', '36', '35', 'Inbox', 'Inbox', 'fa fa-circle-o', 'toInbox', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('37', '37', '35', 'Compose', 'Compose', 'fa fa-circle-o', 'toCompose', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('38', '38', '35', 'Read', 'Read', 'fa fa-circle-o', 'toRead', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('39', '39', '0', 'Examples', 'Examples', 'fa fa-folder', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2017-08-27 00:00:00', null, '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('40', '40', '39', 'Invoice', 'Invoice', 'fa fa-circle-o', 'toInvoice', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('41', '41', '39', 'Profile', 'Profile', 'fa fa-circle-o', 'toProfile', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('42', '42', '39', 'Login', 'Login', 'fa fa-circle-o', 'toLogin', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('43', '43', '39', 'Register', 'Register', 'fa fa-circle-o', 'toRegister', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('44', '44', '39', 'Lockscreen', 'Lockscreen', 'fa fa-circle-o', 'toLockscreen', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('45', '45', '39', '404 Error', '404 Error', 'fa fa-circle-o', 'to404Error', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('46', '46', '39', '500 Error', '500 Error', 'fa fa-circle-o', 'to500Error', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('47', '47', '39', 'Blank Page', 'Blank Page', 'fa fa-circle-o', 'toBlankPage', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('48', '48', '39', 'Pace Page', 'Pace Page', 'fa fa-circle-o', 'toPacePage', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('49', '49', '0', 'Multilevel', 'Multilevel', 'fa fa-share', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2017-08-27 00:00:00', null, '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('50', '50', '49', 'Level One', 'Level One', 'fa fa-circle-o', 'toLevelOne', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('51', '51', '49', 'Level One', 'Level One', 'fa fa-circle-o', 'toLevelOne', 'expand', '0', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('52', '52', '49', 'Level One', 'Level One', 'fa fa-circle-o', 'toLevelOne', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('53', '53', '51', 'Level Two', 'Level Two', 'fa fa-circle-o', 'toLevelTwo', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('54', '54', '51', 'Level Two', 'Level Two', 'fa fa-circle-o', 'toLevelTwo', 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('55', '55', '54', 'Level Three', 'Level Three', 'fa fa-circle-o', 'toLevelTwo', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2017-08-27 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('56', '56', '54', 'Level Three', 'Level Three', 'fa fa-circle-o', 'toLevelTwo', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('57', '57', '0', 'Documentation', 'Documentation', 'fa fa-book', 'toDocumentation', 'expand', '1', '1', '0', null, null, '0', '1', '0', '1', '', null, null, '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');
INSERT INTO `permissions` VALUES ('58', '58', '1', '角色管理', '角色管理', 'fa fa-circle-o', 'toRoleManager', 'expand', '1', '1', '0', null, null, '0', '1', '0', '1', null, null, 'system:role:show', '2015-11-12 00:00:00', '超级管理员', '2016-04-29 00:00:00', '超级管理员');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role_code` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `available` char(1) DEFAULT '1',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', null, 'role1', '角色1', '1', '2017-11-09 16:30:31', null, '2017-11-09 16:30:31', null);
INSERT INTO `roles` VALUES ('2', null, 'role2', '角色2', '1', '2017-11-09 16:30:31', null, '2017-11-09 16:30:31', null);

-- ----------------------------
-- Table structure for roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `available` char(1) DEFAULT '1',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_roles_permissions` (`role_name`,`permission`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_permissions
-- ----------------------------
INSERT INTO `roles_permissions` VALUES ('1', 'role1', 'system:show', '1', '2017-11-09 16:36:07', null, '2017-11-09 16:36:30', null);
INSERT INTO `roles_permissions` VALUES ('2', 'role1', 'system:pwd:show', '1', '2017-11-09 16:37:07', null, '2017-11-09 16:37:07', null);
INSERT INTO `roles_permissions` VALUES ('5', 'role1', 'system:db:show', '1', '2017-11-09 16:37:11', null, '2017-11-09 16:37:11', null);
INSERT INTO `roles_permissions` VALUES ('6', 'role1', 'system:menu:show', '1', '2017-11-09 16:37:15', null, '2017-11-09 16:37:15', null);
INSERT INTO `roles_permissions` VALUES ('7', 'role1', 'system:plug:show', '1', '2017-11-09 16:37:26', null, '2017-11-09 16:37:26', null);
INSERT INTO `roles_permissions` VALUES ('8', 'role1', 'system:role:show', '1', '2017-11-09 16:37:52', null, '2017-11-09 16:37:52', null);
INSERT INTO `roles_permissions` VALUES ('9', 'role1', 'system:dashboard:show', '1', '2017-11-09 16:37:54', null, '2017-11-09 16:37:54', null);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `realname` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `available` char(1) DEFAULT '1',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'zhangsan', '张三', '123456', null, '1', 'dist/img/user1-128x128.jpg', '1', '2017-11-09 16:30:31', null, '2017-11-09 16:40:59', null);
INSERT INTO `users` VALUES ('2', 'lisi', '李四', '123456', null, '1', 'dist/img/user2-160x160.jpg', '1', '2017-11-09 16:30:31', null, '2017-11-09 16:40:59', null);
INSERT INTO `users` VALUES ('3', 'wangwu', '王五', '123456', null, '1', 'dist/img/user3-128x128.jpg', '1', '2017-11-09 16:30:31', null, '2017-11-09 16:41:00', null);
INSERT INTO `users` VALUES ('4', 'zhaoliu', '赵六', '123456', null, '1', 'dist/img/user4-128x128.jpg', '1', '2017-11-09 16:30:31', null, '2017-11-09 16:41:01', null);

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_roles
-- ----------------------------
INSERT INTO `user_roles` VALUES ('1', 'zhangsan', 'role1', '2017-11-09 16:30:31', null, '2017-11-09 16:40:48', null);
INSERT INTO `user_roles` VALUES ('2', 'zhangsan', 'role2', '2017-11-09 16:30:31', null, '2017-11-09 16:40:50', null);
