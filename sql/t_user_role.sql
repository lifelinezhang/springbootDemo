/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-02-27 16:19:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL,
  `is_valid` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '张三', '2', '2020-02-24', '2020-02-24', '0');
INSERT INTO `t_user_role` VALUES ('2', '张三', '3', '2020-02-24 19:31:25', '2020-02-24 19:31:30', '0');
INSERT INTO `t_user_role` VALUES ('3', '李四', '2', '2020-02-24 19:36:39', '2020-02-24 19:36:42', '0');
