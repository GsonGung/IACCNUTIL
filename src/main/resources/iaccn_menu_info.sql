/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : iaccnpro

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-01 16:07:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for iaccn_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `iaccn_menu_info`;
CREATE TABLE `iaccn_menu_info` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `IACCN_ModuleId` varchar(255) NOT NULL COMMENT '菜单模块ID',
  `IACCN_ParentId` varchar(255) DEFAULT NULL COMMENT '父级菜单ID',
  `IACCN_EnCode` varchar(255) DEFAULT NULL COMMENT '菜单编码',
  `IACCN_FullName` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `IACCN_Icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `IACCN_UrlAddress` varchar(255) DEFAULT NULL COMMENT '菜单链接地址',
  `IACCN_Target` varchar(255) DEFAULT NULL COMMENT '是否展开   expand：展开  iframe：不展开',
  `IACCN_IsMenu` int(4) DEFAULT NULL COMMENT '是否为菜单',
  `IACCN_AllowExpand` int(4) DEFAULT NULL COMMENT '是否允许展开',
  `IACCN_IsPublic` int(4) DEFAULT NULL COMMENT '是不是公共的',
  `IACCN_AllowEdit` varchar(255) DEFAULT NULL COMMENT '是否允许编辑',
  `IACCN_AllowDelete` varchar(255) DEFAULT NULL COMMENT '是否允许删除',
  `IACCN_Status` int(4) DEFAULT '0' COMMENT '显示或隐藏，默认为0；  0：显示；1 ：隐藏  ',
  `IACCN_SortCode` int(4) DEFAULT NULL COMMENT '排序编号',
  `IACCN_DeleteMark` int(4) DEFAULT NULL COMMENT '删除描述',
  `IACCN_EnabledMark` int(4) DEFAULT NULL,
  `IACCN_Description` varchar(255) DEFAULT NULL COMMENT '说明',
  `IACCN_CreateDate` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `IACCN_CreateUserId` varchar(255) DEFAULT NULL COMMENT '创建者编号',
  `IACCN_CreateUserName` varchar(255) DEFAULT NULL COMMENT '创建者名称',
  `IACCN_ModifyDate` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `IACCN_ModifyUserId` varchar(255) DEFAULT NULL COMMENT '修改者编号',
  `IACCN_ModifyUserName` varchar(255) DEFAULT NULL COMMENT '修改者名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='系统菜单信息表';

-- ----------------------------
-- Records of iaccn_menu_info
-- ----------------------------
INSERT INTO `iaccn_menu_info` VALUES ('1', '1', '0', 'SysManage', '系统管理', 'fa fa-desktop', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', null, '2017-08-27 00:00:00', null, null, '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('2', '2', '1', 'PwdManage', '密码生成', 'fa fa-leaf', 'toPassword', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '行政区域管理', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('3', '3', '1', 'DBManage', '数据库信息', 'fa fa-book', 'toDBInfoManage', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '数据库信息', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('4', '4', '1', 'MenuManage', '菜单管理', 'fa fa-leaf', 'toMenuManage', 'iframe', '1', '1', '0', null, null, '0', '3', '0', '1', '菜单管理', '2017-08-27 19:52:10', 'AndyGong', '超级管理员', '2017-08-27 19:52:27', 'AndyGong', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('5', '5', '1', 'PlugManage', '插件管理', 'fa fa-desktop', 'toPlugManage', 'iframe', '1', '1', '0', null, null, '0', '4', '0', '1', '插件管理', '2017-10-24 16:54:23', 'AndyGong', '超级管理员', '2017-10-24 16:54:36', 'AndyGong', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('6', '6', '0', 'Dashboard', 'Dashboard', 'fa fa-dashboard', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '工作台', '2017-08-27 00:00:00', null, null, '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('7', '7', '6', 'Dashboard v1', 'Dashboard v1', 'fa fa-circle-o', 'toDashboardV1', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '工作台1', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('8', '8', '6', 'Dashboard v2', 'Dashboard v2', 'fa fa-circle-o', 'toDashboardV2', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '工作台2', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('9', '9', '0', 'Layout Options', 'Layout Options', 'fa fa-files-o', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', '2017-08-27 00:00:00', null, null, '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('10', '10', '9', 'Top Navigation', 'Top Navigation', 'fa fa-circle-o', 'toTopNavigation', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('11', '11', '9', 'Boxed', 'Boxed', 'fa fa-circle-o', 'toBoxed', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('12', '12', '9', 'Fixed', 'Fixed', 'fa fa-circle-o', 'toFixed', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('13', '13', '9', 'Collapsed Sidebar', 'Collapsed Sidebar', 'fa fa-circle-o', 'toCollapsedSidebar', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('14', '14', '0', 'Widgets', 'Widgets', 'fa fa-th', 'toWidgets', 'iframe', '0', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('15', '15', '0', 'Charts', 'Charts', 'fa fa-pie-chart', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', '2017-08-27 00:00:00', null, null, '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('16', '16', '15', 'ChartJS', 'ChartJS', 'fa fa-circle-o', 'toChartJS', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('17', '17', '15', 'Morris', 'Morris', 'fa fa-circle-o', 'toMorris', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('18', '18', '15', 'Flot', 'Flot', 'fa fa-circle-o', 'toFlot', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('19', '19', '15', 'Inline charts', 'Inline charts', 'fa fa-circle-o', 'toInlineCharts', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('20', '20', '0', 'UI Elements', 'UI Elements', 'fa fa-laptop', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', '2017-08-27 00:00:00', null, null, '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('21', '21', '20', 'General', 'General', 'fa fa-circle-o', 'toGeneral', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('22', '22', '20', 'Icons', 'Icons', 'fa fa-circle-o', 'toIcons', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('23', '23', '20', 'Buttons', 'Buttons', 'fa fa-circle-o', 'toButtons', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('24', '24', '20', 'Sliders', 'Sliders', 'fa fa-circle-o', 'toSliders', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('25', '25', '20', 'Timeline', 'Timeline', 'fa fa-circle-o', 'toTimeline', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('26', '26', '20', 'Modals', 'Modals', 'fa fa-circle-o', 'toModals', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('27', '27', '0', 'Forms', 'Forms', 'fa fa-edit', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', '2017-08-27 00:00:00', null, null, '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('28', '28', '27', 'General Elements', 'General Elements', 'fa fa-circle-o', 'toGeneralElements', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('29', '29', '27', 'Advanced Elements', 'Advanced Elements', 'fa fa-circle-o', 'toAdvancedElements', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('30', '30', '27', 'Editors', 'Editors', 'fa fa-circle-o', 'toEditors', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('31', '31', '0', 'Tables', 'Tables', 'fa fa-table', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', '2017-08-27 00:00:00', null, null, '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('32', '32', '31', 'Simple tables', 'Simple tables', 'fa fa-circle-o', 'toSimpleTables', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('33', '33', '31', 'Data tables', 'Data tables', 'fa fa-circle-o', 'toDataTables', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('34', '34', '0', 'Calendar', 'Calendar', 'fa fa-calendar', 'toCalendar', 'expand', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('35', '35', '0', 'Mailbox', 'Mailbox', 'fa fa-envelope', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', '2017-08-27 00:00:00', null, null, '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('36', '36', '35', 'Inbox', 'Inbox', 'fa fa-circle-o', 'toInbox', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('37', '37', '35', 'Compose', 'Compose', 'fa fa-circle-o', 'toCompose', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('38', '38', '35', 'Read', 'Read', 'fa fa-circle-o', 'toRead', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('39', '39', '0', 'Examples', 'Examples', 'fa fa-folder', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', '2017-08-27 00:00:00', null, null, '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('40', '40', '39', 'Invoice', 'Invoice', 'fa fa-circle-o', 'toInvoice', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('41', '41', '39', 'Profile', 'Profile', 'fa fa-circle-o', 'toProfile', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('42', '42', '39', 'Login', 'Login', 'fa fa-circle-o', 'toLogin', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('43', '43', '39', 'Register', 'Register', 'fa fa-circle-o', 'toRegister', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('44', '44', '39', 'Lockscreen', 'Lockscreen', 'fa fa-circle-o', 'toLockscreen', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('45', '45', '39', '404 Error', '404 Error', 'fa fa-circle-o', 'to404Error', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('46', '46', '39', '500 Error', '500 Error', 'fa fa-circle-o', 'to500Error', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('47', '47', '39', 'Blank Page', 'Blank Page', 'fa fa-circle-o', 'toBlankPage', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('48', '48', '39', 'Pace Page', 'Pace Page', 'fa fa-circle-o', 'toPacePage', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('49', '49', '0', 'Multilevel', 'Multilevel', 'fa fa-share', null, 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', '2017-08-27 00:00:00', null, null, '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('50', '50', '49', 'Level One', 'Level One', 'fa fa-circle-o', 'toLevelOne', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('51', '51', '49', 'Level One', 'Level One', 'fa fa-circle-o', 'toLevelOne', 'expand', '0', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('52', '52', '49', 'Level One', 'Level One', 'fa fa-circle-o', 'toLevelOne', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('53', '53', '51', 'Level Two', 'Level Two', 'fa fa-circle-o', 'toLevelTwo', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('54', '54', '51', 'Level Two', 'Level Two', 'fa fa-circle-o', 'toLevelTwo', 'expand', '0', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('55', '55', '54', 'Level Three', 'Level Three', 'fa fa-circle-o', 'toLevelTwo', 'iframe', '1', '1', '0', null, null, '0', '2', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2017-08-27 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('56', '56', '54', 'Level Three', 'Level Three', 'fa fa-circle-o', 'toLevelTwo', 'iframe', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
INSERT INTO `iaccn_menu_info` VALUES ('57', '57', '0', 'Documentation', 'Documentation', 'fa fa-book', 'toDocumentation', 'expand', '1', '1', '0', null, null, '0', '1', '0', '1', '', '2015-11-12 00:00:00', 'System', '超级管理员', '2016-04-29 00:00:00', 'System', '超级管理员');
