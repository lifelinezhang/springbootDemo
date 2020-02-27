/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : example

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-02-22 10:55:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1有效  2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='后台角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '2017-11-22 16:24:34', '2017-11-22 16:24:52', '1');
INSERT INTO `sys_role` VALUES ('2', '作家', '2017-11-22 16:24:34', '2017-11-22 16:24:52', '1');
INSERT INTO `sys_role` VALUES ('3', '程序员', '2017-11-22 16:28:47', '2017-11-22 16:28:47', '1');
