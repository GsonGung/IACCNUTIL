/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : iaccnpro

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-03 16:58:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for iaccn_user_info
-- ----------------------------
DROP TABLE IF EXISTS `iaccn_user_info`;
CREATE TABLE `iaccn_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `realname` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iaccn_user_info
-- ----------------------------
INSERT INTO `iaccn_user_info` VALUES ('1', 'zhangsan', '张三', '123456', '1', 'dist/img/user1-128x128.jpg');
INSERT INTO `iaccn_user_info` VALUES ('2', 'lisi', '李四', '123456', '1', 'dist/img/user2-160x160.jpg');
INSERT INTO `iaccn_user_info` VALUES ('3', 'wangwu', '王五', '123456', '1', 'dist/img/user3-128x128.jpg');
INSERT INTO `iaccn_user_info` VALUES ('4', 'zhaoliu', '赵六', '123456', '1', 'dist/img/user4-128x128.jpg');
