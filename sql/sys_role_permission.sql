/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : example

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-02-22 10:55:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效 1有效     2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='角色-权限关联表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '2', '101', '2017-11-22 16:26:21', '2017-11-22 16:26:32', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '2', '102', '2017-11-22 16:26:21', '2017-11-22 16:26:32', '1');
INSERT INTO `sys_role_permission` VALUES ('5', '2', '602', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('6', '2', '601', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('7', '2', '603', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('8', '2', '703', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('9', '2', '701', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('10', '2', '702', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('11', '2', '704', '2017-11-22 16:28:31', '2017-11-22 16:28:31', '1');
INSERT INTO `sys_role_permission` VALUES ('12', '2', '103', '2017-11-22 16:28:31', '2017-11-22 16:28:31', '1');
INSERT INTO `sys_role_permission` VALUES ('13', '3', '601', '2017-11-22 16:28:47', '2017-11-22 16:28:47', '1');
INSERT INTO `sys_role_permission` VALUES ('14', '3', '701', '2017-11-22 16:28:47', '2017-11-22 16:28:47', '1');
INSERT INTO `sys_role_permission` VALUES ('15', '3', '702', '2017-11-22 16:35:01', '2017-11-22 16:35:01', '1');
INSERT INTO `sys_role_permission` VALUES ('16', '3', '704', '2017-11-22 16:35:01', '2017-11-22 16:35:01', '1');
INSERT INTO `sys_role_permission` VALUES ('17', '3', '102', '2017-11-22 16:35:01', '2017-11-22 16:35:01', '1');
INSERT INTO `sys_role_permission` VALUES ('18', '3', '101', '2017-11-22 16:35:01', '2017-11-22 16:35:01', '1');
INSERT INTO `sys_role_permission` VALUES ('19', '3', '603', '2017-11-22 16:35:01', '2017-11-22 16:35:01', '1');
